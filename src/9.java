/*
 * Ladění kódu (debugging) je proces, kdy vývojář hledá a odstraňuje chyby v programu.
 * Existují tři hlavní typy chyb:
 * 1. **Syntaktické chyby** - když kód neodpovídá syntaxi jazyka (např. chybí středník nebo závorka).
 * 2. **Logické chyby** - program běží, ale nedává očekávaný výstup (např. špatně napsané podmínky).
 * 3. **Běhové chyby** - chyba, která se objeví při běhu programu (např. dělení nulou nebo přístup k neexistujícímu indexu pole).
 *
 * **Debugger** je nástroj pro ladění, který umožňuje:
 * - Spustit program krok za krokem
 * - Zastavit program na konkrétním místě (breakpoint)
 * - Prozkoumat hodnoty proměnných během běhu
 *
 * **Breakpoint** je místo v kódu, kde chcete, aby debugger zastavil provádění programu a umožnil vám prozkoumat stav.
 *
 * Pomocí debuggeru můžete zjistit, kde program nefunguje správně a opravit chyby.
 */

// Příklad kódu s běhovou chybou (Runtime error)

class Kalk {
    // Metoda pro dělení dvou čísel
    public double deleni(int a, int b) {
        return a / b;  // Pokud b == 0, dojde k běhové chybě
    }

    public static void main(String[] args) {
        Kalk k = new Kalk();
        int vysledek = (int) k.deleni(10, 0);  // Tento řádek způsobí běhovou chybu, protože dělení nulou není povoleno
        System.out.println("Výsledek: " + vysledek);
    }
}

// Debugging postup:
// 1. Použijte debugger v IDE (např. IntelliJ nebo Eclipse).
// 2. Nastavte breakpoint na řádek s metodou deleni(10, 0).
// 3. Spusťte program v ladicím režimu.
// 4. Když debugger zastaví program na breakpointech, můžete zkontrolovat hodnoty proměnných (v tomto případě proměnná "b" je 0).
// 5. Po zjištění, že "b" je 0, můžete přidat kontrolu na nulu a opravit kód.

