package com.flashlight.tiger;

/**
 * Dies ist die Hauptklasse der Anwendung "Die Welt von Zuul". "Die Welt von
 * Zuul" ist ein sehr einfaches, textbasiertes Adventure-Game. Ein Spieler kann
 * sich in einer Umgebung bewegen, mehr nicht. Das Spiel sollte auf jeden Fall
 * ausgebaut werden, damit es interessanter wird!
 *
 * Zum Spielen muss eine Instanz dieser Klasse erzeugt werden und an ihr die
 * Methode "spielen" aufgerufen werden.
 *
 * Diese Instanz dieser Klasse erzeugt und initialisiert alle anderen Objekte
 * der Anwendung: Sie legt alle Räume und einen Parser an und startet das Spiel.
 * Sie wertet auch die Befehle aus, die der Parser liefert und sorgt für ihre
 * Ausführung.
 *
 * @author SebeL, maXpower & Klicky
 * @version 2008.03.30
 */
class Spiel {

    private Parser parser;
    private Raum aktuellerRaum;
    private Player spieler;

    /**
     * Die main-Klasse des Spiels
     *
     * @param args
     */
    public static void main(String[] args) {
        Spiel spiel;
        spiel = new Spiel();
    }

    /**
     * Erzeuge ein Spiel und initialisiere die interne Raumkarte.
     */
    public Spiel() {
        raeumeAnlegen();
        parser = new Parser();
        spielen();
    }

    /**
     * Erzeuge alle Räume und verbinde ihre Ausgänge miteinander.
     */
    private void raeumeAnlegen() {
        // Räume, nach Deck sortiert
        Raum turbolift;
        Raum deck1_1, bereitschaftsraum, beratungsraum;
        Raum deck2_1, deck2_2, captainQuartier, sicherheitsQuartier, opsQuartier, connQuartier, medizinerQuartier, ersterOff;
        Raum deck3_1, deck3_2;
        Raum deck4_1, deck4_2;
        Raum deck5_1, deck5_2, WarpRaum;
        Raum deck6_1, deck6_2, deck6_3, deck6_4, Quartier1, Quartier2, Quartier3, Quartier4, Quartier5, Quartier6, Quartier7, Quartier8;
        Raum Quartier9, Quartier10, Quartier11, Quartier12, Quartier13, Quartier14, Quartier15, Quartier16, Quartier17, Quartier18;
        Raum deck7_1, deck7_2, deck7_3, deck7_4;
        Raum deck8_1, deck8_2, Waffenkammer, Transporterraum;

        // die Räume erzeugen
        turbolift = new Raum("im Turbolift. Bitte wählen Sie Ihr Deck! \ngeben sie \"Deck\" und die Nummer ein.");

        deck1_1 = new Raum("auf Deck 1: Die Bräcke Ihres Schiffes");
        bereitschaftsraum = new Raum("im Bereitschaftsraum des Captains");
        beratungsraum = new Raum("im Beratungsraum der Offiziere");

        deck2_1 = new Raum("auf Deck 2, Sektion 1 (Die Quartiere der ranghäheren Offiziere)");
        deck2_2 = new Raum("auf Deck 2, Sektion 2 (Die Quartiere der ranghäheren Offiziere)");
        captainQuartier = new Raum("im Quartier des Captains A Goodwin. Du siehst einen Fernseher.");
        connQuartier = new Raum("im Quartier des Steuermanns");
        sicherheitsQuartier = new Raum("im Quartier des Sicherheitsoffiziers");
        opsQuartier = new Raum("im Quartier des Kommunikationsoffiziers");
        //medizinerQuartier = new Raum("im Quartier des Schiffarztes");
        ersterOff = new Raum("im Quartier des 1. Offiziers");

        deck3_1 = new Raum("auf der Krankenstation");

        deck4_1 = new Raum("auf den Holodecks");

        deck5_1 = new Raum("im Konsolenbereich des Maschinenraums");
        deck5_2 = new Raum("mitten im Maschinenraum");
        WarpRaum = new Raum("im Raum des Warpkerns.\nVorsicht!!! der Warpantrieb ist instabil. \nDu kannst nur 1 Minute hier bleiben. \nAchte auf die Strahlung");

        deck6_1 = new Raum("in der 1. Sektion von Deck 6");
        deck6_2 = new Raum("in der 2. Sektion von Deck 6");
        deck6_3 = new Raum("in der 3. Sektion von Deck 3");
        deck6_4 = new Raum("in der 4. Sektion von Deck 6");

        deck7_1 = new Raum("in der ersten Sektion von Deck 7");
        deck7_2 = new Raum("in der 2. Sektion von Deck 7");
        deck7_3 = new Raum("in der 3. Sektion von Deck 3");
        deck7_4 = new Raum("in der 4. Sektion von Deck 7");

        deck8_1 = new Raum("auf Deck 8");
        deck8_2 = new Raum("im Shuttlehangar");
        Waffenkammer = new Raum("in der Waffenkammer");
        Transporterraum = new Raum("im Transporterraum. Geben sie ihren gewänschten Zielort ein");

        Quartier1 = new Raum("im Quartier von Private Brooks");
        Quartier2 = new Raum("Im Quartier von Private Farrell");
        Quartier3 = new Raum("im Quartier von Sergant Adams");
        Quartier4 = new Raum("im Quartier von Private Dax");
        Quartier5 = new Raum("im Quartier von Fisrt Sergant Barnett");
        Quartier6 = new Raum("im Quartier von Lieuttanant Weigelt");
        Quartier7 = new Raum("im Quartier von Commander Barret");
        Quartier8 = new Raum("im Quartier von Corporal Robinson");
        Quartier9 = new Raum("im Quartier von Major Lenox");
        Quartier10 = new Raum("im Quartier vom Schiffarzt Gerald");
        Quartier11 = new Raum("im Quartier von Scheffinginiuer Cole");
        Quartier12 = new Raum("im Quartier von Commander Jones");
        Quartier13 = new Raum("im Quartier von Kächencheff Root");
        Quartier14 = new Raum("im Quartier vom Hilfs-Steuermann");
        Quartier15 = new Raum("im Quartier der sexy 2 Krankenschwestern K. Kaccor & A. McNichoos");
        Quartier16 = new Raum("im Quartier der Schiffstiere");
        Quartier17 = new Raum("im Quartier vom Psychologen");
        Quartier18 = new Raum("im Quartier vom Deckoffizier C. Nease");

        // die Ausgänge initialisieren
        turbolift.schalteLift();
        turbolift.setzeAusgang("1", deck1_1);
        turbolift.setzeAusgang("2", deck2_1);
        turbolift.setzeAusgang("3", deck3_1);
        turbolift.setzeAusgang("4", deck4_1);
        turbolift.setzeAusgang("5", deck5_1);
        turbolift.setzeAusgang("6", deck6_1);
        turbolift.setzeAusgang("7", deck7_1);
        turbolift.setzeAusgang("8", deck8_1);

        deck1_1.setzeAusgang("back", turbolift);
        deck1_1.setzeAusgang("right", bereitschaftsraum);
        deck1_1.setzeAusgang("left", beratungsraum);

        deck2_1.setzeAusgang("front", turbolift);
        deck2_1.setzeAusgang("back", deck2_2);
        deck2_1.setzeAusgang("right", connQuartier);
        deck2_1.setzeAusgang("left", sicherheitsQuartier);

        deck2_2.setzeAusgang("front", deck2_1);
        deck2_2.setzeAusgang("right", opsQuartier);
        deck2_2.setzeAusgang("left", ersterOff);
        deck2_2.setzeAusgang("back", captainQuartier);

        deck3_1.setzeAusgang("back", turbolift);

        deck4_1.setzeAusgang("back", turbolift);

        deck5_1.setzeAusgang("back", turbolift);
        deck5_1.setzeAusgang("front", deck5_2);

        deck5_2.setzeAusgang("back", deck5_1);
        deck5_2.setzeAusgang("front", WarpRaum);

        deck6_1.setzeAusgang("back", turbolift);
        deck6_1.setzeAusgang("front", deck6_2);
        deck6_1.setzeAusgang("left", Quartier1);
        deck6_1.setzeAusgang("right", Quartier2);

        deck6_2.setzeAusgang("back", deck6_1);
        deck6_2.setzeAusgang("left", Quartier3);
        deck6_2.setzeAusgang("right", Quartier4);
        deck6_2.setzeAusgang("front", deck6_3);

        deck6_3.setzeAusgang("back", deck6_2);
        deck6_3.setzeAusgang("left", Quartier5);
        deck6_3.setzeAusgang("right", Quartier6);
        deck6_3.setzeAusgang("front", deck6_4);

        deck6_4.setzeAusgang("back", deck6_3);
        deck6_4.setzeAusgang("left", Quartier7);
        deck6_4.setzeAusgang("right", Quartier8);
        deck6_4.setzeAusgang("front", Quartier9);

        deck7_1.setzeAusgang("back", turbolift);
        deck7_1.setzeAusgang("front", deck7_2);
        deck7_1.setzeAusgang("left", Quartier10);
        deck7_1.setzeAusgang("right", Quartier11);

        deck7_2.setzeAusgang("back", deck7_1);
        deck7_2.setzeAusgang("left", Quartier12);
        deck7_2.setzeAusgang("right", Quartier13);
        deck7_2.setzeAusgang("front", deck7_3);

        deck7_3.setzeAusgang("back", deck7_2);
        deck7_3.setzeAusgang("left", Quartier14);
        deck7_3.setzeAusgang("right", Quartier15);
        deck7_3.setzeAusgang("front", deck7_4);

        deck7_4.setzeAusgang("back", deck7_3);
        deck7_4.setzeAusgang("left", Quartier16);
        deck7_4.setzeAusgang("right", Quartier17);
        deck7_4.setzeAusgang("front", Quartier18);

        deck8_1.setzeAusgang("back", turbolift);
        deck8_1.setzeAusgang("front", deck8_2);
        deck8_1.setzeAusgang("left", Transporterraum);
        deck8_1.setzeAusgang("right", Waffenkammer);

        deck8_2.setzeAusgang("back", deck8_1);

        Waffenkammer.setzeAusgang("left", deck8_1);

        Transporterraum.setzeAusgang("right", deck8_1);

        WarpRaum.setzeAusgang("back", deck5_2);

        Quartier1.setzeAusgang("right", deck6_1);
        Quartier2.setzeAusgang("left", deck6_1);
        Quartier3.setzeAusgang("right", deck6_2);
        Quartier4.setzeAusgang("left", deck6_2);
        Quartier5.setzeAusgang("right", deck6_3);
        Quartier6.setzeAusgang("left", deck6_3);
        Quartier7.setzeAusgang("right", deck6_4);
        Quartier8.setzeAusgang("left", deck6_4);
        Quartier9.setzeAusgang("back", deck6_4);

        Quartier10.setzeAusgang("right", deck7_1);
        Quartier11.setzeAusgang("left", deck7_1);
        Quartier12.setzeAusgang("right", deck7_2);
        Quartier13.setzeAusgang("left", deck7_2);
        Quartier14.setzeAusgang("right", deck7_3);
        Quartier15.setzeAusgang("left", deck7_3);
        Quartier16.setzeAusgang("right", deck7_4);
        Quartier17.setzeAusgang("left", deck7_4);
        Quartier18.setzeAusgang("back", deck7_4);

        bereitschaftsraum.setzeAusgang("left", deck1_1);

        beratungsraum.setzeAusgang("right", deck1_1);

        captainQuartier.setzeAusgang("front", deck2_2);

        opsQuartier.setzeAusgang("left", deck2_2);

        connQuartier.setzeAusgang("left", deck2_1);

        sicherheitsQuartier.setzeAusgang("right", deck2_1);

        ersterOff.setzeAusgang("right", deck2_2);

        // Variablen der Items werden deklariert
        Item Phaser, Plasmabrenner, Truemmer, PAD, DVC, Kugelschreiber, Hypospray;
        Item Kommunikator, Multitool, IsoChip, Schutzanzug, Tasse;

        // neue Items werden 'gemacht'
        Kommunikator = new Item("Kommunikator", "Hiermit kännen Sie versuchen Ihre Kameraden anzufunken");
        Plasmabrenner = new Item("Plasmabrenner", "Dieser Plasmabrenner eignet sich hervorragend um sich einen Weg durch geschlossene Shots zu brennen");
        Phaser = new Item("Phaser", "Eine Energiewaffe, die Ziele betäuben, täten oder atomisiern kann. \n (um den Modus des Phasers zu ändern, geben Sie switch und Phaser und beteuben, toeten oder atomisieren ein.)");
        Truemmer = new Item("Truemmer", "Eins Stäck der Wand.");
        Multitool = new Item("Multitool", "Handwerkzeug fär kleinere Arbeiten/Reparaturen");
        IsoChip = new Item("IsoChip", "'Schlässel' mit sämtlichen Autorisierungscodes.");
        Schutzanzug = new Item("Schtzanzug", "Dies ist ein Schutzanzug, der Sie bedingt vor Strahlung schätzen kann.");
        Tasse = new Item("Tasse", "Dies ist eine leere Tasse, mit ein paar Kaffeeresten.");
        PAD = new Item("PAD", "Dieser PAD entält Notizen vom letzten Treffen im Beratungsraum(Vielleicht eine Angriffsstrategie)");
        DVC = new Item("DVC", "Dieser DVC enthält Informationen des Captains, die fär den Fall seiner Abwesenheit bestimmt sind. \n  Sie kännen das Video nur in diesem Raum gucken. \n  Geben Sie dazu watch + Video ein.");
        Kugelschreiber = new Item("Kugelschreiber", "Ein antiker Stift, mit dem fräher etwas aufgeschrieben wurde.");
        Hypospray = new Item("Hypospray", "Mit diesem Hypospray kännen sie sich im NOTFALL (unter 2 Leben) ein kleines Bisschen regenerieren.");

        // hier werden den Räumen Gegenstände zugeordnet
        Waffenkammer.addItem("Phaser", Phaser);
        opsQuartier.addItem("Kommunikator", Kommunikator);
        deck5_1.addItem("Plasmabrenner", Plasmabrenner);
        deck1_1.addItem("Truemmer", Truemmer);
        sicherheitsQuartier.addItem("Phaser", Phaser);
        deck5_2.addItem("Schutzanzug", Schutzanzug);
        bereitschaftsraum.addItem("Tasse", Tasse);
        beratungsraum.addItem("PAD", PAD);
        captainQuartier.addItem("DVC", DVC);
        Quartier4.addItem("Kugelschreiber", Kugelschreiber);
        Quartier15.addItem("Hypospray", Hypospray);
        ersterOff.addItem("Iso Chip", IsoChip);
        connQuartier.addItem("Multitool", Multitool);

        //hier werden verschiedene Zustände gesetzt:
        captainQuartier.aendereFernseher();
        deck1_1.aendereFernseher();


        aktuellerRaum = deck1_1;  // das Spiel startet hier
    }

    /**
     * Die Hauptmethode zum Spielen. Läuft bis zum Ende des Spiels in einer
     * Schleife.
     */
    private void spielen() {
        willkommenstextAusgeben();
        spieler = new Player();
        itemsVerteilen();
        println("Tippen sie \"" + Befehlswort.USE + "\" + Tricoder, wenn Sie Hilfe brauchen.");
        println(aktuellerRaum.gibLangeBeschreibung());
        // Die Hauptschleife. Hier lesen wir wiederholt Befehle ein
        // und fähren sie aus, bis das Spiel beendet wird.

        boolean beendet = false;
        while (!beendet) {
            Befehl befehl = parser.liefereBefehl();
            beendet = verarbeiteBefehl(befehl);
        }
        println("Danke fär dieses Spiel. Auf Wiedersehen.");
    }

    private void itemsVerteilen() {
        Item Tricorder, IsoChip, Kommunikator, Multitool, Phaser;
        Tricorder = new Item("Tricorder", "Dies ist ein Tricorder. Nutzen Sie ihn fär Hilfe und Scans");
        IsoChip = new Item("IsoChip", "'Schlässel' mit sämtlichen Autorisierungscodes");
        Kommunikator = new Item("Kommunikator", "Gerät zur Kurzstreckenkommunikation");
        Multitool = new Item("Multitool", "Handwerkzeug fär kleinere Arbeiten/Reparaturen");
        Phaser = new Item("Phaser", "Eine Energiewaffe, die Ziele betäuben, täten oder atomisiern kann. \n (um den Modus des Phasers zu ändern, geben Sie switch und Phaser und beteuben, toeten oder atomisieren ein.)");

        spieler.aufheben("Tricorder", Tricorder);
        switch (spieler.gibSpieler2().gibSpielertyp()) {
            case ERSTER_OFFIZIER:
                spieler.aufheben("IsoChip", IsoChip);
                break;
            case OPS:
                spieler.aufheben("Kommunikator", Kommunikator);
                break;
            case CONN:
                spieler.aufheben("Multitool", Multitool);
                break;
            case SICHERHEIT:
                spieler.aufheben("Phaser", Phaser);
                break;
        }
    }

    /**
     * Einen Begrääungstext fär den Spieler ausgeben.
     */
    private void willkommenstextAusgeben() {
        String text;
        char[] toCharArray;
        text = "\u000C\nWillkommen zu U.S.S Tiger!\nU.S.S. Tiger ist ein nicht mehr ganz so langweiliges  Spiel.\nSie äffenen langsam ihre Augen, in ihre Nase beiät sich der Geruch von verbranntem Trinium.\nSie rangen sich instinktiv zu einer Konsole und aktivieren die Klimakontrolle.\nIhr Kopf schmerzt. Was ist passiert? Wo bin ich? Wer bin ich?\n";
        toCharArray = text.toCharArray();
        for (char letter : toCharArray) {
            print(String.valueOf(letter));
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                break;
            }
        }
    }

    /**
     * Verarbeite einen gegebenen Befehl (fähre ihn aus).
     *
     * @param befehl Der zu verarbeitende Befehl.
     * @return 'true', wenn der Befehl das Spiel beendet, 'false' sonst.
     */
    private boolean verarbeiteBefehl(Befehl befehl) {
        boolean moechteBeenden = false;

        Befehlswort befehlswort = befehl.gibBefehlswort();

        if (befehlswort == Befehlswort.UNKNOWN) {
            println("Ich weiä nicht, was Sie meinen...");
            return false;
        }

        switch (befehlswort) {
            case USE:
                benutzen(befehl);
                break;
            case GO:
                wechsleRaum(befehl);
                break;
            case QUIT:
                moechteBeenden = beenden(befehl);
                break;
            case TAKE:
                nehmen(befehl);
                break;
            case DROP:
                fallenLassen(befehl);
                break;
            case INVENTORY:
                spieler.inventarAusgeben();
                break;
            case DECK:
                deckAuswaehlen(befehl);
                break;
            case LOOK:
                println(aktuellerRaum.gibLangeBeschreibung());
                break;
            case SWITCH:
                switchen(befehl);
                break;
            case WATCH:
                angucken(befehl);
                break;
        }
        return moechteBeenden;
    }

    // Implementierung der Benutzerbefehle:
    private void println(String string) {
        System.out.println(string);
    }

    private void print(String string) {
        System.out.print(string);
    }

    private void nichtImplentiert() {
        println("Dieser Befehl wurde noch nicht implentiert!");
    }

    /**
     * Gib Hilfsinformationen aus. Hier geben wir eine etwas alberne und unklare
     * Beschreibung aus, sowie eine Liste der Befehlswärter.
     */
    private void hilfstextAusgeben() {
        println("Ihnen stehen folgende Befehle zur Verfägung:");
        parser.zeigeBefehle();
    }

    /**
     * Versuche, den Raum zu wechseln. Wenn es einen Ausgang gibt, wechsele in
     * den neuen Raum, ansonsten gib eine Fehlermeldung aus.
     */
    private void wechsleRaum(Befehl befehl) {
        if (!aktuellerRaum.istLift()) {
            if (!befehl.hatZweitesWort()) {
                // Gibt es kein zweites Wort, wissen wir nicht, wohin...
                println("Wohin mächten Sie gehen?");
                return;
            }

            String richtung = befehl.gibZweitesWort();

            // Wir versuchen den Raum zu verlassen.
            Raum naechsterRaum = aktuellerRaum.gibAusgang(richtung);

            if (naechsterRaum == null) {
                println("Dort kännen Sie nicht hingehen!");
            } else {
                aktuellerRaum = naechsterRaum;
                println(aktuellerRaum.gibLangeBeschreibung());
            }
        }
    }

    private void deckAuswaehlen(Befehl befehl) {
        if (aktuellerRaum.istLift()) {
            if (!befehl.hatZweitesWort()) {
                // Gibt es kein zweites Wort, wissen wir nicht, wohin...
                println("Welches Deck wollen sie?");
                return;
            }
            String deck = befehl.gibZweitesWort();

            Raum naechsterRaum = aktuellerRaum.gibAusgang(deck);

            if (naechsterRaum == null) {
                println("Dort kännen Sie nicht hingehen!");
            } else {
                aktuellerRaum = naechsterRaum;
                println(aktuellerRaum.gibLangeBeschreibung());
            }
        }

    }

    private void benutzen(Befehl befehl) {
        if (!befehl.hatZweitesWort()) {
            // Gibt es kein zweites Wort, wissen wir nicht, wohin...
            println("Was mächten sie benutzen?");
            return;
        }
        String Tricorder;
        String benutzeTeilS = befehl.gibZweitesWort();
        // Wir versuchen den Raum zu verlassen.
        if (!(spieler.hatItem(benutzeTeilS))) {
            System.out.println("Dieses Teil haben Sie nicht");
        } else {
            switch (benutzeTeilS) {
                case "Tricorder":
                    hilfstextAusgeben();
                    break;
            }
        }
    }

    private void nehmen(Befehl befehl) {
        if (!befehl.hatZweitesWort()) {
            // Gibt es kein zweites Wort, wissen wir nicht, wohin...
            println("Was mächten sie nehmen?");
            return;
        }

        String nehmeTeil = befehl.gibZweitesWort();
        if ((aktuellerRaum.gibItem(nehmeTeil)) == null) {
            println("Das ist hier nicht.");
        } else {
            spieler.aufheben(nehmeTeil, aktuellerRaum.gibItem(nehmeTeil));
            aktuellerRaum.removeItem(nehmeTeil);
            println("Sie haben ein(e) " + nehmeTeil + " in Ihr Inentar aufgenommen");
        }
    }

    private void fallenLassen(Befehl befehl) {
        if (!befehl.hatZweitesWort()) {
            // Gibt es kein zweites Wort, wissen wir nicht, wohin...
            println("Was mächten sie fallen lassen???");
            return;
        }

        String fallenLasseTeil = befehl.gibZweitesWort();
        if (!(spieler.hatItem(fallenLasseTeil))) {
            println("Das haben sie nicht.");
        } else {
            aktuellerRaum.addItem(fallenLasseTeil, spieler.gibItem(fallenLasseTeil));
            spieler.fallenLassen(fallenLasseTeil);
            println("Sie haben ein(e) " + fallenLasseTeil + " fallen gelassen");
        }
    }

    private void switchen(Befehl befehl) {
        if (!befehl.hatZweitesWort()) {
            // Gibt es kein zweites Wort, wissen wir nicht, wohin...
            println("Was mächten sie switchen???");
            return;
        }

        String switchTeil = befehl.gibZweitesWort();
        String switchRichtung = befehl.gibDrittesWort();
        boolean geswitcht = false;
        if (!(spieler.hatItem(switchTeil))) {
            println("Das haben sie nicht.");
        } else {
            switch (switchTeil) {
                case "Phaser":
                    switch (switchRichtung) {
                        case "beteuben":
                            spieler.gibItem(switchTeil).aendereZustand(switchRichtung);
                            geswitcht = true;
                            break;
                        case "toeten":
                            spieler.gibItem(switchTeil).aendereZustand(switchRichtung);
                            geswitcht = true;
                            break;
                        case "atomisieren":
                            spieler.gibItem(switchTeil).aendereZustand(switchRichtung);
                            geswitcht = true;
                            break;
                        default:
                            println("Dieser Zustand ist hier nicht verfägbar.");
                    }
                    break;
                default:
                    println("Das kännen Sie nicht switchen.");
            }
        }

        if (geswitcht) {
            println("Sie haben " + switchTeil + " auf " + switchRichtung + " geswitcht.");
        }
    }

    private void angucken(Befehl befehl) {
        if (!befehl.hatZweitesWort()) {
            // Gibt es kein zweites Wort, wissen wir nicht, wohin...
            println("Was mächten Sie sich angucken???");
            return;
        }

        String anguckTeil = befehl.gibZweitesWort();

        if (!(spieler.hatItem(anguckTeil))) {
            println("Das haben sie nicht.");
        } else {
            switch (anguckTeil) {
                case "DVC":
                    if (aktuellerRaum.hatFernseher()) {
                        DVCTextAusgeben();
                    } else {
                        println("Das geht hier nicht");
                    }
                    break;
            }
        }
    }

    private void DVCTextAusgeben() {
        println("Sie sehen auf dem Bildschirm den Captain, der ihnen folgenden Text sagt: \n ");
        println("Wenn ihr dieses Video sieht, bin ich vermutlich tot, oder kurz davor.");
        println("Versucht nicht mein Wohl äber das der Tiger, oder der Crew zu stellen. (Ihr wisst ich wärde es auch nicht tun)");
        println("Denkt daran einen neuen Captain zu ernennen. (Geht nach der Rangfolge vor)");
        println("Ich wänche euch nun, dass ihr nicht in ein Chaos fällt.");
        println("Trauert nicht um mich, vollendet unsere Mission (wenn mäglich) und bringt die Tiger und die Crew sicher zur nächsten Basis");
        println("Es war mir eine Ehre auf der Tiger gedient zu haben und ich weiä, dass diese Crew mit bestem Gewissen die grääte Ehre der Sternenflotte hat.");
        println("\n Captain Goodwin");
    }

    /**
     * "quit" wurde eingegeben. äberpräfe den Rest des Befehls, ob das Spiel
     * wirklich beendet werden soll.
     *
     * @return 'true', wenn der Befehl das Spiel beendet, 'false' sonst.
     */
    private boolean beenden(Befehl befehl) {
        if (befehl.hatZweitesWort()) {
            println("Was soll beendet werden?");
            return false;
        } else {
            return true;  // Das Spiel soll beendet werden.
        }
    }
}