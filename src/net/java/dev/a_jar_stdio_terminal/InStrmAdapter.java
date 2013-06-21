package net.java.dev.a_jar_stdio_terminal;
import java.io.*;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;

public class InStrmAdapter extends InputStream {
  public InStrmAdapter(StudioTerm owner, 
      SimpleAttributeSet textAttr) {
    this.owner = owner;
    theDocument = owner.theDocument;
    this.textAttr = textAttr;
  }
  public int read() throws IOException {
    if (owner.inputEofSeen)
      return -1;
    if (owner.inputBuffer.isEmpty()) 
      owner.getUserInput();
    return owner.inputBuffer.remove(0);
  }
  public int read(byte b[], int off, int len) 
      throws IOException {
    if (owner.inputEofSeen)
      return -1;
    if (owner.inputBuffer.isEmpty()) 
      owner.getUserInput();
    int dataLength = Math.min(len, 
        owner.inputBuffer.size());
    for (int i = 0; i < dataLength; ++i)
      b[off + i] = owner.inputBuffer.remove(0);
    return dataLength;
  }
  private byte tempChar[] = new byte[1];
  private Document theDocument;
  private SimpleAttributeSet textAttr;
  private StudioTerm owner;
}
