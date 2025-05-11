/*
 * Asociace 1:N a M:N se v Javě realizují pomocí kolekcí (např. List, Set, Map).
 * Vztah 1:N znamená, že jeden objekt obsahuje (nebo zná) více jiných objektů.
 * Vztah M:N znamená, že objekty na obou stranách mají kolekce odkazující na druhou stranu.
 *
 * Agregace je volná vazba – například třída „Fakulta“ obsahuje „Studenty“,
 * ale studenti mohou existovat i bez fakulty.
 *
 * Kompozice je silná vazba – například „Třída“ obsahuje „Lavice“ – bez třídy lavice neexistuje.
 *
 * Implementačně je rozdíl hlavně v tom, kdo vytváří a ničí objekty, a jak silná je závislost mezi nimi.
 */

// Příklad 1: Agregace 1:N – Fakulta a studenti

import java.util.ArrayList;
import java.util.List;

class S {
    private String jmeno;

    public S(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getJmeno() {
        return jmeno;
    }
}

class Fakulta {
    private String nazev;
    private List<S> studenti;  // Agregace: fakulta obsahuje studenty

    public Fakulta(String nazev) {
        this.nazev = nazev;
        this.studenti = new ArrayList<>();
    }

    public void pridejStudenta(S student) {
        studenti.add(student);
    }

    public void vypisStudenty() {
        System.out.println("Fakulta: " + nazev);
        for (S s : studenti) {
            System.out.println(" - " + s.getJmeno());
        }
    }
}

// Příklad 2: Kompozice – Třída obsahuje Lavice

class Lavice {
    private int cislo;

    public Lavice(int cislo) {
        this.cislo = cislo;
    }

    public int getCislo() {
        return cislo;
    }
}

class Trida {
    private List<Lavice> lavice;

    public Trida(int pocetLavic) {
        lavice = new ArrayList<>();
        for (int i = 1; i <= pocetLavic; i++) {
            lavice.add(new Lavice(i));  // Vytváří lavice uvnitř – kompozice
        }
    }

    public void vypisLavice() {
        System.out.println("Lavice ve třídě:");
        for (Lavice l : lavice) {
            System.out.println(" - Lavice číslo: " + l.getCislo());
        }
    }
}

// Příklad použití

class Q4 {
    public static void main(String[] args) {
        // Agregace
        Fakulta f = new Fakulta("Informatika");
        S s1 = new S("Anna");
        S s2 = new S("Jan");
        f.pridejStudenta(s1);
        f.pridejStudenta(s2);
        f.vypisStudenty();

        // Kompozice
        Trida trida = new Trida(3);
        trida.vypisLavice();
    }
}
