/*
 * Typy kolekcí v Javě:
 * 1. **Seznam (List)**: Kolekce, která uchovává prvky v určitém pořadí a umožňuje duplikáty.
 *    - Příklady: **ArrayList**, **LinkedList**
 *    - Podporuje přístup k prvkům podle indexu.
 *    - Umožňuje duplikáty (mohou existovat dva stejné prvky).
 *
 * 2. **Množina (Set)**: Kolekce, která neumožňuje duplikáty a neudržuje pořadí prvků.
 *    - Příklady: **HashSet**, **TreeSet**
 *    - Neumožňuje přímý přístup podle indexu.
 *    - Prvky jsou unikátní.
 *
 * 3. **Mapa (Map)**: Kolekce, která uchovává páry "klíč-hodnota".
 *    - Příklady: **HashMap**, **TreeMap**
 *    - Klíče jsou unikátní, hodnoty mohou být duplicitní.
 *    - Neumožňuje přístup k hodnotám podle indexu, ale podle klíče.
 *
 * **Porovnání**:
 * - **Seznam** je vhodný, když potřebujeme uchovávat prvky v určitém pořadí nebo provádět operace s indexy.
 * - **Množina** je ideální pro uchovávání unikátních prvků bez ohledu na jejich pořadí.
 * - **Mapa** je nezbytná, pokud potřebujeme přiřadit hodnoty k jedinečným klíčům (např. při vytváření adresáře nebo slovníku).
 */

// Ukázka definice a použití jednotlivých kolekcí

import java.util.*;

class TypyKolekci {

    // Ukázka Seznamu (List)
    public void ukazkaList() {
        List<String> seznam = new ArrayList<>();
        seznam.add("Petr");
        seznam.add("Jan");
        seznam.add("Petr"); // Duplicita povolena

        System.out.println("Seznam:");
        for (String jmeno : seznam) {
            System.out.println(jmeno);
        }
    }

    // Ukázka Množiny (Set)
    public void ukazkaSet() {
        Set<String> mnozina = new HashSet<>();
        mnozina.add("Petr");
        mnozina.add("Jan");
        mnozina.add("Petr"); // Duplicita nebude přidána

        System.out.println("Množina:");
        for (String jmeno : mnozina) {
            System.out.println(jmeno);
        }
    }

    // Ukázka Mapy (Map)
    public void ukazkaMap() {
        Map<Integer, String> mapa = new HashMap<>();
        mapa.put(1, "Petr");
        mapa.put(2, "Jan");
        mapa.put(3, "Karel");

        System.out.println("Mapa:");
        for (Map.Entry<Integer, String> entry : mapa.entrySet()) {
            System.out.println("Klíč: " + entry.getKey() + ", Hodnota: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        TypyKolekci kolekce = new TypyKolekci();

        kolekce.ukazkaList(); // Ukázka seznamu
        kolekce.ukazkaSet();  // Ukázka množiny
        kolekce.ukazkaMap();  // Ukázka mapy
    }
}
