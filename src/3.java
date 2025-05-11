/*
 * Rozhraní (interface) je v Javě typ, který definuje sadu metod bez jejich implementace.
 * Každá třída, která implementuje rozhraní, musí tyto metody definovat.
 * Rozhraní tvoří "kontrakt" – specifikaci toho, co třída umí, aniž by určovalo, jak to dělá.
 * Signatura metody je její název, návratový typ a parametry – v rozhraní je pouze signatura, ne tělo.
 * Rozhraní podporují polymorfismus: můžeme pracovat s objekty přes jejich společné rozhraní, bez ohledu na konkrétní implementaci.
 * Vztah k dědičnosti: třída může implementovat více rozhraní (na rozdíl od dědičnosti, která je v Javě pouze jednoduchá).
 */

// Definice rozhraní (kontrakt)
interface Zvire {
    void vydatZvuk(); // metoda bez implementace – jen signatura
}

// Třída Pes implementuje rozhraní Zvire
class Pes implements Zvire {
    @Override
    public void vydatZvuk() {
        System.out.println("Haf haf");
    }
}

// Třída Kocka implementuje stejné rozhraní
class Kocka implements Zvire {
    @Override
    public void vydatZvuk() {
        System.out.println("Mňau");
    }
}

// Demonstrace polymorfismu – práce s různými objekty skrze stejné rozhraní
class Q3 {
    public static void main(String[] args) {
        Zvire zvire1 = new Pes();    // objekt typu Pes
        Zvire zvire2 = new Kocka();  // objekt typu Kocka

        zvire1.vydatZvuk(); // Výstup: Haf haf
        zvire2.vydatZvuk(); // Výstup: Mňau

        // I když nevíme přesný typ zvířete, víme, že má metodu vydatZvuk()
    }
}
