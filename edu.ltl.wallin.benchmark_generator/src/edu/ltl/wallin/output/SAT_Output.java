package edu.ltl.wallin.output;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import edu.ltl.wallin.generator.ComputeDeadlines;
import edu.ltl.wallin.generator.LTLGenerator;
import edu.ltl.wallin.lTL.BinaryExpr;
import edu.ltl.wallin.lTL.Formula;
import edu.ltl.wallin.lTL.IdFormula;
import edu.ltl.wallin.lTL.UnaryExpr;

public class SAT_Output {
	
	private static StringBuffer sb;
	private static final String BCZCHAFF_LOCATION = "/Users/Josh/RV18/BenchmarkGenerator/bczchaff";
	
	private static void satPrinterHelper(Formula f) {
		if(f instanceof UnaryExpr) {
			UnaryExpr castUnary = (UnaryExpr) f;
			if(!castUnary.getOp().equals("-")) sb.append(castUnary.getOp());
			if(castUnary.getOp().equals("-")) sb.append("!");
			if(!castUnary.getOp().equals("-")) sb.append("[" + castUnary.getLowerBound() + "," + castUnary.getUpperBound() + "] ");
			sb.append("(");
			if(!castUnary.eContents().isEmpty()) {
				satPrinterHelper((Formula) castUnary.getExpr());
			}
			sb.append(")");
		} else if(f instanceof BinaryExpr) {
			BinaryExpr castBinary = (BinaryExpr) f;
			sb.append("(");
			satPrinterHelper(castBinary.getLeft());
			sb.append(")");
			sb.append(" " + castBinary.getOp() + " ");
			if(castBinary.getLowerBound() != castBinary.getUpperBound()) {
				sb.append("[" + castBinary.getLowerBound() + "," + castBinary.getUpperBound() + "] ");
			}
			sb.append("(");
			satPrinterHelper(castBinary.getRight());
			sb.append(")");
		} else if (f instanceof IdFormula) {
			sb.append(((IdFormula)f).getVarName() + ((IdFormula)f).getLowerBound());
		}
	}
	
	static String satPrinter(Formula f) {
		sb = new StringBuffer();
		satPrinterHelper(f);
		
		return sb.toString();
	}
	
	private static int numVars(Formula f, int trace_length) {
		HashSet<String> vars = new HashSet<String>();
		TreeIterator<EObject> treeContents = f.eAllContents();
		EObject cur = f;
		do {
			if(cur instanceof IdFormula) vars.add(((IdFormula)cur).getVarName());
			if(treeContents.hasNext()) cur = treeContents.next();
			else cur = null;
		}while(cur != null);
		return vars.size();
	}
	
	public static String writeForBczchaff(Formula f, String output_filename, int trace_length) {
		StringBuffer Sat_buffer = new StringBuffer();
		Sat_buffer.append("BC1.1\n");
		
		for(String s : ComputeDeadlines.numVars(f)) {
			for(int j = 0; j <= trace_length; j++) {
				Sat_buffer.append((s) + Integer.toString(j) + ";\n");
			}
		}
	
		Sat_buffer.append("ASSIGN ");
		Sat_buffer.append(satPrinter(f) + ";");
		
		String output = Sat_buffer.toString();
		
		try {
			BufferedWriter output_writer = new BufferedWriter(new FileWriter(output_filename + ".bc"));
			output_writer.write(output);
			output_writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}

	public static String callGetBczchaff(String input_filename) {
		String response = "";
		String temp = "";
		try {
			Process run_bczchaff = Runtime.getRuntime().exec(BCZCHAFF_LOCATION + " " + input_filename);
			BufferedReader response_reader = new BufferedReader(new InputStreamReader(run_bczchaff.getInputStream()));
			while((temp = response_reader.readLine()) != null) {
				response += temp;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	public static String processBczchaffResponse(String bczchaff_result, String output_filename, HashSet<String> var_set, int trace_length) {
		if(bczchaff_result.contains("Unsatisfiable")) return "UNSATISFIABLE -- CANNOT GENERATE TRACE FOR INPUT FORMULAS";

		String trace = "";
		HashMap<String, HashMap<Integer, Boolean>> variableValues = new HashMap<String, HashMap<Integer, Boolean>>();
				
		//Set all variables to false before reading in actual values
		for(String var : var_set) {
			HashMap<Integer, Boolean> varMap = new HashMap<Integer, Boolean>();
			for(int j = 0; j < trace_length; j++) {
				varMap.put(j, false);
			}
			variableValues.put(var, varMap);
		}
		

		//Read bczchaff_result for var values
		String[] results = bczchaff_result.split(" ");
		for(String s : results) {
			if(s.equals("Satisfiable")) break;
			
			boolean isTrue = !(s.substring(0,1).equals("!"));
			String curVar = (isTrue) ? s.substring(0,1) : s.substring(1,2);
			int curVarNumber = (isTrue) ? Integer.parseInt(s.substring(1)) : Integer.parseInt(s.substring(2));
			
			variableValues.get(curVar).put(curVarNumber, isTrue);
		}
		
		
			
		//Add variable labels at top
		trace += "TIME, ";
		for(String s : var_set) {
			trace += (s) + ", ";
		}
		trace += "\n";
		//Add variable values
		for(int t = 0; t < trace_length; t++) {
			
			trace += t + ", ";
			
			for(String s : var_set) {
				trace += variableValues.get(s).get(t) + ", ";
			}
			
			trace += "\n";
		}
		trace += "\n";
		
		BufferedWriter trace_output;
		try {
			trace_output = new BufferedWriter(new FileWriter(output_filename + "_trace_output.csv"));
			trace_output.write(trace);
			trace_output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return trace;
	}
	
}
