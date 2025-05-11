/*
 * Vnitřní třídy jsou třídy, které jsou definovány uvnitř jiné třídy. V Javě existuje několik typů vnitřních tříd:
 * 1. **Nejjednodušší vnitřní třída** (Inner Class): Třída definovaná přímo v metodě nebo v těle jiné třídy.
 * 2. **Statická vnitřní třída** (Static Nested Class): Třída, která je definována jako statická, a tedy se neváže na instanci vnější třídy.
 * 3. **Lokální třída** (Local Class): Třída, která je definována uvnitř metody.
 * 4. **Anonymní třída** (Anonymous Class): Třída bez názvu, která je definována přímo při instanciování objektu.
 *
 * **Výhody vnitřních tříd**:
 * - **Encapsulace**: Vnitřní třída může mít přístup k členům vnější třídy, což umožňuje těsnější propojení mezi těmito třídami.
 * - **Modularita**: Vnitřní třídy umožňují lepší organizaci kódu, když je třída určena pouze pro konkrétní vnější třídu.
 * - **Možnost použití bez nutnosti vytváření samostatné třídy**: Například anonymní třídy jsou často využívány pro implementace rozhraní nebo třídy při použití v metodách.
 */

// Příklad vnitřní třídy (Inner Class)

class VnitrniTrida {
    private String jmeno = "Vnější třída";

    // Vnitřní třída
    class Vnitrni {
        public void vypis() {
            System.out.println("Jméno z vnější třídy: " + jmeno); // Vnitřní třída má přístup k členu vnější třídy
        }
    }

    public void spustitVnitrniTridu() {
        // Vytvoření instance vnitřní třídy
        Vnitrni vnitrni = new Vnitrni();
        vnitrni.vypis();
    }
}

// Statická vnitřní třída (Static Nested Class)

class VnitrniStatickaTrida {
    private static String statickaHodnota = "Statická hodnota";

    static class StatickaVnitrni {
        public void vypis() {
            System.out.println(statickaHodnota); // Statická vnitřní třída může přistupovat pouze ke statickým členům vnější třídy
        }
    }
}

// Příklad použití lokální třídy v metodě

class LokalniTrida {
    public void metoda() {
        // Lokální třída definovaná uvnitř metody
        class Lokalni {
            public void vypis() {
                System.out.println("Toto je lokální třída.");
            }
        }

        // Vytvoření instance lokální třídy
        Lokalni lokalni = new Lokalni();
        lokalni.vypis();
    }
}

// Příklad použití anonymní třídy

class AnonymniTrida {
    public void metoda() {
        // Anonymní třída implementující rozhraní Runnable
        Runnable anonymni = new Runnable() {
            @Override
            public void run() {
                System.out.println("Toto je anonymní třída.");
            }
        };
        anonymni.run();
    }
}

class Main16 {
    public static void main(String[] args) {
        // Ukázka vnitřní třídy
        VnitrniTrida v = new VnitrniTrida();
        v.spustitVnitrniTridu();

        // Ukázka statické vnitřní třídy
        VnitrniStatickaTrida.StatickaVnitrni statickaVnitrni = new VnitrniStatickaTrida.StatickaVnitrni();
        statickaVnitrni.vypis();

        // Ukázka lokální třídy
        LokalniTrida lokalni = new LokalniTrida();
        lokalni.metoda();

        // Ukázka anonymní třídy
        AnonymniTrida anonymniTrida = new AnonymniTrida();
        anonymniTrida.metoda();
    }
}
