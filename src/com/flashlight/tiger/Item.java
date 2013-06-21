package com.flashlight.tiger;

/**
 * Write a description of class Item here.
 * 
 * @author (MaxPower, Sebel, Klicky) 
 * @version (a version number or a date)
 */
public class Item
{

    private String name;
    private String beschreibung;
    private String Zustand;
    private String neuerZustand;
    private int anzahl;

    /**
     * Constructor for objects of class Item
     */
    public Item(String name, String beschreibung)
    {
        this.name = name;
        this.beschreibung = beschreibung;
        Zustand = null;
    }

    public void anzahlAendern (int veraenderung)
    {
        anzahl += veraenderung;
    }

    public String gibBeschreibung ()
    {
        return beschreibung;
    }

    public String gibName ()
    {
        return name;
    }
    
    public int gibAnzahl ()
    {
        return anzahl;
    }

    public String ausgeben ()
    {
        String ergebnis = null;
        if (anzahl >= 2) {
            ergebnis = name + ": " + beschreibung +  "(" + anzahl + "mal vorhanden.)";
        }
        else {
            ergebnis = name + ": " + beschreibung ;
        }
        
        if (Zustand != null) {
            ergebnis += "  Zustand: " + Zustand;
        }
        return ergebnis;
    }
    
    public void aendereZustand (String neuerZustand)
    {
        Zustand = neuerZustand;
    }
    
    public String gibZustand ()
    {
        return Zustand;
    }
}
