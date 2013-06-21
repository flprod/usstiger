/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.java.dev.a_jar_stdio_terminal;

/**
 *
 * @author Klicky
 */
class StudioTerm {
    public static void main(String args[]) {
  attach(null);
  getStdioNames();
  theFrame.setTitle(stdioTerminalTitle);
  if (stdioClassName == null)
    return;
  try {
    Class stdioClass = Class.forName(
        stdioClassName);
    Method main = stdioClass.getDeclaredMethod(
        "main", new Class[] 
        {java.lang.String[].class});
    main.invoke(null, new Object[]
        {new String[]{}});
    detach();
  } catch (Exception e) {
    System.err.printf("Cant use "%s"\n", 
        stdioClassName);
    if (e instanceof InvocationTargetException) {
      e.getCause().printStackTrace(System.err);
    } else
      System.err.println(e);
  }
}
    
    public static void attach(String title) {
  if (me == null) {
    me = new StudioTerm(title == null ? 
        stdioTerminalTitle : title);
    oldOut = System.out;
    oldErr = System.err;
    oldIn = System.in;
    System.setIn(in);
    System.setOut(out);
    System.setErr(err);
  } 
}


}
