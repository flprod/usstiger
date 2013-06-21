package com.flashlight.tiger;

import java.util.HashMap;

/**
 * Diese Klasse h�lt eine Aufz�hlung aller Befehlsw�rter, die dem
 * Spiel bekannt sind. Mit ihrer Hilfe werden eingetippte Spieler
 * erkannt.
 *
 * @author  Michael K�lling und David J. Barnes
 * @version 2008.03.30
 */

class Spielertypen
{
    // eine Abbildung von Befehlsw�rtern auf Elemente des 
    // Aufz�hlungstyps Spielertyp
    private HashMap<String, Spielertyp> gueltigeSpieler;

    /**
     * Konstruktor - initialisiere die Befehlsw�rter.
     */
    public Spielertypen()
    {
        gueltigeSpieler = new HashMap<>();
        for(Spielertyp spieler : Spielertyp.values()) {
            if(spieler != Spielertyp.UNKNOWN) {
                gueltigeSpieler.put(spieler.toString(), spieler);
            }
        }
    }

    
    /**
     * Finde das Spielertyp, das mit einem Befehls-String verkn�pft ist.
     * @param Spielertyp das nachzuschlagende Wort.
     * @return Das zugeh�rige Spielertyp zum dem Wort oder UNKNOWN,
     *         wenn das Wort kein g�ltiges Spielertyp ist.
     */
    public Spielertyp gibSpielertyp(String wort)
    {
        Spielertyp Spielertyp = gueltigeSpieler.get(wort);
        if(Spielertyp != null) {
            return Spielertyp;
        }
        else {
            return Spielertyp.UNKNOWN;
        }
    }
        
    /**
     * Pr�fe, ob eine gegebene Zeichenkette ein g�ltiger
     * Befehl ist.
     * @return 'true', wenn die gegebene Zeichenkette ein g�ltiger
     * Befehl ist, 'false' sonst.
     */
    public boolean istSpieler(String eingabe)
    {
        return gueltigeSpieler.containsKey(eingabe);
    }

    /**
     * Gib alle g�ltigen Befehlsw�rter auf die Konsole aus.
     */
    public void alleAusgeben() 
    {
        for(String spieler : gueltigeSpieler.keySet()) {
            System.out.print(spieler + "  ");
        }
        System.out.println();
    }
}
