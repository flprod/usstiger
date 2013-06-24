/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashlight.tiger;

/**
 *
 * @author Klicky
 */
public class Function {

    private static boolean unterbrochen;

    private Function() { }

    public static void schreibmaschine(String text)
    {
        char[] toCharArray = text.toCharArray();
        for (char letter : toCharArray) {
            print(String.valueOf(letter));
            if(!unterbrochen) {
                try {
                Thread.sleep(30);
                } catch (InterruptedException ex) {
                    break;
                }
            }
        }
    }

    public static void unterbrechen()
    {
        unterbrochen = true;
    }

    public static void print(String text)
    {
        System.out.print(text);
    }

    
    public static void println(String text)
    {
        System.out.println(text);
    }
}
