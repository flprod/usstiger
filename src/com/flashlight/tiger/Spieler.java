package com.flashlight.tiger;

/**
 * Objekte dieser Klasse halten Informationen über Spielere,
 * die der Benutzer eingegeben hat. Ein Spieler besteht momentan
 * aus zwei Teilen: einem Spielertyp und einem String.
 * Beim Spieler "nimm karte" beispielsweise sind die beiden
 * Teile NIMM und "karte".
 * 
 * Spielere werden von Benutzern dieser Klasse auf Gültigkeit
 * �berpr�ft. Wenn ein Spieler einen ungültigen Spieler eingegeben
 * hat (ein unbekanntes Wort als Spieler), dann ist das Spielertyp UNKNOWN.
 *
 * Wenn der Spieler nur aus einem Wort bestand, dann ist das
 * zweite Wort <null>.
 * 
 * @author  Michael Kölling und David J. Barnes
 * @version 2008.03.30
 */

class Spieler
{
    private Spielertyp spielertyp;

    /**
     * Erzeuge ein Spielersobjekt. beide Parameter m�ssen angegeben werden,
     * aber der zweite darf 'null' sein.
     * @param befehltyp Das Spielertyp. UNKNOWN, wenn dieser Spieler nicht
     *                   vom Spiel erkannt wurde.
     * @param zweitetyp Das zweite Wort des Spielers. Darf null sein.
     */
    public Spieler(Spielertyp spielertyp)
    {
        this.spielertyp = spielertyp;
    }

    /**
     * Liefere das Spielertyp (das erste Wort) dieses Spielers.
     * Wenn der Spieler nicht verstanden wurde, ist das Ergebnis
     * UNKNOWN.
     * @return Das Spielertyp.
     */
    public Spielertyp gibSpielertyp()
    {
        return spielertyp;
    }

    /**
     * @return 'true', wenn dieser Spieler nicht verstanden wurde.
     */
    public boolean istUnbekannt()
    {
        return (spielertyp == Spielertyp.UNKNOWN);
    }
}

