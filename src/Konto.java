import java.util.ArrayList;
import java.util.List;

public class Konto {

    private String kontonummer;
    private double kontostand;
    private Benutzer benutzer;
    private List<Transaktion> transaktionen;

    // Konstruktor
    public Konto(String kontonummer, Benutzer benutzer) {
        this.kontonummer = kontonummer;
        this.kontostand = 0.00;   // Start mit 0 Euro
        this.benutzer = benutzer;
        this.transaktionen = new ArrayList<>();
    }
    // Getter

    public String getKontonummer() {
        return kontonummer;
    }

    public double getKontostand() {
        return kontostand;
    }

    public Benutzer getBenutzer() {
        return benutzer;
    }

    public List<Transaktion> getTransaktionen() {
        return transaktionen;
    }

    // 1. Einzahlen
    public void einzahlen(double betrag){
        if (betrag > 0){
            kontostand += betrag;
     System.out.println(betrag + "€ eingezahlt. Neuer Kontostand: " + kontostand + "€");
            transaktionen.add(new Transaktion("Einzahlung", betrag));
        }else {
            System.out.println("Ungültiger Betrag zum Einzahlen.");
        }
    }

    // 2. Auszahlen
    public boolean auszahlen(double betrag){
        if (betrag > 0 && betrag <= kontostand){
            kontostand -= betrag;
            System.out.println(betrag + "€ abgehoben. Neuer Kontostand: " + kontostand + "€");
            transaktionen.add(new Transaktion("Einzahlung", betrag));
            return true;
        }else {
            System.out.println("Auszahlung ist nicht möglich - prüfen Sie Betrag und Guthaben.");
        }
        return false;
    }

    // 3.Überweisen
    public void ueberweisen(Konto zielkonto, double betrag){
        if (betrag > 0 && betrag <= kontostand){
            kontostand -= betrag;
            zielkonto.kontostand += betrag;
            System.out.println(betrag + "€ von Konto " + kontonummer + " zu Konto"
            + zielkonto.getKontonummer() + "überwiesen.");
          //  System.out.println("Neuer Kontostand: " + kontostand);
            transaktionen.add(new Transaktion("Überweisung an " + zielkonto.getKontonummer(), betrag));
        }else {
            System.out.println("Überweisung fehlgeschlagen- prüfen Sie betrag und Guthaben.");
        }

    }

}

