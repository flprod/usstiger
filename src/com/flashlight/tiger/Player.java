package com.flashlight.tiger;

import java.util.HashMap;
/**
 * Write a description of class Spieler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private HashMap<String, Item> inventar;
    private HashMap<String, Spielertyp> spielerMap;
    private Spieler spieler;
    private Parser parser;
    private String itemName;

    /**
     * Constructor for objects of class Spieler
     */
    public Player()
    {
        parser = new Parser(true);
        inventar = new HashMap<>();
        spielerMap = new HashMap<>();
        for(Spielertyp spielertyp : Spielertyp.values()) {
            spielerMap.put(spielertyp.toString(), spielertyp);
        }
        spielerWaehlen();
    }

    private void spielerWaehlen()
    {
        boolean gewählt; 
        gewählt = false;
        Spieler newSpieler = null;

        while (!gewählt) {
            System.out.println("Welchen Spieler m�chten Sie w�hlen?");
            System.out.print("Verf�gbar sind: ");
            parser.zeigeSpieler();
            System.out.println("Der Sicherheitsoffizier: \n - hei�t Dr. Johannes Lotz \n - ist halb Mensch, halb Klingone \n - ist auf dem Schiff, wie fr�her (als er noch Lehrer war) die beliebsteste Person \n - ist ein Tempramentvoller, sehr kluger Mann, der f�r die Sicherheit der U.S.S. Tiger zust�ndig ist");
            System.out.println("Das Kommandohologramm: \n - ist ein kommandierendes Notfallhologramm, Version 3.1.1 \n - istanalytisch wie ein Computer \n - ist sehr wiederstandsf�hig");
            System.out.println("Der Kommunikationsoffizier: \n - hei�t Ben Jefferson \n - ist ein flinker Mensch, der es liebt auf B�ume zu klettern \n - ist auf der U.S.S. Tiger f�r die Kommunikation zust�ndig");
            System.out.println("Der erste Offizier: \n - hei�t Trenok. \n - ist ein logischer emotionsloser Vulkanier \n - nimmt die Stelle des Captain ein, wenn dieser nicht da ist");
            System.out.println("Der Steuerfrau: \n - hei�t Audrey \n - ist eine kluge, lebensfreudige Andorianarin \n - bringt das Schiff an jeden Ort");
            System.out.println("");
            newSpieler = gibSpieler();
            if(newSpieler != null) {
                if(newSpieler.gibSpielertyp() == Spielertyp.UNKNOWN) {
                    System.out.println("Dieser Spieler existiert nicht!\n");
                }
                else {
                    gewählt = true;
                }
            } else {
                System.out.println("Bitte geben Sie etwas ein.\n");
            }
        }
        spieler = newSpieler;
        System.out.println("Sie sind nun " + spieler.gibSpielertyp().toString() + ". \n");
    }

    private Spieler gibSpieler()
    {
        return parser.liefereSpieler();
    }

    public Spieler gibSpieler2()
    {
        return spieler;
    }

    public void inventarAusgeben()
    {
        for(Item item : inventar.values()) {
            System.out.println(item.ausgeben());
        }
    }

    public void aufheben(String name, Item item)
    {
        int max = 10;
        if (inventar.size()<max) {
            inventar.put(name, item);
        }
        else {
            System.out.println("Sie haben zu viel im Inventar. (max. " + max + "). \nLassen sie etwas nutzloses fallen, wenn sie " + name + " umbedingt brauchen, oder gehen sie einfach weiter.");
        }
    }

    public Item gibItem(String itemName)
    {
        return inventar.get(itemName);
    }

    public void fallenLassen(String name)
    {
        inventar.remove(name);
    }

    public boolean hatItem(String name)
    {
        return inventar.containsKey(name);
    }

    public boolean hatItem(Item item)
    {
        return inventar.containsValue(item);
    }
}