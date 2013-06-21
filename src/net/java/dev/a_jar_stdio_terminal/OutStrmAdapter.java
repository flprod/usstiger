package net.java.dev.a_jar_stdio_terminal;
import java.io.*;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;

public class OutStrmAdapter extends OutputStream {
  public OutStrmAdapter(StudioTerm owner, 
      SimpleAttributeSet textAttr) {
    this.owner = owner;
    theDocument = owner.theDocument;
    this.textAttr = textAttr;
  }
  public void write(byte b[], int off, int len) 
      throws IOException {
    try {
      theDocument.insertString(
          theDocument.getLength(), 
          new String(b, off, len), textAttr);
    } catch (Exception e) {/* Not expected */}
    owner.configureDisplay();
  }
  public void write(int c) throws IOException {
    tempChar[0] = (byte)c;
    try {
      theDocument.insertString(
          theDocument.getLength(), 
          new String(tempChar), textAttr);
    } catch (Exception e) {/* Not expected */}
    owner.configureDisplay();
  }
  private byte tempChar[] = new byte[1];
  private Document theDocument;
  private SimpleAttributeSet textAttr;
  private StudioTerm owner;
}