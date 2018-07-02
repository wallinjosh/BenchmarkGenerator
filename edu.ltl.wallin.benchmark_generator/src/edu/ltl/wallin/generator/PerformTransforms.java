package edu.ltl.wallin.generator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.ltl.wallin.lTL.BinaryExpr;
import edu.ltl.wallin.lTL.Formula;
import edu.ltl.wallin.lTL.IdFormula;
import edu.ltl.wallin.lTL.LTLFactory;
import edu.ltl.wallin.lTL.UnaryExpr;

import org.eclipse.xtext.EcoreUtil2;

public class PerformTransforms {

	
	
	public static void debugPrettyPrinterHelper(Formula f) {
		if(f instanceof UnaryExpr) {
			UnaryExpr castUnary = (UnaryExpr) f;
			System.out.print(castUnary.getOp());
			if(castUnary.getLowerBound() != castUnary.getUpperBound()) System.out.print("[" + castUnary.getLowerBound() + "," + castUnary.getUpperBound() + "] ");
			System.out.print("(");
			if(!castUnary.eContents().isEmpty()) {
				debugPrettyPrinterHelper((Formula) castUnary.getExpr());
			}
			System.out.print(")");
		} else if(f instanceof BinaryExpr) {
			BinaryExpr castBinary = (BinaryExpr) f;
			System.out.print("(");
			System.out.print("(");
			debugPrettyPrinterHelper(castBinary.getLeft());
			System.out.print(")");
			System.out.print(" " + castBinary.getOp() + "");
			if(castBinary.getLowerBound() != castBinary.getUpperBound()) {
				System.out.print("[" + castBinary.getLowerBound() + "," + castBinary.getUpperBound() + "] ");
			}
			System.out.print("(");
			debugPrettyPrinterHelper(castBinary.getRight());
			System.out.print(")");
			System.out.print(")");
		} else if (f instanceof IdFormula) {
			System.out.print(((IdFormula)f).getVarName());
		}
	}
	
	static void debugPrettyPrinter(Formula f) {
		debugPrettyPrinterHelper(f);
		System.out.print("\n");
	}
	
	static BinaryExpr composeBinaryExpr(ArrayList<Formula> subFormulas, String op) {
		BinaryExpr newFormula = LTLFactory.eINSTANCE.createBinaryExpr();
		newFormula.setOp(op);
		BinaryExpr travFormula = newFormula;
		
		int i = 0;
		travFormula.setLeft(subFormulas.get(i));
		for(i = 1; i < subFormulas.size() - 1; i++) {
			travFormula.setRight(LTLFactory.eINSTANCE.createBinaryExpr());
			travFormula = (BinaryExpr) travFormula.getRight();
			travFormula.setOp(op);
			travFormula.setLeft(subFormulas.get(i));
		}
		travFormula.setRight(subFormulas.get(i));
		
		return newFormula;
	}
	
	static void setTimeBounds(Formula f, int lowerBound, int upperBound) {
		if(f instanceof BinaryExpr) {
			((BinaryExpr) f).setLowerBound(lowerBound);
			((BinaryExpr) f).setUpperBound(upperBound);
		}else if(f instanceof UnaryExpr) {
			((UnaryExpr) f).setLowerBound(lowerBound);
			((UnaryExpr) f).setUpperBound(upperBound);
		}else {
			return;
		}
	}
	
	static int getLowerBound(Formula f) {
		if(f instanceof BinaryExpr) {
			return ((BinaryExpr)f).getLowerBound();
		} else if(f instanceof UnaryExpr) {
			return ((UnaryExpr)f).getLowerBound();
		} else return -1;
	}
	
	static int getUpperBound(Formula f) {
		if(f instanceof BinaryExpr) {
			return ((BinaryExpr)f).getUpperBound();
		} else if(f instanceof UnaryExpr) {
			return ((UnaryExpr)f).getUpperBound();
		} else return -1;
	}
	
	static String getOp(Formula f) {
//		if(f instanceof BinaryExpr && f != null) {
//			return ((BinaryExpr)f).getOp();
//		}else if(f instanceof UnaryExpr && f != null) {
//			return ((UnaryExpr)f).getOp();
//		} else {
			return " ";
//		}
	}
	
	public static void recursiveTransform(Formula f) {
		
		//If f is a 'connective formula', just simplify each side
		if(getOp(f).equals("&") || getOp(f).equals("|")) {
			recursiveTransform(((BinaryExpr)f).getLeft());
			recursiveTransform(((BinaryExpr)f).getRight());
			return;
		}
		
		//If f is an 'until formula', simplify both sides together, then call recursiveTransform on new root
		if(f instanceof BinaryExpr) {
			BinaryExpr f_cast = (BinaryExpr) f;
			Formula f_left_child = f_cast.getLeft();
			Formula f_right_child = f_cast.getRight();
			ArrayList<Formula> disjunctChildren = new ArrayList<Formula>();
			//Super disjunct loop
			int curLine = 0;
			for(int i = f_cast.getLowerBound(); i <= f_cast.getUpperBound(); i++) {
				//ArrayList used to hold children AT EACH LOOP
				ArrayList<Formula> newClauseChildren = new ArrayList<Formula>();
				//Get left side children
				int j = f_cast.getLowerBound();
				for(; j < f_cast.getLowerBound() + curLine; j++) {
					Formula newChild = LTLFactory.eINSTANCE.createFormula();
					newChild = EcoreUtil.copy(f_left_child);
					int newLowerBound = getLowerBound(f_left_child) + i;
					int newUpperBound = getUpperBound(f_left_child) + i;
					setTimeBounds(newChild, newLowerBound, newUpperBound);
					newClauseChildren.add(newChild);
				}
				
				//Add right side child
				Formula newChild = LTLFactory.eINSTANCE.createFormula();
				newChild = EcoreUtil.copy(f_right_child);
				int newLowerBound = getLowerBound(f_right_child) + i;
				int newUpperBound = getUpperBound(f_right_child) + i;
				setTimeBounds(newChild, newLowerBound, newUpperBound);
				newClauseChildren.add(newChild);
				
				disjunctChildren.add(composeBinaryExpr(newClauseChildren, "&"));
				
				curLine++;
			}
			BinaryExpr newDisjunct = composeBinaryExpr(disjunctChildren, "|");
			EcoreUtil2.replace(f, newDisjunct);
			recursiveTransform(newDisjunct);
			return;
		}
		
		//If f is a literal, no simplification is necessary; just return
		if(f instanceof IdFormula) return;
		
		//Only option left: f is a UnaryExpr;
		UnaryExpr uexpr = (UnaryExpr) f;
		Formula originalChild = uexpr.getExpr();
		
//		//If it it is just a negation recurse inside
//		if(uexpr.getOp().equals("-")) {
//			recursiveTransform(originalChild);
//			return;
//		}
		
		
		//If it is a 'globally formula' or a 'eventually formula', then simplify
		String newOp = (uexpr.getOp().equals("G")) ? "&" : "|";
		
		//Only special case: the child is an Until expression.
		if(getOp(originalChild).equals("U")) {
			
		}else {
			List<Formula> newChildren = new ArrayList<>();
			for(int i = 0; i < uexpr.getUpperBound() - uexpr.getLowerBound(); i++) {
				int newLowerBound = uexpr.getLowerBound() + getLowerBound(originalChild) + i;
				int newUpperBound = uexpr.getUpperBound() + getUpperBound(originalChild) + i;
				Formula newChild = EcoreUtil2.copy(originalChild);
				setTimeBounds(newChild, newLowerBound, newUpperBound);
				newChildren.add(newChild);
			}
			//Create a new formula to replace the original parent
			Formula newParent = LTLFactory.eINSTANCE.createFormula();
			//Case 1: More than one child: need to create a series of nested BinaryExpr to hold new children
			if(newChildren.size() > 1) {
				BinaryExpr disjuncts = LTLFactory.eINSTANCE.createBinaryExpr();
				BinaryExpr head = disjuncts;
				disjuncts.setLeft(newChildren.get(0));
				disjuncts.setOp(newOp);
				int i = 1;
				for(; i < newChildren.size() - 1; i++) {
					disjuncts.setRight(LTLFactory.eINSTANCE.createBinaryExpr());
					disjuncts = (BinaryExpr) disjuncts.getRight();
					disjuncts.setLeft(newChildren.get(i));
					disjuncts.setOp(newOp);
				}
				disjuncts.setRight(newChildren.get(i));
				newParent = head;
			}//Case 2: Single child: can just throw child into new UnaryExpr
			else if(!newChildren.isEmpty()) {
				UnaryExpr newUnary = LTLFactory.eINSTANCE.createUnaryExpr();
				newUnary.setExpr(newChildren.get(0));
				newParent = newUnary;
			}else if(newChildren.isEmpty()) return;
			//Replace the (now expanded) temporal parent with the expanded children
			EcoreUtil2.replace(uexpr, newParent);
			//Start from the new parent and continue expanding
			recursiveTransform(newParent);
			return;
		}
		
//		if(originalChild instanceof BinaryExpr) {
//			BinaryExpr originalBinaryExprChild = (BinaryExpr) originalChild;
//			//Case 1: Child is a 'U' expression: need to do special things for temporal operator
//			if(originalBinaryExprChild.getOp().equals("U")) {
//				
//			}//Case 2: Child just has a normal logical connective; distribute the temporal parent
//			else{
//				
//			}
//		}else if(originalChild instanceof UnaryExpr) {
//			List<UnaryExpr> newChildren = new ArrayList<>();
//			UnaryExpr originalUnaryExprChild = (UnaryExpr) originalChild;
//			//Create (upperBound - lowerBound) copies of the original child;
//			//Adjust their time bounds appropriately
//			for(int i = 0; i <= (uexpr.getUpperBound() - uexpr.getLowerBound()); i++) {
//				int newLowerBound = uexpr.getLowerBound() + originalUnaryExprChild.getLowerBound() + i;
//				int newUpperBound = newLowerBound + (originalUnaryExprChild.getUpperBound() - originalUnaryExprChild.getLowerBound());
//				UnaryExpr newChild = (UnaryExpr) EcoreUtil2.copy(originalChild);
//				newChild.setLowerBound(newLowerBound);
//				newChild.setUpperBound(newUpperBound);
//				newChildren.add(newChild);
//			}
//			//Create a new formula to replace the original parent
//			Formula newParent = LTLFactory.eINSTANCE.createFormula();
//			//Case 1: More than one child: need to create a series of nested BinaryExpr to hold new children
//			if(newChildren.size() > 1) {
//				BinaryExpr disjuncts = LTLFactory.eINSTANCE.createBinaryExpr();
//				BinaryExpr head = disjuncts;
//				disjuncts.setLeft(newChildren.get(0));
//				disjuncts.setOp(newOp);
//				int i = 1;
//				for(; i < newChildren.size() - 1; i++) {
//					disjuncts.setRight(LTLFactory.eINSTANCE.createBinaryExpr());
//					disjuncts = (BinaryExpr) disjuncts.getRight();
//					disjuncts.setLeft(newChildren.get(i));
//					disjuncts.setOp(newOp);
//				}
//				disjuncts.setRight(newChildren.get(i));
//				newParent = head;
//			}//Case 2: Single child: can just throw child into new UnaryExpr
//			else if(!newChildren.isEmpty()) {
//				UnaryExpr newUnary = LTLFactory.eINSTANCE.createUnaryExpr();
//				newUnary.setExpr(newChildren.get(0));
//				newParent = newUnary;
//			}
//			//Replace the (now expanded) temporal parent with the expanded children
//			EcoreUtil2.replace(uexpr, newParent);
//			//Start from the new parent and continue expanding
//			recursiveTransform(newParent);
//			return;
//		}
		
	}
	

	public static void transformFormula(Resource r) {
			Formula root = (Formula) EcoreUtil2.getRootContainer(r.getContents().get(0));
			System.out.print("[Transform] Input: ");
			debugPrettyPrinter(root);
			recursiveTransform(root);
			root = (Formula) EcoreUtil2.getRootContainer(r.getContents().get(0));
			System.out.print("[Transform] Output: ");
			debugPrettyPrinter(root);
	}
	
}

