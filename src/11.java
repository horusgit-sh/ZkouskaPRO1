/*
 * Práce s textem v Javě zahrnuje použití různých tříd pro manipulaci s řetězci.
 * Základní třídy pro práci s textem:
 * - **String**: pro neproměnné řetězce.
 * - **StringBuilder** a **StringBuffer**: pro mutovatelné řetězce.
 * - **Scanner**: pro čtení textu.
 * - **Pattern** a **Matcher**: pro regulární výrazy.
 *
 * **Operace s textem**:
 * - Porovnání, vyhledávání, nahrazení, dělení textu.
 * - **StringBuilder** je efektivní pro časté změny textu.
 * - **Parsování** zahrnuje převod textu na jiné datové typy.
 */

// Třída pro práci s textem
class PraceSTextem {

    // Parsování textu na číslo
    public int parseCislo(String text) {
        return Integer.parseInt(text);  // Parsuje řetězec na celé číslo
    }

    // Nahrazení podřetězce v textu
    public String nahrazeniPodretezce(String text, String stary, String novy) {
        return text.replace(stary, novy);  // Nahrazuje podřetězec
    }

    // Kontrola, zda text obsahuje podřetězec
    public boolean obsahujePodretezec(String text, String podretezec) {
        return text.contains(podretezec);  // Vrací true, pokud text obsahuje podřetězec
    }

    // Dělení textu na slova
    public String[] deleniNaSlova(String text) {
        return text.split(" ");  // Rozdělení na slova
    }

    // Kontrola, zda text začíná na určitý podřetězec
    public boolean zacinaNa(String text, String sekvence) {
        return text.startsWith(sekvence);  // Vrací true, pokud text začíná na sekvenci
    }

    // Kontrola, zda text končí na určitý podřetězec
    public boolean konciNa(String text, String sekvence) {
        return text.endsWith(sekvence);  // Vrací true, pokud text končí na sekvenci
    }

    // Převod textu na velká písmena
    public String naVelkaPismena(String text) {
        return text.toUpperCase();  // Převod na velká písmena
    }

    // Převod textu na malá písmena
    public String naMalaPismena(String text) {
        return text.toLowerCase();  // Převod na malá písmena
    }

    // Odstranění mezer z obou stran textu
    public String odstraneniMezer(String text) {
        return text.trim();  // Odstranění mezer
    }
}

class Q11 {
    public static void main(String[] args) {
        PraceSTextem prace = new PraceSTextem();

        // Test metod
        System.out.println(prace.parseCislo("123"));  // Výstup: 123
        System.out.println(prace.nahrazeniPodretezce("Jablko je červené.", "červené", "zelené"));  // Výstup: Jablko je zelené.
        System.out.println(prace.obsahujePodretezec("Jablko je červené.", "červené"));  // Výstup: true
        for (String slovo : prace.deleniNaSlova("Toto je text.")) {
            System.out.println(slovo);  // Výstup: Toto, je, text.
        }
        System.out.println(prace.zacinaNa("Jablko je červené.", "Jablko"));  // Výstup: true
        System.out.println(prace.konciNa("Jablko je červené.", "červené."));  // Výstup: true
        System.out.println(prace.naVelkaPismena("jablko"));  // Výstup: JABLK0
        System.out.println(prace.naMalaPismena("JABLKO"));  // Výstup: jablko
        System.out.println(prace.odstraneniMezer("  text s mezerami  "));  // Výstup: text s mezerami
    }
}
