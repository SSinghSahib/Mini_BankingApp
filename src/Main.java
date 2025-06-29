import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Konto erstellen\n2. Anmelden\n3. Beenden");
            System.out.print("\nAuswahl: ");
            int wahl = scanner.nextInt();
            scanner.nextLine();  // für Zeilenumbruch

            switch (wahl) {
                case 1 -> kontoErstellen();
                case 2 -> anmelden();
                // case 3 -> System.exit(0);
                case 3 -> {
                    System.out.println("Programm beendet.");
                    return;
                }
                default -> System.out.println("Ungültige Auswahl.");
            }
        }
    }

    public static void kontoErstellen() {
        System.out.print("Vorname: ");
        String vorname = scanner.nextLine();
        System.out.print("Nachname: ");
        String nachname = scanner.nextLine();
        System.out.print("E-Mail: ");
        String email = scanner.nextLine();
        System.out.print("Passwort: ");
        String passwort = scanner.nextLine();

        Konto konto = bank.kontoErstellen(vorname, nachname, email, passwort);
        System.out.println("Konto erstellt. Kontonummer: " + konto.getKontonummer());

    }

    public static void anmelden() {
        System.out.print("E-Mail: ");
        String email = scanner.nextLine();
        System.out.print("Passwort: ");
        String passwort = scanner.nextLine();

        Konto konto = bank.anmelden(email, passwort);
        if (konto != null) {
            kontoMenue(konto);
        } else {
            System.out.println("Anmeldung fehlgeschlagen.");
        }
    }

    public static void kontoMenue(Konto konto) {
        while (true) {
            System.out.println("\n1. Kontostand anzeigen\n2. Geld einzahlen\n3. Geld abheben\n4. " +
                    "Überweisung\n5. Transaktionen anzeigen\n6. Abmelden");
            System.out.print("\nAuswahl: ");
            int wahl = scanner.nextInt();
            scanner.nextLine();

            switch (wahl) {
                case 1 -> System.out.println("Kontostand: " + konto.getKontostand() + "€");
                case 2 -> {
                    System.out.println("Betrag: ");
                    double betrag = scanner.nextDouble();
                    konto.einzahlen(betrag);
                    System.out.println("Einzahlung erfolgreich.");
                }
                case 3 -> {
                    System.out.println("Betrag: ");
                    double betrag = scanner.nextDouble();
                    if (konto.auszahlen(betrag)) {
                        System.out.println("Auszahlung erfolgreich.");
                    } else {
                        System.out.println("Nicht genug Guthaben.");
                    }
                }
                case 4 -> {
                    System.out.println("Ziel-Kontonummer: ");
                    String zielNummer = scanner.nextLine();
                    System.out.print("Betrag: ");
                    double betrag = scanner.nextDouble();
                    scanner.nextLine(); // für Zeilenumbruch

                    Konto zielkonto = bank.findeKontoNachNummer(zielNummer);
                    if (zielkonto != null) {
                        konto.ueberweisen(zielkonto, betrag);
                        System.out.println("Überweisung erfolgreich.");
                        System.out.println("Neuer Kontostand: " + konto.getKontostand());
                    } else {
                        System.out.println("Zielkonto nicht gefunden.");
                    }
                }
                case 5 -> konto.getTransaktionen().forEach(System.out::println);
                case 6 -> {
                    return;
                }
            }

        }
    }

}