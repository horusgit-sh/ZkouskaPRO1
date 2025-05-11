/*
 *  Třída je šablona, podle které se vytvářejí objekty. Objekt je konkrétní instance třídy.
 *  Vlastnosti (properties) jsou reprezentovány pomocí proměnných uvnitř třídy.
 *  Zapouzdření znamená, že vnitřní stav objektu je skrytý a přístupný pouze přes veřejné metody.
 *  Instanční proměnná je unikátní pro každý objekt. Třídní proměnná (statická) je sdílená mezi všemi objekty třídy.
 *  Metody umožňují interakci s objektem, např. nastavení nebo získání hodnot.
 *  Přístupová práva určují, kdo může pracovat s atributy/metodami (private, public, protected, package-private).
 */

//  Ukázka třídy v Javě

class Auto {
    //  Instanční proměnné (unikátní pro každý objekt)
    private String znacka;       // značka auta (zapouzdřená = private)
    private final int rokVyroby;

    //  Třídní proměnná (statická) – sdílená pro všechny instance
    public static int pocetAut = 0;

    //  Konstruktor – vytvoření nové instance (objektu)
    public Auto(String znacka, int rokVyroby) {
        this.znacka = znacka;
        this.rokVyroby = rokVyroby;
        pocetAut++;  // Zvýší se počet aut vždy, když vytvoříme nové
    }

    //  Veřejná metoda (getter) – přístup ke značce
    public String getZnacka() {
        return znacka;
    }

    //  Veřejná metoda (setter) – nastavení nové značky
    public void setZnacka(String znacka) {
        this.znacka = znacka;
    }

    //  Statická metoda – pracuje se statickou proměnnou
    public static int getPocetAut() {
        return pocetAut;
    }

    //  Metoda pro výpis informací o autě
    public void vypisInfo() {
        System.out.println("Auto: " + znacka + ", Rok výroby: " + rokVyroby);
    }
}

//  Hlavní třída pro spuštění programu
class Main {
    public static void main(String[] args) {
        Auto a1 = new Auto("Škoda", 2015);
        Auto a2 = new Auto("Toyota", 2018);

        a1.vypisInfo();  // Výstup: Auto: Škoda, Rok výroby: 2015
        a2.vypisInfo();  // Výstup: Auto: Toyota, Rok výroby: 2018

        System.out.println("Počet vytvořených aut: " + Auto.getPocetAut());  // 2
    }
}
