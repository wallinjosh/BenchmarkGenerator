/**
 * generated by Xtext 2.14.0
 */
package edu.ltl.wallin.generator;

import edu.ltl.wallin.generator.ComputeDeadlines;
import edu.ltl.wallin.generator.PerformTransforms;
import edu.ltl.wallin.lTL.Formula;
import edu.ltl.wallin.output.SAT_Output;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class LTLGenerator extends AbstractGenerator {
  private static String modified_output_filename = "";
  
  public static void log(final String output, final BufferedWriter writer) {
    try {
      if ((writer != null)) {
        writer.append((output + "\n"));
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context, final int trace_length, final boolean verbose, final String output_filename) {
    try {
      final long curTime = System.currentTimeMillis();
      String modified_output_filename = (((("./OUTPUT/" + output_filename) + "_") + Long.valueOf(curTime)) + "/");
      new File(modified_output_filename).mkdirs();
      String _modified_output_filename = modified_output_filename;
      modified_output_filename = (_modified_output_filename + ((output_filename + "_") + Long.valueOf(curTime)));
      BufferedWriter _xtrycatchfinallyexpression = null;
      try {
        FileWriter _fileWriter = new FileWriter((modified_output_filename + "_log.txt"));
        _xtrycatchfinallyexpression = new BufferedWriter(_fileWriter);
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          _xtrycatchfinallyexpression = null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      BufferedWriter log_writer = _xtrycatchfinallyexpression;
      EObject _get = resource.getContents().get(0);
      String _debugPrettyPrinter = PerformTransforms.debugPrettyPrinter(((Formula) _get));
      String _plus = ("STARTING FORMULA\n\n" + _debugPrettyPrinter);
      String _plus_1 = (_plus + "\n");
      LTLGenerator.log(_plus_1, log_writer);
      ComputeDeadlines.transformFormula(resource, trace_length, verbose, output_filename);
      EObject _get_1 = resource.getContents().get(0);
      final HashSet<String> var_set = ComputeDeadlines.numVars(((Formula) _get_1));
      EObject _get_2 = resource.getContents().get(0);
      final String sat_query = SAT_Output.writeForSMT(((Formula) _get_2), modified_output_filename, trace_length);
      LTLGenerator.log((("GENERATED SAT QUERY\n\n" + sat_query) + "\n"), log_writer);
      final String sat_result = SAT_Output.callGetZ3((modified_output_filename + ".smt"));
      LTLGenerator.log((("SAT SOLVER RESULT\n\n" + sat_result) + "\n"), log_writer);
      final String trace = SAT_Output.processSMTResponse(sat_result, modified_output_filename, var_set, trace_length);
      LTLGenerator.log((("GENERATED TRACE\n\n" + trace) + "\n"), log_writer);
      log_writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void doGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    LTLGenerator.doGenerate(input, fsa, context, 10, true, "BC_OUTPUT");
  }
}
