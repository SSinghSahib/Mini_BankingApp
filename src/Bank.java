import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Bank {

    private Map<String, Konto> konten = new HashMap<>();

    public Konto kontoErstellen(String vorname, String nachname, String email, String passwort){
        String kontonummer = UUID.randomUUID().toString();
        Benutzer benutzer = new Benutzer(vorname, nachname, email, passwort);
        Konto konto = new Konto(kontonummer, benutzer);
        konten.put(kontonummer, konto);
        return konto;
    }

    public Konto anmelden(String email, String passwort){
        for (Konto konto : konten.values()){
            if (konto.getBenutzer().getEmail().equals(email) &&
            konto.getBenutzer().getPasswort().equals(passwort)){
                return konto;
            }
        }
        return null;
    }

    public Konto findeKontoNachNummer(String kontonummer){
        return konten.get(kontonummer);
    }
}
