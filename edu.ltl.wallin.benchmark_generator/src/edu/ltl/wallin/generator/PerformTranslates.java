package edu.ltl.wallin.generator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;

import edu.ltl.wallin.lTL.BinaryExpr;
import edu.ltl.wallin.lTL.Formula;
import edu.ltl.wallin.lTL.IdFormula;
import edu.ltl.wallin.lTL.LTLFactory;
import edu.ltl.wallin.lTL.UnaryExpr;

public class PerformTranslates {
	
	private final static int NUM_VARS = 5;
	private final static int NUM_TIME_STEPS = 5;
	
	private static void doubleNegation(Formula f) {
		TreeIterator<EObject> tree = f.eAllContents();
		EObject cur = f;
		do {
			if(cur instanceof UnaryExpr) {
				UnaryExpr f_cast = (UnaryExpr) cur;
				if(f_cast.getExpr() instanceof UnaryExpr) {
					UnaryExpr f_child_cast = (UnaryExpr) f_cast.getExpr();
					EcoreUtil2.replace(cur, f_child_cast.getExpr());
				}
			}
			cur = (tree.hasNext()) ? tree.next() : null;
		} while(cur != null);
	}
	
	private static void deMorgans(Formula f) {
		if(f instanceof IdFormula) return;
		if(f instanceof BinaryExpr) {
			BinaryExpr f_cast = (BinaryExpr) f;
			deMorgans(f_cast.getLeft());
			deMorgans(f_cast.getRight());
		}
		if(f instanceof UnaryExpr) {
			UnaryExpr f_cast = (UnaryExpr) f;
			if(f_cast.getExpr() instanceof BinaryExpr) {
				BinaryExpr f_child_cast = (BinaryExpr) f_cast.getExpr();
				String newOp = (f_child_cast.getOp().equals("&")) ? "|" : "&";
				BinaryExpr newConDis = LTLFactory.eINSTANCE.createBinaryExpr();
				newConDis.setOp(newOp);
				UnaryExpr newLeftNeg = LTLFactory.eINSTANCE.createUnaryExpr();
				newLeftNeg.setOp("-");
				newLeftNeg.setExpr(f_child_cast.getLeft());
				UnaryExpr newRightNeg = LTLFactory.eINSTANCE.createUnaryExpr();
				newRightNeg.setOp("-");
				newRightNeg.setExpr(f_child_cast.getRight());
				newConDis.setLeft(newLeftNeg);
				newConDis.setRight(newRightNeg);
				EcoreUtil.replace(f, newConDis);
				deMorgans(newConDis);
			}
		}
		
	}
	
	private static void distribute(Formula f) {
		//Hit a leaf: stop
		if(f instanceof IdFormula) return;
		
		//Negation could lead deeper; recurse lower
		if(f instanceof UnaryExpr) {
			UnaryExpr f_cast = (UnaryExpr) f;
			distribute(f_cast.getExpr());
		}
		
		
		if(f instanceof BinaryExpr) {
			
			BinaryExpr f_cast = (BinaryExpr) f;
			
			if(f_cast.getOp().equals("&")) {
				//If it's an '&', just recurse to each child
				distribute(f_cast.getLeft());
				distribute(f_cast.getRight());
			}else {
				//If it's an '|', look at children
				
				//If  both children are UnaryExpr or Id, we don't care
				if(f_cast.getLeft() instanceof BinaryExpr) {
					BinaryExpr f_child_cast = (BinaryExpr) f_cast.getLeft();
					if(f_child_cast.getOp().equals("&")) {
						//fix it
						BinaryExpr newConjunct = LTLFactory.eINSTANCE.createBinaryExpr();
						newConjunct.setOp("&");
						BinaryExpr leftDisjunct = LTLFactory.eINSTANCE.createBinaryExpr();
						leftDisjunct.setOp("|");
						BinaryExpr rightDisjunct = LTLFactory.eINSTANCE.createBinaryExpr();
						rightDisjunct.setOp("|");
						newConjunct.setLeft(leftDisjunct);
						newConjunct.setRight(rightDisjunct);
						
						leftDisjunct.setLeft(f_child_cast.getLeft());
						leftDisjunct.setRight(EcoreUtil2.copy(f_cast.getRight()));
						
						rightDisjunct.setRight(f_cast.getRight());
						rightDisjunct.setLeft(EcoreUtil2.copy(f_child_cast.getRight()));
						
						EcoreUtil2.replace(f, newConjunct);
						
						distribute(newConjunct);
					}
				} else if (f_cast.getRight() instanceof BinaryExpr) {
					BinaryExpr f_child_cast = (BinaryExpr) f_cast.getRight();
					if(f_child_cast.getOp().equals("&")) {
						//fix it
						BinaryExpr newConjunct = LTLFactory.eINSTANCE.createBinaryExpr();
						newConjunct.setOp("&");
						BinaryExpr leftDisjunct = LTLFactory.eINSTANCE.createBinaryExpr();
						leftDisjunct.setOp("|");
						BinaryExpr rightDisjunct = LTLFactory.eINSTANCE.createBinaryExpr();
						rightDisjunct.setOp("|");
						newConjunct.setLeft(leftDisjunct);
						newConjunct.setRight(rightDisjunct);
						
						leftDisjunct.setLeft(f_child_cast.getLeft());
						leftDisjunct.setRight(EcoreUtil2.copy(f_cast.getRight()));
						
						rightDisjunct.setRight(f_cast.getRight());
						rightDisjunct.setLeft(EcoreUtil2.copy(f_child_cast.getRight()));
						
						EcoreUtil2.replace(f, newConjunct);
						
						distribute(newConjunct);
						distribute(f);
					}
				}

				
			}
			
		}
		
	}

	
	private static void toCNF(Resource r) {
		Formula root = (Formula) EcoreUtil2.getRootContainer(r.getContents().get(0));
		//while(!isCNF(root)) {
			doubleNegation(root);
			root = (Formula) EcoreUtil2.getRootContainer(r.getContents().get(0));
			PerformTransforms.debugPrettyPrinter(root);
			deMorgans(root);
			root = (Formula) EcoreUtil2.getRootContainer(r.getContents().get(0));
			PerformTransforms.debugPrettyPrinter(root);
			distribute(root);
			root = (Formula) EcoreUtil2.getRootContainer(r.getContents().get(0));
			PerformTransforms.debugPrettyPrinter(root);
		//}
	}
	
	private static boolean isCNFHelper(Formula f) {
		if(f instanceof UnaryExpr) {
			UnaryExpr f_cast = (UnaryExpr) f;
			return f_cast.getExpr() instanceof IdFormula;
		}else if(f instanceof BinaryExpr) {
			BinaryExpr f_cast = (BinaryExpr) f;
			if(f_cast.getOp().equals("|")) {
				if(f_cast.getLeft() instanceof BinaryExpr) {
					BinaryExpr f_child_cast = (BinaryExpr) f_cast.getLeft();
					return f_child_cast.getOp() != "&";
				}
				if(f_cast.getRight() instanceof BinaryExpr) {
					BinaryExpr f_child_cast = (BinaryExpr) f_cast.getRight();
					return f_child_cast.getOp() != "&";
				}
			}
			return true;
		}else {
			return true;
		}
	}
	
	private static boolean isCNF(Formula f) {
		TreeIterator<EObject> tree = f.eAllContents();
		EObject cur;
		if(!isCNFHelper(f)) return false;
		while(tree.hasNext()) {
			cur = tree.next();
			if(!isCNFHelper((Formula) cur)) return false;
		}
		return true;
	}
	
	private static void translateProp(Formula f) {
		TreeIterator<EObject> allContents = f.eAllContents();
		EObject cur;
		
		while(allContents.hasNext()) {
			cur = allContents.next();
			if(cur instanceof BinaryExpr && ((BinaryExpr)cur).getOp() != "&" && ((BinaryExpr)cur).getOp() != "|"){

				
			}else if(cur instanceof UnaryExpr && ((UnaryExpr)cur).getOp() != "-") {
				UnaryExpr curCast = (UnaryExpr) cur;
				int lowerBound = curCast.getLowerBound();
				int upperBound = curCast.getUpperBound();
				String newOp = (curCast.getOp().equals("G")) ? "&" : "|";
				List<Formula> newChildren = new ArrayList<>();
				int i = 0;
				for(; i <= upperBound - lowerBound; i++) {
					newChildren.add(EcoreUtil2.copy(curCast.getExpr()));
					TreeIterator<EObject> iterateChildren = newChildren.get(i).eAllContents();
					EObject curChild = newChildren.get(i);
					do{
						if(curChild instanceof IdFormula) {
							IdFormula curChildCast = (IdFormula) curChild;
							curChildCast.setVarName(curChildCast.getVarName() + Integer.toString(i + lowerBound));
						}
						curChild = (iterateChildren.hasNext()) ? iterateChildren.next() : null;
					}while(curChild != null);
				}
				Formula newParent = LTLFactory.eINSTANCE.createFormula();
				if(newChildren.size() > 1) {
					BinaryExpr newChildExpr = LTLFactory.eINSTANCE.createBinaryExpr();
					BinaryExpr newChildHead = newChildExpr;
					newChildExpr.setLeft(newChildren.get(0));
					newChildExpr.setOp(newOp);
					i = 1;
					while(i < newChildren.size() - 1) {
						newChildExpr.setRight(LTLFactory.eINSTANCE.createBinaryExpr());
						newChildExpr = (BinaryExpr) newChildExpr.getRight();
						newChildExpr.setOp(newOp);
						newChildExpr.setLeft(newChildren.get(i));
						i++;
					}
					newChildExpr.setRight(newChildren.get(i));
					newParent = newChildHead;
				}else {
					UnaryExpr newChildExpr = LTLFactory.eINSTANCE.createUnaryExpr();
					newChildExpr.setExpr(newChildren.get(0));
					newParent = newChildExpr;
				}
				EcoreUtil2.replace(cur, newParent);
			}
		}
		
	}
	
	private static void translateVars(Formula f) {
		TreeIterator<EObject> allFormula = f.eAllContents();
		EObject cur;
		while(allFormula.hasNext()) {
			cur = allFormula.next();
			if(cur instanceof IdFormula) {
				int letter = ((int) ((IdFormula)cur).getVarName().charAt(0)) - ((int) 'a');
				int time_step = Integer.parseInt(((IdFormula)cur).getVarName().substring(1));
				System.out.println(letter + "," + time_step);
				((IdFormula)cur).setVarName(Integer.toString(letter * NUM_TIME_STEPS + time_step + 1));
			}
		}
	}
	
	public static void translateFormula(Resource r) {
		Formula root = (Formula) EcoreUtil2.getRootContainer(r.getContents().get(0));
		PerformTransforms.debugPrettyPrinter(root);
		
		translateProp(root);
		root = (Formula) EcoreUtil2.getRootContainer(r.getContents().get(0));
		PerformTransforms.debugPrettyPrinter(root);
		translateVars(root);
		root = (Formula) EcoreUtil2.getRootContainer(r.getContents().get(0));
		toCNF(r);
		root = (Formula) EcoreUtil2.getRootContainer(r.getContents().get(0));
		
		PerformTransforms.debugPrettyPrinter(root);
		System.out.println(isCNF(root));
	}
	
}
