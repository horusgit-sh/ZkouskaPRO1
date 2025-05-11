/*
 * Testování softwaru zahrnuje různé typy testů, přičemž **unit testy** jsou určeny k testování jednotlivých částí kódu (metod nebo funkcí).
 * **Unit testy**:
 * - Testují jednotlivé metody nebo funkce izolovaně, bez závislosti na ostatním kódu.
 * - Umožňují zjistit, zda metoda nebo třída funguje podle očekávání.
 * - Jsou implementovány pomocí testovacích frameworků jako JUnit.
 *
 * **Význam unit testů**:
 * - **Zajištění správnosti kódu**: Zaručují, že jednotlivé části kódu vykonávají to, co mají.
 * - **Pomáhají při refaktorování**: Když měníte kód, unit testy vám pomohou ověřit, že změny neporušily existující funkcionalitu.
 * - **Udržitelnost kódu**: Poskytují zpětnou vazbu o tom, jaké části kódu nefungují správně.
 *
 * **Postup pro psaní unit testů**:
 * 1. Zvolte metodu nebo třídu, kterou chcete otestovat.
 * 2. Napište testy pro různé scénáře (např. normální vstupy, hraniční podmínky).
 * 3. Spusťte testy a ověřte, že všechny testy projdou.
 *
 * JUnit je běžně používaný framework pro psaní unit testů v Javě.
 *
 * Tento příklad ukazuje, jak napsat základní unit testy pro metody v třídě Kalkulacka.
 */


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
// Třída Kalkulacka obsahující metody pro základní matematické operace
class Kalkulack {
    // Metoda pro sečítání dvou čísel
    public int secti(int a, int b) {
        return a + b;
    }

    // Metoda pro odečítání dvou čísel
    public int odecti(int a, int b) {
        return a - b;
    }

    // Metoda pro násobení dvou čísel
    public int vynasob(int a, int b) {
        return a * b;
    }

    // Metoda pro dělení dvou čísel
    public int vydel(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Nelze dělit nulou");
        }
        return a / b;
    }
}

// Testovací třída pro Kalkulacka
class KalkulackaTest {

    // Testování metody secti
    @Test
    public void testSecti() {
        Kalkulack k = new Kalkulack();
        // Očekáváme, že 2 + 3 = 5
        assertEquals(5, k.secti(2, 3));
    }

    // Testování metody odecti
    @Test
    public void testOdecti() {
        Kalkulack k = new Kalkulack();
        // Očekáváme, že 5 - 3 = 2
        assertEquals(2, k.odecti(5, 3));
    }

    // Testování metody vynasob
    @Test
    public void testVynasob() {
        Kalkulack k = new Kalkulack();
        // Očekáváme, že 2 * 3 = 6
        assertEquals(6, k.vynasob(2, 3));
    }

    // Testování metody vydel pro dělení nulou
    @Test
    public void testVydel() {
        Kalkulack k = new Kalkulack();
        // Očekáváme, že dělení nulou vyvolá ArithmeticException 
        assertThrows(ArithmeticException.class, () -> k.vydel(10, 0));
    }
}
