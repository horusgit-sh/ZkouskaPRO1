/*
 * Pole (array) a kolekce (collections) jsou základními datovými strukturami v Javě, které slouží pro uchovávání a manipulaci s více hodnotami.
 *
 * - **Pole (Array)**: Statická datová struktura, která uchovává hodnoty pevně definovaného typu a velikosti.
 * - **Kolekce (Collections)**: Dynamické datové struktury, které poskytují větší flexibilitu a bohatší funkce než pole.
 *
 * Hlavní třídy kolekcí:
 * - **List**: Seznam, který umožňuje ukládání prvků v určitém pořadí (např. **ArrayList**, **LinkedList**).
 * - **Set**: Množina, která neumožňuje duplicity (např. **HashSet**).
 * - **Map**: Mapa, která uchovává klíče a hodnoty (např. **HashMap**, **TreeMap**).
 *
 * Algoritmy pro práci s poli a kolekcemi zahrnují operace jako hledání, třídění, filtrování a převody mezi těmito strukturami.
 */

// Importování potřebných tříd pro práci s kolekcemi
import java.util.*;

class PoleAKolekce {

    // Příklad práce s polem
    public void ukazkaPole() {
        // Deklarace a inicializace pole
        int[] pole = {10, 20, 30, 40, 50};

        // Výpis prvků pole
        for (int i = 0; i < pole.length; i++) {
            System.out.println("Prvek na indexu " + i + ": " + pole[i]);
        }
    }

    // Příklad práce s ArrayList (kolekce typu List)
    public void ukazkaList() {
        // Vytvoření dynamického seznamu
        List<String> seznam = new ArrayList<>();

        // Přidání prvků do seznamu
        seznam.add("Petr");
        seznam.add("Jan");
        seznam.add("Karel");

        // Výpis prvků seznamu
        for (String jmeno : seznam) {
            System.out.println("Jméno: " + jmeno);
        }

        // Převod List na pole
        String[] seznamArray = seznam.toArray(new String[0]);
        System.out.println("Převod List na pole: " + Arrays.toString(seznamArray));
    }

    // Příklad práce s HashSet (kolekce typu Set)
    public void ukazkaSet() {
        // Vytvoření množiny (neumožňuje duplicity)
        Set<String> mnozina = new HashSet<>();

        // Přidání prvků
        mnozina.add("Petr");
        mnozina.add("Jan");
        mnozina.add("Petr"); // Duplicitní prvek nebude přidán

        // Výpis prvků množiny
        for (String jmeno : mnozina) {
            System.out.println("Jméno v množině: " + jmeno);
        }
    }

    // Příklad práce s HashMap (kolekce typu Map)
    public void ukazkaMap() {
        // Vytvoření mapy (klíč -> hodnota)
        Map<Integer, String> mapa = new HashMap<>();

        // Přidání klíč-hodnota
        mapa.put(1, "Petr");
        mapa.put(2, "Jan");
        mapa.put(3, "Karel");

        // Výpis klíč-hodnota
        for (Map.Entry<Integer, String> entry : mapa.entrySet()) {
            System.out.println("Klíč: " + entry.getKey() + ", Hodnota: " + entry.getValue());
        }
    }
}

class Main14 {
    public static void main(String[] args) {
        PoleAKolekce ukazky = new PoleAKolekce();

        // Ukázka práce s polem
        ukazky.ukazkaPole();

        // Ukázka práce s ArrayList
        ukazky.ukazkaList();

        // Ukázka práce s HashSet
        ukazky.ukazkaSet();

        // Ukázka práce s HashMap
        ukazky.ukazkaMap();
    }
}
