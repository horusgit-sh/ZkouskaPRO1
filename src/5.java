/*
 * Výjimky slouží ke zpracování chybových stavů za běhu programu.
 * Existují dva hlavní typy:
 *   1) Kontrolované výjimky (checked) – musí být ošetřeny (např. IOException, SQLException).
 *   2) Nekontrolované výjimky (runtime) – dědí z RuntimeException, např. NullPointerException.
 *
 * Výjimky lze:
 *  - Zachytit pomocí try-catch.
 *  - Propagovat výš pomocí klíčového slova `throws`.
 *  - Vyvolat ručně pomocí `throw`.
 */

// Příklad kontrolované výjimky: čtení dat

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class SouborovyNacitac {
    public void nactiSoubor(String cesta) throws IOException {
        BufferedReader ctecka = new BufferedReader(new FileReader(cesta));
        String radek;
        while ((radek = ctecka.readLine()) != null) {
            System.out.println(radek);
        }
        ctecka.close();
    }
}

// Příklad nekontrolované výjimky: dělení nulou

class Kalkulacka {
    public int vydel(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Nelze dělit nulou!");
        }
        return a / b;
    }
}

// Hlavní třída s ošetřením výjimek

class Spustitel {
    public static void main(String[] args) {
        Kalkulacka pocitac = new Kalkulacka();

        try {
            int vysledek = pocitac.vydel(10, 0); // ArithmeticException
            System.out.println("Výsledek: " + vysledek);
        } catch (ArithmeticException e) {
            System.out.println("Chyba: " + e.getMessage());
        }

        SouborovyNacitac nacitac = new SouborovyNacitac();

        try {
            nacitac.nactiSoubor("data.txt"); // může vyvolat IOException
        } catch (IOException e) {
            System.out.println("Chyba při čtení souboru: " + e.getMessage());
        }

        System.out.println("Program pokračuje dál...");
    }
}
