/*
 * Zapouzdření (encapsulation) je základní princip objektově orientovaného programování (OOP), který zajišťuje,
 * že data (členy třídy) jsou chráněna před přímým přístupem zvenčí a mohou být modifikována pouze prostřednictvím
 * veřejných metod, které definují konkrétní chování.
 *
 * Význam zapouzdření:
 * - Ochrana dat: Zabraňuje nechtěným změnám vnitřních dat třídy.
 * - Udržování integrity: Třída má plnou kontrolu nad tím, jak jsou její data měněna.
 * - Zjednodušení údržby kódu: Změny v implementaci třídy neovlivní zbytek programu, pokud jsou veřejné metody správně definovány.
 *
 * Důsledky nedodržení zapouzdření:
 * - **Porušení integrity dat**: Členy třídy mohou být změněny zvenčí, což může vést k nekonzistencím nebo chybám.
 * - **Těžší údržba kódu**: Při změně implementace třídy může být nutné upravit všechny části kódu, které na ni odkazují.
 * - **Snížená bezpečnost**: Umožnění přímého přístupu k citlivým datům může vést k nežádoucím únikům informací.
 */

// Třída pro demonstraci zapouzdření
class Osoba {
    // Soukromé atributy, které nejsou přímo přístupné zvenčí
    private String jmeno;
    private int vek;

    // Veřejný konstruktor pro nastavení jména a věku
    public Osoba(String jmeno, int vek) {
        this.jmeno = jmeno;
        this.vek = vek;
    }

    // Veřejná metoda pro získání jména
    public String getJmeno() {
        return jmeno;
    }

    // Veřejná metoda pro změnu jména
    public void setJmeno(String jmeno) {
        if (jmeno != null) {
            this.jmeno = jmeno;
        }
    }

    // Veřejná metoda pro získání věku
    public int getVek() {
        return vek;
    }

    // Veřejná metoda pro změnu věku
    public void setVek(int vek) {
        if (vek > 0) {
            this.vek = vek;
        }
    }

    // Metoda pro zobrazení informací o osobě
    public void vypisInformace() {
        System.out.println("Jméno: " + jmeno);
        System.out.println("Věk: " + vek);
    }
}

// Hlavní třída pro testování zapouzdření
class Main13 {
    public static void main(String[] args) {
        // Vytvoření objektu osoby
        Osoba osoba = new Osoba("Petr", 30);

        // Přístup k veřejným metodám
        osoba.vypisInformace();  // Jméno: Petr, Věk: 30

        // Změna jména pomocí veřejné metody
        osoba.setJmeno("Jan");
        System.out.println("Po změně jména:");
        osoba.vypisInformace();  // Jméno: Jan, Věk: 30

        // Pokus o přímý přístup k soukromým atributům (tento kód nebude fungovat)
        // osoba.jmeno = "Tomáš";  // Chyba kompilace: jmeno má přístupový modifikátor 'private'
    }
}
