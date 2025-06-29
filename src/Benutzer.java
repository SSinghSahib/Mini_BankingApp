public class Benutzer {

    private String vorname;
    private String nachname;
    private String email;
    private String passwort;

    public Benutzer(String vorname, String nachname, String email, String passwort) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.passwort = passwort;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswort() {
        return passwort;
    }
}
