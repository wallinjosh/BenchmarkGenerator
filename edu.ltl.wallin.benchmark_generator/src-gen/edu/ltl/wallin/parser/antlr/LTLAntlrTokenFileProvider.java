/*
 * generated by Xtext 2.14.0
 */
package edu.ltl.wallin.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class LTLAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("edu/ltl/wallin/parser/antlr/internal/InternalLTL.tokens");
	}
}