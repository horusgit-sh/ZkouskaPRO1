/*
 * Dědičnost je základní princip OOP, který umožňuje vytvořit novou třídu (specializaci),
 * která přebírá (dědí) vlastnosti a chování obecnější třídy (generalizace).
 *
 * Generalizace = vytvoření společné nadtřídy pro více konkrétních tříd.
 * Specializace = konkrétní podtřídy, které rozšiřují nebo mění chování nadtřídy.
 *
 * Abstraktní třída obsahuje alespoň jednu abstraktní metodu – tedy metodu bez těla.
 * Nelze z ní vytvářet instance. Používá se pro definici rozhraní a společného chování.
 */

// Abstraktní třída – obecný dopravní prostředek

abstract class DopravniProstredek {
    protected String znacka;

    public DopravniProstredek(String znacka) {
        this.znacka = znacka;
    }

    public void vypisZnacku() {
        System.out.println("Značka: " + znacka);
    }

    // Abstraktní metoda – každé vozidlo musí definovat, jak se pohybuje
    public abstract void pohybujSe();
}

// Specializace – konkrétní dopravní prostředek: auto

class OsobniAuto extends DopravniProstredek {
    public OsobniAuto(String znacka) {
        super(znacka);
    }

    @Override
    public void pohybujSe() {
        System.out.println("Auto jede po silnici.");
    }
}

// Specializace – konkrétní dopravní prostředek: loď

class Plavidlo extends DopravniProstredek {
    public Plavidlo(String znacka) {
        super(znacka);
    }

    @Override
    public void pohybujSe() {
        System.out.println("Loď pluje po vodě.");
    }
}

// Použití dědičnosti v praxi

 class SpusteniDopravy {
    public static void main(String[] args) {
        DopravniProstredek auto = new OsobniAuto("Škoda Octavia");
        DopravniProstredek lod = new Plavidlo("Bohemia");

        auto.vypisZnacku(); // Značka: Škoda Octavia
        auto.pohybujSe();   // Auto jede po silnici.

        lod.vypisZnacku();  // Značka: Bohemia
        lod.pohybujSe();    // Loď pluje po vodě.
    }
}
