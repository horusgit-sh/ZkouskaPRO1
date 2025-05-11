/*
 * Funkcionální programování v Javě je styl programování, který se zaměřuje na použití funkcí jako hodnot,
 * což znamená, že funkce mohou být předávány jako argumenty, vraceny jako výsledky nebo přiřazeny k proměnným.
 * V Javě je funkcionální programování možné díky rozhraním, lambda výrazům a některým funkcím vyššího řádu,
 * které umožňují funkcionální styl programování spolu s OOP (Objektově orientovaným programováním).
 *
 * 1. **Funkcionální rozhraní**:
 *    - Funkcionální rozhraní je rozhraní, které má právě jednu abstraktní metodu. Může mít více metod s výchozí implementací,
 *      ale pouze jednu abstraktní.
 *    - Funkcionální rozhraní lze používat s lambda výrazy.
 *
 * 2. **Lambda výrazy**:
 *    - Lambda výrazy umožňují zapsat anonymní funkce (funkce bez názvu), což umožňuje vytvářet jednoduché funkce bez potřeby
 *      implementovat celé rozhraní nebo třídu.
 *    - Jsou používány k předání funkcí jako argumentů do metod.
 *
 * 3. **Funkce vyššího řádu (Higher-order functions)**:
 *    - Funkce vyššího řádu jsou funkce, které mohou přijímat jiné funkce jako argumenty nebo vracet funkce jako výsledek.
 *    - Mnoho funkcí v knihovnách Javy, jako `map`, `filter`, `reduce`, jsou funkce vyššího řádu.
 *
 * 4. **Map-Reduce funkce**:
 *    - Funkce `map` a `reduce` jsou funkce vyššího řádu, které umožňují operace na kolekcích.
 *    - **map**: Aplikuje funkci na každý prvek kolekce a vrátí novou kolekci s výsledky.
 *    - **reduce**: Kombinuje prvky kolekce do jedné hodnoty podle definované funkce.
 */

// Příklad použití funkcionálního programování v Javě s lambda výrazy a funkcemi vyššího řádu

import java.util.*;
import java.util.stream.*;

class FunkcionalniProgramovani {

    // Funkcionální rozhraní pro demonstraci lambda výrazu
    @FunctionalInterface
    interface Operace {
        int provest(int a, int b);
    }

    // Příklad použití funkce vyššího řádu (map-reduce)
    public static void main(String[] args) {

        // Příklad funkcionálního rozhraní s lambda výrazem
        Operace soucet = (a, b) -> a + b;  // Lambda výraz pro součet
        Operace soucin = (a, b) -> a * b;  // Lambda výraz pro součin

        System.out.println("Soucet: " + soucet.provest(5, 3));  // Výstup: 8
        System.out.println("Soucin: " + soucin.provest(5, 3));  // Výstup: 15

        // Příklad map-reduce s kolekcí
        List<Integer> cisla = Arrays.asList(1, 2, 3, 4, 5);

        // Použití map pro změnu hodnot v seznamu
        List<Integer> zvysenaCisla = cisla.stream()
                .map(x -> x * 2)  // Každé číslo v seznamu vynásobíme 2
                .collect(Collectors.toList());
        System.out.println("Zvýšená čísla: " + zvysenaCisla);  // Výstup: [2, 4, 6, 8, 10]

        // Použití reduce pro sečítání všech čísel v seznamu
        int soucetCisel = cisla.stream()
                .reduce(0, (a, b) -> a + b);  // Sečítání všech čísel
        System.out.println("Součet čísel: " + soucetCisel);  // Výstup: 15
    }
}
