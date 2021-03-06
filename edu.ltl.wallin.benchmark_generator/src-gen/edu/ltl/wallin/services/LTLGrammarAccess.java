/*
 * generated by Xtext 2.14.0
 */
package edu.ltl.wallin.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class LTLGrammarAccess extends AbstractGrammarElementFinder {
	
	public class FormulaElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "edu.ltl.wallin.LTL.Formula");
		private final RuleCall cUntilFormulaParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//Formula:
		//	UntilFormula;
		@Override public ParserRule getRule() { return rule; }
		
		//UntilFormula
		public RuleCall getUntilFormulaParserRuleCall() { return cUntilFormulaParserRuleCall; }
	}
	public class UntilFormulaElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "edu.ltl.wallin.LTL.UntilFormula");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cConnectiveFormulaParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cBinaryExprLeftAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cOpAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final Keyword cOpUKeyword_1_0_0_1_0 = (Keyword)cOpAssignment_1_0_0_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_1_0_0_2 = (Keyword)cGroup_1_0_0.eContents().get(2);
		private final Assignment cLowerBoundAssignment_1_0_0_3 = (Assignment)cGroup_1_0_0.eContents().get(3);
		private final RuleCall cLowerBoundINTTerminalRuleCall_1_0_0_3_0 = (RuleCall)cLowerBoundAssignment_1_0_0_3.eContents().get(0);
		private final Keyword cCommaKeyword_1_0_0_4 = (Keyword)cGroup_1_0_0.eContents().get(4);
		private final Assignment cEndAssignment_1_0_0_5 = (Assignment)cGroup_1_0_0.eContents().get(5);
		private final Keyword cEndEndKeyword_1_0_0_5_0 = (Keyword)cEndAssignment_1_0_0_5.eContents().get(0);
		private final Assignment cUpperBoundAssignment_1_0_0_6 = (Assignment)cGroup_1_0_0.eContents().get(6);
		private final RuleCall cUpperBoundINTTerminalRuleCall_1_0_0_6_0 = (RuleCall)cUpperBoundAssignment_1_0_0_6.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_1_0_0_7 = (Keyword)cGroup_1_0_0.eContents().get(7);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightConnectiveFormulaParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//UntilFormula Formula:
		//	ConnectiveFormula (=> ({BinaryExpr.left=current} op='U' '[' lowerBound=INT? ',' end?='end'? upperBound=INT? ']')
		//	right=ConnectiveFormula)*;
		@Override public ParserRule getRule() { return rule; }
		
		//ConnectiveFormula (=> ({BinaryExpr.left=current} op='U' '[' lowerBound=INT? ',' end?='end'? upperBound=INT? ']')
		//right=ConnectiveFormula)*
		public Group getGroup() { return cGroup; }
		
		//ConnectiveFormula
		public RuleCall getConnectiveFormulaParserRuleCall_0() { return cConnectiveFormulaParserRuleCall_0; }
		
		//(=> ({BinaryExpr.left=current} op='U' '[' lowerBound=INT? ',' end?='end'? upperBound=INT? ']') right=ConnectiveFormula)*
		public Group getGroup_1() { return cGroup_1; }
		
		//=> ({BinaryExpr.left=current} op='U' '[' lowerBound=INT? ',' end?='end'? upperBound=INT? ']')
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{BinaryExpr.left=current} op='U' '[' lowerBound=INT? ',' end?='end'? upperBound=INT? ']'
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//{BinaryExpr.left=current}
		public Action getBinaryExprLeftAction_1_0_0_0() { return cBinaryExprLeftAction_1_0_0_0; }
		
		//op='U'
		public Assignment getOpAssignment_1_0_0_1() { return cOpAssignment_1_0_0_1; }
		
		//'U'
		public Keyword getOpUKeyword_1_0_0_1_0() { return cOpUKeyword_1_0_0_1_0; }
		
		//'['
		public Keyword getLeftSquareBracketKeyword_1_0_0_2() { return cLeftSquareBracketKeyword_1_0_0_2; }
		
		//lowerBound=INT?
		public Assignment getLowerBoundAssignment_1_0_0_3() { return cLowerBoundAssignment_1_0_0_3; }
		
		//INT
		public RuleCall getLowerBoundINTTerminalRuleCall_1_0_0_3_0() { return cLowerBoundINTTerminalRuleCall_1_0_0_3_0; }
		
		//','
		public Keyword getCommaKeyword_1_0_0_4() { return cCommaKeyword_1_0_0_4; }
		
		//end?='end'?
		public Assignment getEndAssignment_1_0_0_5() { return cEndAssignment_1_0_0_5; }
		
		//'end'
		public Keyword getEndEndKeyword_1_0_0_5_0() { return cEndEndKeyword_1_0_0_5_0; }
		
		//upperBound=INT?
		public Assignment getUpperBoundAssignment_1_0_0_6() { return cUpperBoundAssignment_1_0_0_6; }
		
		//INT
		public RuleCall getUpperBoundINTTerminalRuleCall_1_0_0_6_0() { return cUpperBoundINTTerminalRuleCall_1_0_0_6_0; }
		
		//']'
		public Keyword getRightSquareBracketKeyword_1_0_0_7() { return cRightSquareBracketKeyword_1_0_0_7; }
		
		//right=ConnectiveFormula
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }
		
		//ConnectiveFormula
		public RuleCall getRightConnectiveFormulaParserRuleCall_1_1_0() { return cRightConnectiveFormulaParserRuleCall_1_1_0; }
	}
	public class ConnectiveFormulaElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "edu.ltl.wallin.LTL.ConnectiveFormula");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cUnaryExprParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cBinaryExprLeftAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cOpAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final Alternatives cOpAlternatives_1_0_0_1_0 = (Alternatives)cOpAssignment_1_0_0_1.eContents().get(0);
		private final Keyword cOpAmpersandKeyword_1_0_0_1_0_0 = (Keyword)cOpAlternatives_1_0_0_1_0.eContents().get(0);
		private final Keyword cOpVerticalLineKeyword_1_0_0_1_0_1 = (Keyword)cOpAlternatives_1_0_0_1_0.eContents().get(1);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightUnaryExprParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//ConnectiveFormula Formula:
		//	UnaryExpr (=> ({BinaryExpr.left=current} op=('&' | '|')) right=UnaryExpr)*;
		@Override public ParserRule getRule() { return rule; }
		
		//UnaryExpr (=> ({BinaryExpr.left=current} op=('&' | '|')) right=UnaryExpr)*
		public Group getGroup() { return cGroup; }
		
		//UnaryExpr
		public RuleCall getUnaryExprParserRuleCall_0() { return cUnaryExprParserRuleCall_0; }
		
		//(=> ({BinaryExpr.left=current} op=('&' | '|')) right=UnaryExpr)*
		public Group getGroup_1() { return cGroup_1; }
		
		//=> ({BinaryExpr.left=current} op=('&' | '|'))
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{BinaryExpr.left=current} op=('&' | '|')
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//{BinaryExpr.left=current}
		public Action getBinaryExprLeftAction_1_0_0_0() { return cBinaryExprLeftAction_1_0_0_0; }
		
		//op=('&' | '|')
		public Assignment getOpAssignment_1_0_0_1() { return cOpAssignment_1_0_0_1; }
		
		//('&' | '|')
		public Alternatives getOpAlternatives_1_0_0_1_0() { return cOpAlternatives_1_0_0_1_0; }
		
		//'&'
		public Keyword getOpAmpersandKeyword_1_0_0_1_0_0() { return cOpAmpersandKeyword_1_0_0_1_0_0; }
		
		//'|'
		public Keyword getOpVerticalLineKeyword_1_0_0_1_0_1() { return cOpVerticalLineKeyword_1_0_0_1_0_1; }
		
		//right=UnaryExpr
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }
		
		//UnaryExpr
		public RuleCall getRightUnaryExprParserRuleCall_1_1_0() { return cRightUnaryExprParserRuleCall_1_1_0; }
	}
	public class UnaryExprElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "edu.ltl.wallin.LTL.UnaryExpr");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cUnaryExprAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Assignment cOpAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final Alternatives cOpAlternatives_0_1_0 = (Alternatives)cOpAssignment_0_1.eContents().get(0);
		private final Keyword cOpFKeyword_0_1_0_0 = (Keyword)cOpAlternatives_0_1_0.eContents().get(0);
		private final Keyword cOpGKeyword_0_1_0_1 = (Keyword)cOpAlternatives_0_1_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final Assignment cLowerBoundAssignment_0_3 = (Assignment)cGroup_0.eContents().get(3);
		private final RuleCall cLowerBoundINTTerminalRuleCall_0_3_0 = (RuleCall)cLowerBoundAssignment_0_3.eContents().get(0);
		private final Keyword cCommaKeyword_0_4 = (Keyword)cGroup_0.eContents().get(4);
		private final Assignment cEndAssignment_0_5 = (Assignment)cGroup_0.eContents().get(5);
		private final Keyword cEndEndKeyword_0_5_0 = (Keyword)cEndAssignment_0_5.eContents().get(0);
		private final Assignment cUpperBoundAssignment_0_6 = (Assignment)cGroup_0.eContents().get(6);
		private final RuleCall cUpperBoundINTTerminalRuleCall_0_6_0 = (RuleCall)cUpperBoundAssignment_0_6.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_0_7 = (Keyword)cGroup_0.eContents().get(7);
		private final Assignment cExprAssignment_0_8 = (Assignment)cGroup_0.eContents().get(8);
		private final RuleCall cExprUnaryExprParserRuleCall_0_8_0 = (RuleCall)cExprAssignment_0_8.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cUnaryExprAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Keyword cOpHyphenMinusKeyword_1_1_0 = (Keyword)cOpAssignment_1_1.eContents().get(0);
		private final Assignment cExprAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cExprUnaryExprParserRuleCall_1_2_0 = (RuleCall)cExprAssignment_1_2.eContents().get(0);
		private final RuleCall cLiteralParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//UnaryExpr Formula:
		//	{UnaryExpr} op=('F' | 'G') '[' lowerBound=INT? ',' end?='end'? upperBound=INT? ']' expr=UnaryExpr
		//	| {UnaryExpr} op='-' expr=UnaryExpr
		//	| Literal;
		@Override public ParserRule getRule() { return rule; }
		
		//{UnaryExpr} op=('F' | 'G') '[' lowerBound=INT? ',' end?='end'? upperBound=INT? ']' expr=UnaryExpr | {UnaryExpr} op='-'
		//expr=UnaryExpr | Literal
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//{UnaryExpr} op=('F' | 'G') '[' lowerBound=INT? ',' end?='end'? upperBound=INT? ']' expr=UnaryExpr
		public Group getGroup_0() { return cGroup_0; }
		
		//{UnaryExpr}
		public Action getUnaryExprAction_0_0() { return cUnaryExprAction_0_0; }
		
		//op=('F' | 'G')
		public Assignment getOpAssignment_0_1() { return cOpAssignment_0_1; }
		
		//('F' | 'G')
		public Alternatives getOpAlternatives_0_1_0() { return cOpAlternatives_0_1_0; }
		
		//'F'
		public Keyword getOpFKeyword_0_1_0_0() { return cOpFKeyword_0_1_0_0; }
		
		//'G'
		public Keyword getOpGKeyword_0_1_0_1() { return cOpGKeyword_0_1_0_1; }
		
		//'['
		public Keyword getLeftSquareBracketKeyword_0_2() { return cLeftSquareBracketKeyword_0_2; }
		
		//lowerBound=INT?
		public Assignment getLowerBoundAssignment_0_3() { return cLowerBoundAssignment_0_3; }
		
		//INT
		public RuleCall getLowerBoundINTTerminalRuleCall_0_3_0() { return cLowerBoundINTTerminalRuleCall_0_3_0; }
		
		//','
		public Keyword getCommaKeyword_0_4() { return cCommaKeyword_0_4; }
		
		//end?='end'?
		public Assignment getEndAssignment_0_5() { return cEndAssignment_0_5; }
		
		//'end'
		public Keyword getEndEndKeyword_0_5_0() { return cEndEndKeyword_0_5_0; }
		
		//upperBound=INT?
		public Assignment getUpperBoundAssignment_0_6() { return cUpperBoundAssignment_0_6; }
		
		//INT
		public RuleCall getUpperBoundINTTerminalRuleCall_0_6_0() { return cUpperBoundINTTerminalRuleCall_0_6_0; }
		
		//']'
		public Keyword getRightSquareBracketKeyword_0_7() { return cRightSquareBracketKeyword_0_7; }
		
		//expr=UnaryExpr
		public Assignment getExprAssignment_0_8() { return cExprAssignment_0_8; }
		
		//UnaryExpr
		public RuleCall getExprUnaryExprParserRuleCall_0_8_0() { return cExprUnaryExprParserRuleCall_0_8_0; }
		
		//{UnaryExpr} op='-' expr=UnaryExpr
		public Group getGroup_1() { return cGroup_1; }
		
		//{UnaryExpr}
		public Action getUnaryExprAction_1_0() { return cUnaryExprAction_1_0; }
		
		//op='-'
		public Assignment getOpAssignment_1_1() { return cOpAssignment_1_1; }
		
		//'-'
		public Keyword getOpHyphenMinusKeyword_1_1_0() { return cOpHyphenMinusKeyword_1_1_0; }
		
		//expr=UnaryExpr
		public Assignment getExprAssignment_1_2() { return cExprAssignment_1_2; }
		
		//UnaryExpr
		public RuleCall getExprUnaryExprParserRuleCall_1_2_0() { return cExprUnaryExprParserRuleCall_1_2_0; }
		
		//Literal
		public RuleCall getLiteralParserRuleCall_2() { return cLiteralParserRuleCall_2; }
	}
	public class LiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "edu.ltl.wallin.LTL.Literal");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cIdFormulaAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Assignment cVarNameAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cVarNameVAR_NAMETerminalRuleCall_0_1_0 = (RuleCall)cVarNameAssignment_0_1.eContents().get(0);
		private final Group cGroup_0_2 = (Group)cGroup_0.eContents().get(2);
		private final Keyword cLowerKeyword_0_2_0 = (Keyword)cGroup_0_2.eContents().get(0);
		private final Assignment cLowerBoundAssignment_0_2_1 = (Assignment)cGroup_0_2.eContents().get(1);
		private final RuleCall cLowerBoundINTTerminalRuleCall_0_2_1_0 = (RuleCall)cLowerBoundAssignment_0_2_1.eContents().get(0);
		private final Group cGroup_0_3 = (Group)cGroup_0.eContents().get(3);
		private final Keyword cUpperKeyword_0_3_0 = (Keyword)cGroup_0_3.eContents().get(0);
		private final Assignment cUpperBoundAssignment_0_3_1 = (Assignment)cGroup_0_3.eContents().get(1);
		private final RuleCall cUpperBoundINTTerminalRuleCall_0_3_1_0 = (RuleCall)cUpperBoundAssignment_0_3_1.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cFormulaParserRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);
		
		//Literal Formula:
		//	{IdFormula} varName=VAR_NAME ('lower=' lowerBound=INT)? ('upper=' upperBound=INT)?
		//	| '(' Formula ')';
		@Override public ParserRule getRule() { return rule; }
		
		//{IdFormula} varName=VAR_NAME ('lower=' lowerBound=INT)? ('upper=' upperBound=INT)? | '(' Formula ')'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//{IdFormula} varName=VAR_NAME ('lower=' lowerBound=INT)? ('upper=' upperBound=INT)?
		public Group getGroup_0() { return cGroup_0; }
		
		//{IdFormula}
		public Action getIdFormulaAction_0_0() { return cIdFormulaAction_0_0; }
		
		//varName=VAR_NAME
		public Assignment getVarNameAssignment_0_1() { return cVarNameAssignment_0_1; }
		
		//VAR_NAME
		public RuleCall getVarNameVAR_NAMETerminalRuleCall_0_1_0() { return cVarNameVAR_NAMETerminalRuleCall_0_1_0; }
		
		//('lower=' lowerBound=INT)?
		public Group getGroup_0_2() { return cGroup_0_2; }
		
		//'lower='
		public Keyword getLowerKeyword_0_2_0() { return cLowerKeyword_0_2_0; }
		
		//lowerBound=INT
		public Assignment getLowerBoundAssignment_0_2_1() { return cLowerBoundAssignment_0_2_1; }
		
		//INT
		public RuleCall getLowerBoundINTTerminalRuleCall_0_2_1_0() { return cLowerBoundINTTerminalRuleCall_0_2_1_0; }
		
		//('upper=' upperBound=INT)?
		public Group getGroup_0_3() { return cGroup_0_3; }
		
		//'upper='
		public Keyword getUpperKeyword_0_3_0() { return cUpperKeyword_0_3_0; }
		
		//upperBound=INT
		public Assignment getUpperBoundAssignment_0_3_1() { return cUpperBoundAssignment_0_3_1; }
		
		//INT
		public RuleCall getUpperBoundINTTerminalRuleCall_0_3_1_0() { return cUpperBoundINTTerminalRuleCall_0_3_1_0; }
		
		//'(' Formula ')'
		public Group getGroup_1() { return cGroup_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1_0() { return cLeftParenthesisKeyword_1_0; }
		
		//Formula
		public RuleCall getFormulaParserRuleCall_1_1() { return cFormulaParserRuleCall_1_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_1_2() { return cRightParenthesisKeyword_1_2; }
	}
	
	
	private final FormulaElements pFormula;
	private final UntilFormulaElements pUntilFormula;
	private final ConnectiveFormulaElements pConnectiveFormula;
	private final UnaryExprElements pUnaryExpr;
	private final LiteralElements pLiteral;
	private final TerminalRule tVAR_NAME;
	
	private final Grammar grammar;
	
	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public LTLGrammarAccess(GrammarProvider grammarProvider,
			TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pFormula = new FormulaElements();
		this.pUntilFormula = new UntilFormulaElements();
		this.pConnectiveFormula = new ConnectiveFormulaElements();
		this.pUnaryExpr = new UnaryExprElements();
		this.pLiteral = new LiteralElements();
		this.tVAR_NAME = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "edu.ltl.wallin.LTL.VAR_NAME");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("edu.ltl.wallin.LTL".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Formula:
	//	UntilFormula;
	public FormulaElements getFormulaAccess() {
		return pFormula;
	}
	
	public ParserRule getFormulaRule() {
		return getFormulaAccess().getRule();
	}
	
	//UntilFormula Formula:
	//	ConnectiveFormula (=> ({BinaryExpr.left=current} op='U' '[' lowerBound=INT? ',' end?='end'? upperBound=INT? ']')
	//	right=ConnectiveFormula)*;
	public UntilFormulaElements getUntilFormulaAccess() {
		return pUntilFormula;
	}
	
	public ParserRule getUntilFormulaRule() {
		return getUntilFormulaAccess().getRule();
	}
	
	//ConnectiveFormula Formula:
	//	UnaryExpr (=> ({BinaryExpr.left=current} op=('&' | '|')) right=UnaryExpr)*;
	public ConnectiveFormulaElements getConnectiveFormulaAccess() {
		return pConnectiveFormula;
	}
	
	public ParserRule getConnectiveFormulaRule() {
		return getConnectiveFormulaAccess().getRule();
	}
	
	//UnaryExpr Formula:
	//	{UnaryExpr} op=('F' | 'G') '[' lowerBound=INT? ',' end?='end'? upperBound=INT? ']' expr=UnaryExpr
	//	| {UnaryExpr} op='-' expr=UnaryExpr
	//	| Literal;
	public UnaryExprElements getUnaryExprAccess() {
		return pUnaryExpr;
	}
	
	public ParserRule getUnaryExprRule() {
		return getUnaryExprAccess().getRule();
	}
	
	//Literal Formula:
	//	{IdFormula} varName=VAR_NAME ('lower=' lowerBound=INT)? ('upper=' upperBound=INT)?
	//	| '(' Formula ')';
	public LiteralElements getLiteralAccess() {
		return pLiteral;
	}
	
	public ParserRule getLiteralRule() {
		return getLiteralAccess().getRule();
	}
	
	//terminal VAR_NAME:
	//	'a'..'z' | 'A'..'Z' | '_'* //('a'..'z'|'0'..'9')*
	//;
	public TerminalRule getVAR_NAMERule() {
		return tVAR_NAME;
	}
	
	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	}
	
	//terminal INT returns ecore::EInt:
	//	'0'..'9'+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	}
	
	//terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"' |
	//	"'" ('\\' . | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	}
	
	//terminal ML_COMMENT:
	//	'/*'->'*/';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	}
	
	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	}
	
	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	}
}
