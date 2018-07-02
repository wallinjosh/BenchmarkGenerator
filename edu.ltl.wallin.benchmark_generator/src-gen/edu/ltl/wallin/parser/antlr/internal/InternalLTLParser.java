package edu.ltl.wallin.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import edu.ltl.wallin.services.LTLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalLTLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_VAR_NAME", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'U'", "'['", "','", "']'", "'&'", "'|'", "'F'", "'G'", "'-'", "'('", "')'"
    };
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_VAR_NAME=5;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=6;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_INT=4;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalLTLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLTLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLTLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalLTL.g"; }



     	private LTLGrammarAccess grammarAccess;

        public InternalLTLParser(TokenStream input, LTLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Formula";
       	}

       	@Override
       	protected LTLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleFormula"
    // InternalLTL.g:64:1: entryRuleFormula returns [EObject current=null] : iv_ruleFormula= ruleFormula EOF ;
    public final EObject entryRuleFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormula = null;


        try {
            // InternalLTL.g:64:48: (iv_ruleFormula= ruleFormula EOF )
            // InternalLTL.g:65:2: iv_ruleFormula= ruleFormula EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFormulaRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFormula=ruleFormula();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFormula; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFormula"


    // $ANTLR start "ruleFormula"
    // InternalLTL.g:71:1: ruleFormula returns [EObject current=null] : this_UntilFormula_0= ruleUntilFormula ;
    public final EObject ruleFormula() throws RecognitionException {
        EObject current = null;

        EObject this_UntilFormula_0 = null;



        	enterRule();

        try {
            // InternalLTL.g:77:2: (this_UntilFormula_0= ruleUntilFormula )
            // InternalLTL.g:78:2: this_UntilFormula_0= ruleUntilFormula
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getFormulaAccess().getUntilFormulaParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_UntilFormula_0=ruleUntilFormula();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_UntilFormula_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFormula"


    // $ANTLR start "entryRuleUntilFormula"
    // InternalLTL.g:89:1: entryRuleUntilFormula returns [EObject current=null] : iv_ruleUntilFormula= ruleUntilFormula EOF ;
    public final EObject entryRuleUntilFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUntilFormula = null;


        try {
            // InternalLTL.g:89:53: (iv_ruleUntilFormula= ruleUntilFormula EOF )
            // InternalLTL.g:90:2: iv_ruleUntilFormula= ruleUntilFormula EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUntilFormulaRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUntilFormula=ruleUntilFormula();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUntilFormula; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUntilFormula"


    // $ANTLR start "ruleUntilFormula"
    // InternalLTL.g:96:1: ruleUntilFormula returns [EObject current=null] : (this_ConnectiveFormula_0= ruleConnectiveFormula ( ( ( ( () ( ( 'U' ) ) '[' ( ( RULE_INT ) ) ',' ( ( RULE_INT ) ) ']' ) )=> ( () ( (lv_op_2_0= 'U' ) ) otherlv_3= '[' ( (lv_lowerBound_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_upperBound_6_0= RULE_INT ) ) otherlv_7= ']' ) ) ( (lv_right_8_0= ruleConnectiveFormula ) ) )* ) ;
    public final EObject ruleUntilFormula() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token otherlv_3=null;
        Token lv_lowerBound_4_0=null;
        Token otherlv_5=null;
        Token lv_upperBound_6_0=null;
        Token otherlv_7=null;
        EObject this_ConnectiveFormula_0 = null;

        EObject lv_right_8_0 = null;



        	enterRule();

        try {
            // InternalLTL.g:102:2: ( (this_ConnectiveFormula_0= ruleConnectiveFormula ( ( ( ( () ( ( 'U' ) ) '[' ( ( RULE_INT ) ) ',' ( ( RULE_INT ) ) ']' ) )=> ( () ( (lv_op_2_0= 'U' ) ) otherlv_3= '[' ( (lv_lowerBound_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_upperBound_6_0= RULE_INT ) ) otherlv_7= ']' ) ) ( (lv_right_8_0= ruleConnectiveFormula ) ) )* ) )
            // InternalLTL.g:103:2: (this_ConnectiveFormula_0= ruleConnectiveFormula ( ( ( ( () ( ( 'U' ) ) '[' ( ( RULE_INT ) ) ',' ( ( RULE_INT ) ) ']' ) )=> ( () ( (lv_op_2_0= 'U' ) ) otherlv_3= '[' ( (lv_lowerBound_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_upperBound_6_0= RULE_INT ) ) otherlv_7= ']' ) ) ( (lv_right_8_0= ruleConnectiveFormula ) ) )* )
            {
            // InternalLTL.g:103:2: (this_ConnectiveFormula_0= ruleConnectiveFormula ( ( ( ( () ( ( 'U' ) ) '[' ( ( RULE_INT ) ) ',' ( ( RULE_INT ) ) ']' ) )=> ( () ( (lv_op_2_0= 'U' ) ) otherlv_3= '[' ( (lv_lowerBound_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_upperBound_6_0= RULE_INT ) ) otherlv_7= ']' ) ) ( (lv_right_8_0= ruleConnectiveFormula ) ) )* )
            // InternalLTL.g:104:3: this_ConnectiveFormula_0= ruleConnectiveFormula ( ( ( ( () ( ( 'U' ) ) '[' ( ( RULE_INT ) ) ',' ( ( RULE_INT ) ) ']' ) )=> ( () ( (lv_op_2_0= 'U' ) ) otherlv_3= '[' ( (lv_lowerBound_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_upperBound_6_0= RULE_INT ) ) otherlv_7= ']' ) ) ( (lv_right_8_0= ruleConnectiveFormula ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getUntilFormulaAccess().getConnectiveFormulaParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_3);
            this_ConnectiveFormula_0=ruleConnectiveFormula();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ConnectiveFormula_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalLTL.g:112:3: ( ( ( ( () ( ( 'U' ) ) '[' ( ( RULE_INT ) ) ',' ( ( RULE_INT ) ) ']' ) )=> ( () ( (lv_op_2_0= 'U' ) ) otherlv_3= '[' ( (lv_lowerBound_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_upperBound_6_0= RULE_INT ) ) otherlv_7= ']' ) ) ( (lv_right_8_0= ruleConnectiveFormula ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) && (synpred1_InternalLTL())) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalLTL.g:113:4: ( ( ( () ( ( 'U' ) ) '[' ( ( RULE_INT ) ) ',' ( ( RULE_INT ) ) ']' ) )=> ( () ( (lv_op_2_0= 'U' ) ) otherlv_3= '[' ( (lv_lowerBound_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_upperBound_6_0= RULE_INT ) ) otherlv_7= ']' ) ) ( (lv_right_8_0= ruleConnectiveFormula ) )
            	    {
            	    // InternalLTL.g:113:4: ( ( ( () ( ( 'U' ) ) '[' ( ( RULE_INT ) ) ',' ( ( RULE_INT ) ) ']' ) )=> ( () ( (lv_op_2_0= 'U' ) ) otherlv_3= '[' ( (lv_lowerBound_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_upperBound_6_0= RULE_INT ) ) otherlv_7= ']' ) )
            	    // InternalLTL.g:114:5: ( ( () ( ( 'U' ) ) '[' ( ( RULE_INT ) ) ',' ( ( RULE_INT ) ) ']' ) )=> ( () ( (lv_op_2_0= 'U' ) ) otherlv_3= '[' ( (lv_lowerBound_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_upperBound_6_0= RULE_INT ) ) otherlv_7= ']' )
            	    {
            	    // InternalLTL.g:137:5: ( () ( (lv_op_2_0= 'U' ) ) otherlv_3= '[' ( (lv_lowerBound_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_upperBound_6_0= RULE_INT ) ) otherlv_7= ']' )
            	    // InternalLTL.g:138:6: () ( (lv_op_2_0= 'U' ) ) otherlv_3= '[' ( (lv_lowerBound_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_upperBound_6_0= RULE_INT ) ) otherlv_7= ']'
            	    {
            	    // InternalLTL.g:138:6: ()
            	    // InternalLTL.g:139:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getUntilFormulaAccess().getBinaryExprLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalLTL.g:145:6: ( (lv_op_2_0= 'U' ) )
            	    // InternalLTL.g:146:7: (lv_op_2_0= 'U' )
            	    {
            	    // InternalLTL.g:146:7: (lv_op_2_0= 'U' )
            	    // InternalLTL.g:147:8: lv_op_2_0= 'U'
            	    {
            	    lv_op_2_0=(Token)match(input,12,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								newLeafNode(lv_op_2_0, grammarAccess.getUntilFormulaAccess().getOpUKeyword_1_0_0_1_0());
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElement(grammarAccess.getUntilFormulaRule());
            	      								}
            	      								setWithLastConsumed(current, "op", lv_op_2_0, "U");
            	      							
            	    }

            	    }


            	    }

            	    otherlv_3=(Token)match(input,13,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(otherlv_3, grammarAccess.getUntilFormulaAccess().getLeftSquareBracketKeyword_1_0_0_2());
            	      					
            	    }
            	    // InternalLTL.g:163:6: ( (lv_lowerBound_4_0= RULE_INT ) )
            	    // InternalLTL.g:164:7: (lv_lowerBound_4_0= RULE_INT )
            	    {
            	    // InternalLTL.g:164:7: (lv_lowerBound_4_0= RULE_INT )
            	    // InternalLTL.g:165:8: lv_lowerBound_4_0= RULE_INT
            	    {
            	    lv_lowerBound_4_0=(Token)match(input,RULE_INT,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								newLeafNode(lv_lowerBound_4_0, grammarAccess.getUntilFormulaAccess().getLowerBoundINTTerminalRuleCall_1_0_0_3_0());
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElement(grammarAccess.getUntilFormulaRule());
            	      								}
            	      								setWithLastConsumed(
            	      									current,
            	      									"lowerBound",
            	      									lv_lowerBound_4_0,
            	      									"org.eclipse.xtext.common.Terminals.INT");
            	      							
            	    }

            	    }


            	    }

            	    otherlv_5=(Token)match(input,14,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(otherlv_5, grammarAccess.getUntilFormulaAccess().getCommaKeyword_1_0_0_4());
            	      					
            	    }
            	    // InternalLTL.g:185:6: ( (lv_upperBound_6_0= RULE_INT ) )
            	    // InternalLTL.g:186:7: (lv_upperBound_6_0= RULE_INT )
            	    {
            	    // InternalLTL.g:186:7: (lv_upperBound_6_0= RULE_INT )
            	    // InternalLTL.g:187:8: lv_upperBound_6_0= RULE_INT
            	    {
            	    lv_upperBound_6_0=(Token)match(input,RULE_INT,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								newLeafNode(lv_upperBound_6_0, grammarAccess.getUntilFormulaAccess().getUpperBoundINTTerminalRuleCall_1_0_0_5_0());
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElement(grammarAccess.getUntilFormulaRule());
            	      								}
            	      								setWithLastConsumed(
            	      									current,
            	      									"upperBound",
            	      									lv_upperBound_6_0,
            	      									"org.eclipse.xtext.common.Terminals.INT");
            	      							
            	    }

            	    }


            	    }

            	    otherlv_7=(Token)match(input,15,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(otherlv_7, grammarAccess.getUntilFormulaAccess().getRightSquareBracketKeyword_1_0_0_6());
            	      					
            	    }

            	    }


            	    }

            	    // InternalLTL.g:209:4: ( (lv_right_8_0= ruleConnectiveFormula ) )
            	    // InternalLTL.g:210:5: (lv_right_8_0= ruleConnectiveFormula )
            	    {
            	    // InternalLTL.g:210:5: (lv_right_8_0= ruleConnectiveFormula )
            	    // InternalLTL.g:211:6: lv_right_8_0= ruleConnectiveFormula
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getUntilFormulaAccess().getRightConnectiveFormulaParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_right_8_0=ruleConnectiveFormula();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getUntilFormulaRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_8_0,
            	      							"edu.ltl.wallin.LTL.ConnectiveFormula");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUntilFormula"


    // $ANTLR start "entryRuleConnectiveFormula"
    // InternalLTL.g:233:1: entryRuleConnectiveFormula returns [EObject current=null] : iv_ruleConnectiveFormula= ruleConnectiveFormula EOF ;
    public final EObject entryRuleConnectiveFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectiveFormula = null;


        try {
            // InternalLTL.g:233:58: (iv_ruleConnectiveFormula= ruleConnectiveFormula EOF )
            // InternalLTL.g:234:2: iv_ruleConnectiveFormula= ruleConnectiveFormula EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConnectiveFormulaRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConnectiveFormula=ruleConnectiveFormula();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConnectiveFormula; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConnectiveFormula"


    // $ANTLR start "ruleConnectiveFormula"
    // InternalLTL.g:240:1: ruleConnectiveFormula returns [EObject current=null] : (this_UnaryExpr_0= ruleUnaryExpr ( ( ( ( () ( ( ( '&' | '|' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) ) ) ) ) ( (lv_right_3_0= ruleUnaryExpr ) ) )* ) ;
    public final EObject ruleConnectiveFormula() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_UnaryExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalLTL.g:246:2: ( (this_UnaryExpr_0= ruleUnaryExpr ( ( ( ( () ( ( ( '&' | '|' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) ) ) ) ) ( (lv_right_3_0= ruleUnaryExpr ) ) )* ) )
            // InternalLTL.g:247:2: (this_UnaryExpr_0= ruleUnaryExpr ( ( ( ( () ( ( ( '&' | '|' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) ) ) ) ) ( (lv_right_3_0= ruleUnaryExpr ) ) )* )
            {
            // InternalLTL.g:247:2: (this_UnaryExpr_0= ruleUnaryExpr ( ( ( ( () ( ( ( '&' | '|' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) ) ) ) ) ( (lv_right_3_0= ruleUnaryExpr ) ) )* )
            // InternalLTL.g:248:3: this_UnaryExpr_0= ruleUnaryExpr ( ( ( ( () ( ( ( '&' | '|' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) ) ) ) ) ( (lv_right_3_0= ruleUnaryExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getConnectiveFormulaAccess().getUnaryExprParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_9);
            this_UnaryExpr_0=ruleUnaryExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_UnaryExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalLTL.g:256:3: ( ( ( ( () ( ( ( '&' | '|' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) ) ) ) ) ( (lv_right_3_0= ruleUnaryExpr ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16) && (synpred2_InternalLTL())) {
                    alt3=1;
                }
                else if ( (LA3_0==17) && (synpred2_InternalLTL())) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalLTL.g:257:4: ( ( ( () ( ( ( '&' | '|' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) ) ) ) ) ( (lv_right_3_0= ruleUnaryExpr ) )
            	    {
            	    // InternalLTL.g:257:4: ( ( ( () ( ( ( '&' | '|' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) ) ) ) )
            	    // InternalLTL.g:258:5: ( ( () ( ( ( '&' | '|' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) ) ) )
            	    {
            	    // InternalLTL.g:272:5: ( () ( ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) ) ) )
            	    // InternalLTL.g:273:6: () ( ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) ) )
            	    {
            	    // InternalLTL.g:273:6: ()
            	    // InternalLTL.g:274:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getConnectiveFormulaAccess().getBinaryExprLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalLTL.g:280:6: ( ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) ) )
            	    // InternalLTL.g:281:7: ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) )
            	    {
            	    // InternalLTL.g:281:7: ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) )
            	    // InternalLTL.g:282:8: (lv_op_2_1= '&' | lv_op_2_2= '|' )
            	    {
            	    // InternalLTL.g:282:8: (lv_op_2_1= '&' | lv_op_2_2= '|' )
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==16) ) {
            	        alt2=1;
            	    }
            	    else if ( (LA2_0==17) ) {
            	        alt2=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // InternalLTL.g:283:9: lv_op_2_1= '&'
            	            {
            	            lv_op_2_1=(Token)match(input,16,FOLLOW_8); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              									newLeafNode(lv_op_2_1, grammarAccess.getConnectiveFormulaAccess().getOpAmpersandKeyword_1_0_0_1_0_0());
            	              								
            	            }
            	            if ( state.backtracking==0 ) {

            	              									if (current==null) {
            	              										current = createModelElement(grammarAccess.getConnectiveFormulaRule());
            	              									}
            	              									setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              								
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalLTL.g:294:9: lv_op_2_2= '|'
            	            {
            	            lv_op_2_2=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              									newLeafNode(lv_op_2_2, grammarAccess.getConnectiveFormulaAccess().getOpVerticalLineKeyword_1_0_0_1_0_1());
            	              								
            	            }
            	            if ( state.backtracking==0 ) {

            	              									if (current==null) {
            	              										current = createModelElement(grammarAccess.getConnectiveFormulaRule());
            	              									}
            	              									setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              								
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }


            	    }

            	    // InternalLTL.g:309:4: ( (lv_right_3_0= ruleUnaryExpr ) )
            	    // InternalLTL.g:310:5: (lv_right_3_0= ruleUnaryExpr )
            	    {
            	    // InternalLTL.g:310:5: (lv_right_3_0= ruleUnaryExpr )
            	    // InternalLTL.g:311:6: lv_right_3_0= ruleUnaryExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getConnectiveFormulaAccess().getRightUnaryExprParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_9);
            	    lv_right_3_0=ruleUnaryExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getConnectiveFormulaRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"edu.ltl.wallin.LTL.UnaryExpr");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConnectiveFormula"


    // $ANTLR start "entryRuleUnaryExpr"
    // InternalLTL.g:333:1: entryRuleUnaryExpr returns [EObject current=null] : iv_ruleUnaryExpr= ruleUnaryExpr EOF ;
    public final EObject entryRuleUnaryExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpr = null;


        try {
            // InternalLTL.g:333:50: (iv_ruleUnaryExpr= ruleUnaryExpr EOF )
            // InternalLTL.g:334:2: iv_ruleUnaryExpr= ruleUnaryExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryExpr=ruleUnaryExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryExpr"


    // $ANTLR start "ruleUnaryExpr"
    // InternalLTL.g:340:1: ruleUnaryExpr returns [EObject current=null] : ( ( () ( ( (lv_op_1_1= 'F' | lv_op_1_2= 'G' ) ) ) otherlv_2= '[' ( (lv_lowerBound_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_upperBound_5_0= RULE_INT ) ) otherlv_6= ']' ( (lv_expr_7_0= ruleUnaryExpr ) ) ) | ( () ( (lv_op_9_0= '-' ) ) ( (lv_expr_10_0= ruleUnaryExpr ) ) ) | this_Literal_11= ruleLiteral ) ;
    public final EObject ruleUnaryExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token otherlv_2=null;
        Token lv_lowerBound_3_0=null;
        Token otherlv_4=null;
        Token lv_upperBound_5_0=null;
        Token otherlv_6=null;
        Token lv_op_9_0=null;
        EObject lv_expr_7_0 = null;

        EObject lv_expr_10_0 = null;

        EObject this_Literal_11 = null;



        	enterRule();

        try {
            // InternalLTL.g:346:2: ( ( ( () ( ( (lv_op_1_1= 'F' | lv_op_1_2= 'G' ) ) ) otherlv_2= '[' ( (lv_lowerBound_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_upperBound_5_0= RULE_INT ) ) otherlv_6= ']' ( (lv_expr_7_0= ruleUnaryExpr ) ) ) | ( () ( (lv_op_9_0= '-' ) ) ( (lv_expr_10_0= ruleUnaryExpr ) ) ) | this_Literal_11= ruleLiteral ) )
            // InternalLTL.g:347:2: ( ( () ( ( (lv_op_1_1= 'F' | lv_op_1_2= 'G' ) ) ) otherlv_2= '[' ( (lv_lowerBound_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_upperBound_5_0= RULE_INT ) ) otherlv_6= ']' ( (lv_expr_7_0= ruleUnaryExpr ) ) ) | ( () ( (lv_op_9_0= '-' ) ) ( (lv_expr_10_0= ruleUnaryExpr ) ) ) | this_Literal_11= ruleLiteral )
            {
            // InternalLTL.g:347:2: ( ( () ( ( (lv_op_1_1= 'F' | lv_op_1_2= 'G' ) ) ) otherlv_2= '[' ( (lv_lowerBound_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_upperBound_5_0= RULE_INT ) ) otherlv_6= ']' ( (lv_expr_7_0= ruleUnaryExpr ) ) ) | ( () ( (lv_op_9_0= '-' ) ) ( (lv_expr_10_0= ruleUnaryExpr ) ) ) | this_Literal_11= ruleLiteral )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 18:
            case 19:
                {
                alt5=1;
                }
                break;
            case 20:
                {
                alt5=2;
                }
                break;
            case RULE_VAR_NAME:
            case 21:
                {
                alt5=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalLTL.g:348:3: ( () ( ( (lv_op_1_1= 'F' | lv_op_1_2= 'G' ) ) ) otherlv_2= '[' ( (lv_lowerBound_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_upperBound_5_0= RULE_INT ) ) otherlv_6= ']' ( (lv_expr_7_0= ruleUnaryExpr ) ) )
                    {
                    // InternalLTL.g:348:3: ( () ( ( (lv_op_1_1= 'F' | lv_op_1_2= 'G' ) ) ) otherlv_2= '[' ( (lv_lowerBound_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_upperBound_5_0= RULE_INT ) ) otherlv_6= ']' ( (lv_expr_7_0= ruleUnaryExpr ) ) )
                    // InternalLTL.g:349:4: () ( ( (lv_op_1_1= 'F' | lv_op_1_2= 'G' ) ) ) otherlv_2= '[' ( (lv_lowerBound_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_upperBound_5_0= RULE_INT ) ) otherlv_6= ']' ( (lv_expr_7_0= ruleUnaryExpr ) )
                    {
                    // InternalLTL.g:349:4: ()
                    // InternalLTL.g:350:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getUnaryExprAccess().getUnaryExprAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalLTL.g:356:4: ( ( (lv_op_1_1= 'F' | lv_op_1_2= 'G' ) ) )
                    // InternalLTL.g:357:5: ( (lv_op_1_1= 'F' | lv_op_1_2= 'G' ) )
                    {
                    // InternalLTL.g:357:5: ( (lv_op_1_1= 'F' | lv_op_1_2= 'G' ) )
                    // InternalLTL.g:358:6: (lv_op_1_1= 'F' | lv_op_1_2= 'G' )
                    {
                    // InternalLTL.g:358:6: (lv_op_1_1= 'F' | lv_op_1_2= 'G' )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==18) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==19) ) {
                        alt4=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalLTL.g:359:7: lv_op_1_1= 'F'
                            {
                            lv_op_1_1=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_1_1, grammarAccess.getUnaryExprAccess().getOpFKeyword_0_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getUnaryExprRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_1_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalLTL.g:370:7: lv_op_1_2= 'G'
                            {
                            lv_op_1_2=(Token)match(input,19,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_1_2, grammarAccess.getUnaryExprAccess().getOpGKeyword_0_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getUnaryExprRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_1_2, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    otherlv_2=(Token)match(input,13,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getUnaryExprAccess().getLeftSquareBracketKeyword_0_2());
                      			
                    }
                    // InternalLTL.g:387:4: ( (lv_lowerBound_3_0= RULE_INT ) )
                    // InternalLTL.g:388:5: (lv_lowerBound_3_0= RULE_INT )
                    {
                    // InternalLTL.g:388:5: (lv_lowerBound_3_0= RULE_INT )
                    // InternalLTL.g:389:6: lv_lowerBound_3_0= RULE_INT
                    {
                    lv_lowerBound_3_0=(Token)match(input,RULE_INT,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_lowerBound_3_0, grammarAccess.getUnaryExprAccess().getLowerBoundINTTerminalRuleCall_0_3_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getUnaryExprRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"lowerBound",
                      							lv_lowerBound_3_0,
                      							"org.eclipse.xtext.common.Terminals.INT");
                      					
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,14,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getUnaryExprAccess().getCommaKeyword_0_4());
                      			
                    }
                    // InternalLTL.g:409:4: ( (lv_upperBound_5_0= RULE_INT ) )
                    // InternalLTL.g:410:5: (lv_upperBound_5_0= RULE_INT )
                    {
                    // InternalLTL.g:410:5: (lv_upperBound_5_0= RULE_INT )
                    // InternalLTL.g:411:6: lv_upperBound_5_0= RULE_INT
                    {
                    lv_upperBound_5_0=(Token)match(input,RULE_INT,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_upperBound_5_0, grammarAccess.getUnaryExprAccess().getUpperBoundINTTerminalRuleCall_0_5_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getUnaryExprRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"upperBound",
                      							lv_upperBound_5_0,
                      							"org.eclipse.xtext.common.Terminals.INT");
                      					
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,15,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getUnaryExprAccess().getRightSquareBracketKeyword_0_6());
                      			
                    }
                    // InternalLTL.g:431:4: ( (lv_expr_7_0= ruleUnaryExpr ) )
                    // InternalLTL.g:432:5: (lv_expr_7_0= ruleUnaryExpr )
                    {
                    // InternalLTL.g:432:5: (lv_expr_7_0= ruleUnaryExpr )
                    // InternalLTL.g:433:6: lv_expr_7_0= ruleUnaryExpr
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryExprAccess().getExprUnaryExprParserRuleCall_0_7_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_7_0=ruleUnaryExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryExprRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_7_0,
                      							"edu.ltl.wallin.LTL.UnaryExpr");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalLTL.g:452:3: ( () ( (lv_op_9_0= '-' ) ) ( (lv_expr_10_0= ruleUnaryExpr ) ) )
                    {
                    // InternalLTL.g:452:3: ( () ( (lv_op_9_0= '-' ) ) ( (lv_expr_10_0= ruleUnaryExpr ) ) )
                    // InternalLTL.g:453:4: () ( (lv_op_9_0= '-' ) ) ( (lv_expr_10_0= ruleUnaryExpr ) )
                    {
                    // InternalLTL.g:453:4: ()
                    // InternalLTL.g:454:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getUnaryExprAccess().getUnaryExprAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalLTL.g:460:4: ( (lv_op_9_0= '-' ) )
                    // InternalLTL.g:461:5: (lv_op_9_0= '-' )
                    {
                    // InternalLTL.g:461:5: (lv_op_9_0= '-' )
                    // InternalLTL.g:462:6: lv_op_9_0= '-'
                    {
                    lv_op_9_0=(Token)match(input,20,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_9_0, grammarAccess.getUnaryExprAccess().getOpHyphenMinusKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getUnaryExprRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_9_0, "-");
                      					
                    }

                    }


                    }

                    // InternalLTL.g:474:4: ( (lv_expr_10_0= ruleUnaryExpr ) )
                    // InternalLTL.g:475:5: (lv_expr_10_0= ruleUnaryExpr )
                    {
                    // InternalLTL.g:475:5: (lv_expr_10_0= ruleUnaryExpr )
                    // InternalLTL.g:476:6: lv_expr_10_0= ruleUnaryExpr
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryExprAccess().getExprUnaryExprParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_10_0=ruleUnaryExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryExprRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_10_0,
                      							"edu.ltl.wallin.LTL.UnaryExpr");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalLTL.g:495:3: this_Literal_11= ruleLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryExprAccess().getLiteralParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Literal_11=ruleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Literal_11;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryExpr"


    // $ANTLR start "entryRuleLiteral"
    // InternalLTL.g:507:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalLTL.g:507:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalLTL.g:508:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalLTL.g:514:1: ruleLiteral returns [EObject current=null] : ( ( () ( (lv_varName_1_0= RULE_VAR_NAME ) ) ) | (otherlv_2= '(' this_Formula_3= ruleFormula otherlv_4= ')' ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_varName_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Formula_3 = null;



        	enterRule();

        try {
            // InternalLTL.g:520:2: ( ( ( () ( (lv_varName_1_0= RULE_VAR_NAME ) ) ) | (otherlv_2= '(' this_Formula_3= ruleFormula otherlv_4= ')' ) ) )
            // InternalLTL.g:521:2: ( ( () ( (lv_varName_1_0= RULE_VAR_NAME ) ) ) | (otherlv_2= '(' this_Formula_3= ruleFormula otherlv_4= ')' ) )
            {
            // InternalLTL.g:521:2: ( ( () ( (lv_varName_1_0= RULE_VAR_NAME ) ) ) | (otherlv_2= '(' this_Formula_3= ruleFormula otherlv_4= ')' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_VAR_NAME) ) {
                alt6=1;
            }
            else if ( (LA6_0==21) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalLTL.g:522:3: ( () ( (lv_varName_1_0= RULE_VAR_NAME ) ) )
                    {
                    // InternalLTL.g:522:3: ( () ( (lv_varName_1_0= RULE_VAR_NAME ) ) )
                    // InternalLTL.g:523:4: () ( (lv_varName_1_0= RULE_VAR_NAME ) )
                    {
                    // InternalLTL.g:523:4: ()
                    // InternalLTL.g:524:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getLiteralAccess().getIdFormulaAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalLTL.g:530:4: ( (lv_varName_1_0= RULE_VAR_NAME ) )
                    // InternalLTL.g:531:5: (lv_varName_1_0= RULE_VAR_NAME )
                    {
                    // InternalLTL.g:531:5: (lv_varName_1_0= RULE_VAR_NAME )
                    // InternalLTL.g:532:6: lv_varName_1_0= RULE_VAR_NAME
                    {
                    lv_varName_1_0=(Token)match(input,RULE_VAR_NAME,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_varName_1_0, grammarAccess.getLiteralAccess().getVarNameVAR_NAMETerminalRuleCall_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getLiteralRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"varName",
                      							lv_varName_1_0,
                      							"edu.ltl.wallin.LTL.VAR_NAME");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalLTL.g:550:3: (otherlv_2= '(' this_Formula_3= ruleFormula otherlv_4= ')' )
                    {
                    // InternalLTL.g:550:3: (otherlv_2= '(' this_Formula_3= ruleFormula otherlv_4= ')' )
                    // InternalLTL.g:551:4: otherlv_2= '(' this_Formula_3= ruleFormula otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,21,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getLiteralAccess().getLeftParenthesisKeyword_1_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getLiteralAccess().getFormulaParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FOLLOW_10);
                    this_Formula_3=ruleFormula();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Formula_3;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_4=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getLiteralAccess().getRightParenthesisKeyword_1_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"

    // $ANTLR start synpred1_InternalLTL
    public final void synpred1_InternalLTL_fragment() throws RecognitionException {   
        // InternalLTL.g:114:5: ( ( () ( ( 'U' ) ) '[' ( ( RULE_INT ) ) ',' ( ( RULE_INT ) ) ']' ) )
        // InternalLTL.g:114:6: ( () ( ( 'U' ) ) '[' ( ( RULE_INT ) ) ',' ( ( RULE_INT ) ) ']' )
        {
        // InternalLTL.g:114:6: ( () ( ( 'U' ) ) '[' ( ( RULE_INT ) ) ',' ( ( RULE_INT ) ) ']' )
        // InternalLTL.g:115:6: () ( ( 'U' ) ) '[' ( ( RULE_INT ) ) ',' ( ( RULE_INT ) ) ']'
        {
        // InternalLTL.g:115:6: ()
        // InternalLTL.g:116:6: 
        {
        }

        // InternalLTL.g:117:6: ( ( 'U' ) )
        // InternalLTL.g:118:7: ( 'U' )
        {
        // InternalLTL.g:118:7: ( 'U' )
        // InternalLTL.g:119:8: 'U'
        {
        match(input,12,FOLLOW_4); if (state.failed) return ;

        }


        }

        match(input,13,FOLLOW_5); if (state.failed) return ;
        // InternalLTL.g:123:6: ( ( RULE_INT ) )
        // InternalLTL.g:124:7: ( RULE_INT )
        {
        // InternalLTL.g:124:7: ( RULE_INT )
        // InternalLTL.g:125:8: RULE_INT
        {
        match(input,RULE_INT,FOLLOW_6); if (state.failed) return ;

        }


        }

        match(input,14,FOLLOW_5); if (state.failed) return ;
        // InternalLTL.g:129:6: ( ( RULE_INT ) )
        // InternalLTL.g:130:7: ( RULE_INT )
        {
        // InternalLTL.g:130:7: ( RULE_INT )
        // InternalLTL.g:131:8: RULE_INT
        {
        match(input,RULE_INT,FOLLOW_7); if (state.failed) return ;

        }


        }

        match(input,15,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalLTL

    // $ANTLR start synpred2_InternalLTL
    public final void synpred2_InternalLTL_fragment() throws RecognitionException {   
        // InternalLTL.g:258:5: ( ( () ( ( ( '&' | '|' ) ) ) ) )
        // InternalLTL.g:258:6: ( () ( ( ( '&' | '|' ) ) ) )
        {
        // InternalLTL.g:258:6: ( () ( ( ( '&' | '|' ) ) ) )
        // InternalLTL.g:259:6: () ( ( ( '&' | '|' ) ) )
        {
        // InternalLTL.g:259:6: ()
        // InternalLTL.g:260:6: 
        {
        }

        // InternalLTL.g:261:6: ( ( ( '&' | '|' ) ) )
        // InternalLTL.g:262:7: ( ( '&' | '|' ) )
        {
        // InternalLTL.g:262:7: ( ( '&' | '|' ) )
        // InternalLTL.g:263:8: ( '&' | '|' )
        {
        if ( (input.LA(1)>=16 && input.LA(1)<=17) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalLTL

    // Delegated rules

    public final boolean synpred1_InternalLTL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalLTL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalLTL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalLTL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000003C0020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000400000L});

}