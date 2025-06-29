import java.time.LocalDateTime;

public class Transaktion {

    private String typ;   // z.B. "Einzahlung", "Abhebung", "Überweisung"
    private double betrag;  // z.B. 50.0
    private LocalDateTime zeitpunkt;  // z.B. 2025-05-13T18:42

    // Konstruktor: Zeit wird automatisch gesetzt!
    public Transaktion(String typ, double betrag) {
        this.typ = typ;
        this.betrag = betrag;
        this.zeitpunkt = LocalDateTime.now(); // Aktuelle Zeit
    }

    // toString = schön lesbare Darstellung für Ausgabe
    public String toString(){
        return zeitpunkt + " - " + typ + ": " + betrag + "€";
    }
}
