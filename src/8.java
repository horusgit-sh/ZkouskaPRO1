/*
 * Polymorfismus je schopnost objektu vystupovat jako objekt různých typů (typicky svého rodiče nebo rozhraní).
 * V praxi to znamená, že můžeme napsat kód, který pracuje s objekty různého typu jednotným způsobem.
 *
 * Typickým příkladem je použití proměnné typu nadtřídy (nebo rozhraní), která odkazuje na instanci podtřídy.
 * Díky přepsání metod (overriding) se pak volá chování specifické pro daný konkrétní typ objektu.
 *
 * Polymorfismus se silně váže na:
 *  - dědičnost (rodičovská a děděná třída),
 *  - abstraktní třídy (které definují společné rozhraní),
 *  - rozhraní (interface).
 *
 * Výhody polymorfismu:
 *  - Zjednodušuje a zkracuje kód (nemusíme psát podmínky podle typu).
 *  - Umožňuje rozšiřitelnost – snadno přidáme nové typy bez změny stávající logiky.
 *  - Podporuje principy návrhových vzorů jako je např. Strategy nebo Factory.
 */

// Abstraktní nadtřída: Zvíře

abstract class Nastroj {
    protected String nazev;

    public Nastroj(String nazev) {
        this.nazev = nazev;
    }

    public abstract void pouzij();
}

// Dvě různé specializace

class Kladivo extends Nastroj {
    public Kladivo(String nazev) {
        super(nazev);
    }

    @Override
    public void pouzij() {
        System.out.println(nazev + " bouchá do hřebíku.");
    }
}

class Sroubovak extends Nastroj {
    public Sroubovak(String nazev) {
        super(nazev);
    }

    @Override
    public void pouzij() {
        System.out.println(nazev + " utahuje šroub.");
    }
}

// Třída využívající polymorfismus

class Technik {
    public void pouzijNastroj(Nastroj nastroj) {
        nastroj.pouzij();  // polymorfní volání
    }
}

// Hlavní třída

class Dilna {
    public static void main(String[] args) {
        Nastroj kladivo = new Kladivo("Červené kladivo");
        Nastroj sroubovak = new Sroubovak("Křížový šroubovák");

        Technik t = new Technik();

        t.pouzijNastroj(kladivo);     // Červené kladivo bouchá do hřebíku.
        t.pouzijNastroj(sroubovak);   // Křížový šroubovák utahuje šroub.

        // Pole nástrojů – jednotný přístup přes nadtřídu
        Nastroj[] kufrik = {
                kladivo,
                sroubovak,
                new Kladivo("Malé kladivo"),
                new Sroubovak("Plochý šroubovák")
        };

        for (Nastroj n : kufrik) {
            n.pouzij();  // chování podle konkrétní třídy
        }
    }
}