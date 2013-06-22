package com.flashlight.tiger;

import java.util.TreeSet;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Diese Klasse modelliert Räume in der Welt von Zuul.
 *
 * Ein "Raum" repräsentiert einen Ort in der virtuellen Landschaft des Spiels.
 * Ein Raum ist mit anderen Räumen über Ausgänge verbunden. Für jeden
 * existierenden Ausgang hält ein Raum eine Referenz auf den benachbarten Raum.
 *
 * @author SEBEL, MAXPOWER, klicky
 * @version 2008.03.30
 */
class Raum {

    private String beschreibung;
    private HashMap<String, Raum> ausgaenge;        // die Ausg�nge dieses Raums
    private HashMap<String, Item> items;            // die Items in diesem Raum
    private boolean lift;
    private boolean fernseher;

    /**
     * Erzeuge einen Raum mit einer Beschreibung. Ein Raum hat anfangs keine
     * Ausg�nge.
     *
     * @param beschreibung enth�lt eine Beschreibung in der Form
     */
    public Raum(String beschreibung) {
        this.beschreibung = beschreibung;
        ausgaenge = new HashMap<>();
        items = new HashMap<>();
        fernseher = false;
    }

    /**
     * Definiere einen Ausgang für diesen Raum.
     *
     * @param richtung die Richtung, in der der Ausgang liegen soll
     * @param nachbar der Raum, der über diesen Ausgang erreicht wird
     */
    public void setzeAusgang(String richtung, Raum nachbar) {
        ausgaenge.put(richtung, nachbar);
    }

    public void addItem(String name, Item item) throws IllegalArgumentException {
        if ((items.containsKey(name) && !items.containsValue(item)) || (!items.containsKey(name) && items.containsValue(item))) {
            throw new IllegalArgumentException();
        } else if (items.containsKey(name)) {
            items.get(name).anzahlAendern(1);
        } else {
            items.put(name, item);
        }
    }

    public void removeItem(String name) throws IllegalArgumentException {
        if ((!items.containsKey(name))) {
            throw new IllegalArgumentException();
        } else if (items.get(name).gibAnzahl() > 1) {
            items.get(name).anzahlAendern(-1);
        } else {
            items.remove(name);
        }
    }

    public void schalteLift() {
        lift = !lift;
    }

    public boolean istLift() {
        return lift;
    }

    /**
     * @return die kurze Beschreibung dieses Raums (die dem Konstruktor
     * �bergeben wurde).
     */
    public String gibKurzbeschreibung() {
        return beschreibung;
    }

    /**
     * Liefere eine lange Beschreibung dieses Raums, in der Form: Sie sind in
     * der K�che. Ausg�nge: nord west
     *
     * @return eine lange Beschreibung dieses Raumes.
     */
    public String gibLangeBeschreibung() {
        return "Sie sind " + beschreibung + ".\n" + gibAusgaengeAlsString() + "\n" + gibItemsAlsString();
    }

    /**
     * Liefere eine Zeichenkette, die die Ausg�nge dieses Raums beschreibt,
     * beispielsweise "Ausg�nge: north west".
     *
     * @return Eine Beschreibung der Ausg�nge dieses Raumes.
     */
    private String gibAusgaengeAlsString() {
        if (ausgaenge.size() != 0) {
            String ergebnis = "Ausg�nge:";
            for (String ausgang : new ArrayList<String>(new TreeSet<String>(ausgaenge.keySet()))) {
                ergebnis += "  " + ausgang;
            }
            return ergebnis;
        }
        return "Es gibt keine Ausg�nge.";
    }

    private String gibItemsAlsString() {
        if (items.size() != 0) {
            String ergebnis = "Items:";
            for (String item : items.keySet()) {
                Item itemItem = items.get(item);
                if (itemItem.gibAnzahl() > 1) {
                    ergebnis += "\n  - " + item + " (" + itemItem.gibAnzahl() + " mal vorhanden)";
                } else {
                    ergebnis += "\n  - " + item;
                }
                return ergebnis;
            }
        }
        return "";
    }

    private TreeSet sortedSet() {
        return new TreeSet<String>(ausgaenge.keySet());
    }

    /**
     * Liefere den Raum, den wir erreichen, wenn wir aus diesem Raum in die
     * angegebene Richtung gehen. Liefere 'null', wenn in dieser Richtung kein
     * Ausgang ist.
     *
     * @param richtung die Richtung, in die gegangen werden soll.
     * @return den Raum in der angegebenen Richtung.
     */
    public Raum gibAusgang(String richtung) {
        return ausgaenge.get(richtung);
    }

    public Item gibItem(String item) {
        return items.get(item);
    }

    public void aendereFernseher() {
        fernseher = !fernseher;
    }

    public boolean hatFernseher() {
        return fernseher;
    }
}
