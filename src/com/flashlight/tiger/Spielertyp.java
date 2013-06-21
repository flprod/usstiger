package com.flashlight.tiger;

/**
 * Repr�sentationen f�r alle g�ltigen Befehlsw�rter des Spiels,
 * zusammen mit einer Zeichenkette in einer bestimmten Sprachen.
 * 
 * @author  Michael K�lling und David J. Barnes
 * @version 2008.03.30
 */
public enum Spielertyp
{
    // Ein Wert f�r jedes Befehlswort, plus eines f�r nicht
    // erkannte Befehle
    ERSTER_OFFIZIER("erster Offizier"), OPS("Kommunikationsoffizier"), CONN("Steuerfrau"), SICHERHEIT("Sicherheitsoffizier"), KNH("Kommandohologramm"), UNKNOWN("?");

    // Das Befehlswort als Zeichenkette.
    private String spieler;

    /**
     * Initialisieren mit dem entsprechenden Befehlswort.
     * @param befehlswort Das Befehlswort als Zeichenkette.
     */
    Spielertyp(String spieler)
    {
        this.spieler = spieler;
    }

    /**
     * @return Das Befehlswort als Zeichenkette.
     */
    @Override
    public String toString()
    {
        return spieler;
    }
}
