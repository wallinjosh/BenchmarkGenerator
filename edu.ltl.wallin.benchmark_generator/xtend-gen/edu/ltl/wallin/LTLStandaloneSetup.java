/**
 * generated by Xtext 2.14.0
 */
package edu.ltl.wallin;

import edu.ltl.wallin.LTLStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class LTLStandaloneSetup extends LTLStandaloneSetupGenerated {
  public static void doSetup() {
    new LTLStandaloneSetup().createInjectorAndDoEMFRegistration();
  }
}
