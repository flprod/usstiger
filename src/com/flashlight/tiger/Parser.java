package com.flashlight.tiger;

import java.util.Scanner;

/**
 * Dieser Parser liest Benutzereingaben und wandelt sie in Befehle für das
 * Adventure-Game um. Bei jedem Aufruf liest er eine Zeile von der Konsole und
 * versucht, diese als einen Befehl aus bis zu zwei Wörtern zu interpretieren.
 * Er liefert den Befehl als ein Objekt der Klasse Befehl zurück.
 *
 * Der Parser verfügt über einen Satz an bekannten Befehlen. Er vergleicht die
 * Eingabe mit diesen Befehlen. Wenn die Eingabe keinen bekannten Befehl
 * enthält, dann liefert der Parser ein als unbekannter Befehl gekennzeichnetes
 * Objekt zurück.
 *
 * @author Michael Kölling und David J. Barnes
 * @version 2008.03.30
 */
class Parser {

    private Befehlswoerter befehle;  // hält die gültigen Befehlswörter
    private Spielertypen spieler;
    private Scanner leser;         // Lieferant für eingegebene Befehle
    private boolean istSpieler;

    /**
     * Erzeuge einen Parser, der Befehle von der Konsole einliest.
     */
    public Parser() {
        befehle = new Befehlswoerter();
        leser = new Scanner(System.in);
    }

    /**
     * @param Spieler statt
     */
    public Parser(boolean istSpieler) {
        if (istSpieler) {
            spieler = new Spielertypen();
            leser = new Scanner(System.in);
            this.istSpieler = istSpieler;
        }
    }

    /**
     * @return Den n�chsten Befehl des Benutzers.
     */
    public Befehl liefereBefehl() {
        String eingabezeile;   // f�r die gesamte Eingabezeile
        String wort1 = null;
        String wort2 = null;
        String wort3 = null;

        System.out.print("> ");     // Eingabeaufforderung

        eingabezeile = leser.nextLine();

        // Finde bis zu zwei W�rter in der Zeile
        Scanner zerleger = new Scanner(eingabezeile);
        if (zerleger.hasNext()) {
            wort1 = zerleger.next();     // erstes Wort lesen
            if (zerleger.hasNext()) {
                wort2 = zerleger.next();    // zweites Wort lesen
                // Hinweis: Wir ignorieren den Rest der Eingabezeile.
                if (zerleger.hasNext()) {
                    wort3 = zerleger.next();    // drittes Wort lesen
                    // Hinweis: Wir ignorieren den Rest der Eingabezeile.
                }
            }
        }

        return new Befehl(befehle.gibBefehlswort(wort1), wort2, wort3);
    }

    /**
     * @return Den n�chsten Befehl des Benutzers.
     */
    public Spieler liefereSpieler() {
        String eingabezeile;   // f�r die gesamte Eingabezeile
        String wort = " ";

        System.out.print("> ");     // Eingabeaufforderung

        eingabezeile = leser.nextLine();

        // Finde bis zu zwei W�rter in der Zeile
        Scanner zerleger = new Scanner(eingabezeile);
        if (zerleger.hasNext()) {
            wort = zerleger.next();
            while (zerleger.hasNext()) {
                wort += " " + zerleger.next();
            }
            return new Spieler(spieler.gibSpielertyp(wort));
        }
        return null;
    }

    /**
     * Gib eine Liste der bekannten Befehlsw�rter aus.
     */
    public void zeigeBefehle() {
        befehle.alleAusgeben();
    }

    /**
     * Gib eine Liste der bekannten Spielertypen aus.
     */
    public void zeigeSpieler() {
        spieler.alleAusgeben();
    }
}
