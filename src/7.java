/*
 * Přetížení metody (overloading):
 * - V jedné třídě jsou metody se stejným názvem, ale odlišnými parametry (typ, počet, pořadí).
 * - Umožňuje volat jednu metodu různými způsoby podle vstupu.
 * - Rozhodnutí, kterou verzi zavolat, se provádí při kompilaci (compile-time).

 * Přepsání metody (overriding):
 * - Podtřída přepisuje (nahrazuje) metodu zděděnou z rodičovské třídy.
 * - Název, parametry a návratový typ zůstávají stejné.
 * - Umožňuje upravit chování zděděné metody pro konkrétní třídu.
 * - Rozhodnutí, kterou metodu zavolat, se provádí za běhu (run-time).
 */

// Příklad: Přetížení (overloading) v rámci jedné třídy

class Konverter {
    public String prevedNaText(int cislo) {
        return "Číslo: " + cislo;
    }

    public String prevedNaText(double cislo) {
        return "Desetinné číslo: " + cislo;
    }

    public String prevedNaText(boolean stav) {
        return stav ? "ANO" : "NE";
    }
}

// Příklad: Přepsání (overriding) metody v dědičnosti

class Zprava {
    public void vypis() {
        System.out.println("Obecná zpráva.");
    }
}

class ChybovaZprava extends Zprava {
    @Override
    public void vypis() {
        System.out.println("CHYBA: Něco se pokazilo.");
    }
}

class InformacniZprava extends Zprava {
    @Override
    public void vypis() {
        System.out.println("INFO: Všechno proběhlo v pořádku.");
    }
}

// Použití

class VyzkouseniZprav {
    public static void main(String[] args) {
        // Overloading
        Konverter konv = new Konverter();
        System.out.println(konv.prevedNaText(42));
        System.out.println(konv.prevedNaText(3.14));
        System.out.println(konv.prevedNaText(true));

        // Overriding
        Zprava z1 = new ChybovaZprava();
        Zprava z2 = new InformacniZprava();

        z1.vypis();  // volá přepsanou metodu z ChybovaZprava
        z2.vypis();  // volá přepsanou metodu z InformacniZprava
    }
}
