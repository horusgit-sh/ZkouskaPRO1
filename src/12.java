/*
 * Práce s časem v Javě zahrnuje práci s různými třídami pro práci s daty a časem.
 * Java 8 zavedla nový API pro práci s časem a daty v balíčku **java.time**.
 * Základní třídy pro práci s časem:
 * - **LocalDate**: představuje datum bez času.
 * - **LocalTime**: představuje čas bez data.
 * - **LocalDateTime**: představuje datum a čas.
 * - **Instant**: představuje okamžik v čase (v UTC).
 * - **Duration** a **Period**: pro výpočty mezi časovými okamžiky.
 *
 * Pro převod mezi datem/časem a řetězcem se používají metody formátování.
 */

// Třída pro práci s časem
import java.time.*;
import java.time.format.DateTimeFormatter;

class PraceSCasem {

    // Získání aktuálního data a času
    public LocalDateTime ziskejAktualniCas() {
        return LocalDateTime.now();  // Získá aktuální datum a čas
    }

    // Převod LocalDateTime na String
    public String prevodNaString(LocalDateTime cas) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return cas.format(formatter);  // Převede LocalDateTime na řetězec
    }

    // Převod String na LocalDateTime
    public LocalDateTime prevodZeStringu(String casString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return LocalDateTime.parse(casString, formatter);  // Převede řetězec na LocalDateTime
    }

    // Získání aktuálního data
    public LocalDate ziskejAktualniDatum() {
        return LocalDate.now();  // Získá aktuální datum bez času
    }

    // Převod LocalDate na String
    public String prevodNaString(LocalDate datum) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return datum.format(formatter);  // Převede LocalDate na řetězec
    }

    // Převod String na LocalDate
    public LocalDate prevodZeStringuDatum(String datumString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(datumString, formatter);  // Převede řetězec na LocalDate
    }

    // Výpočet rozdílu mezi dvěma LocalDateTime
    public Duration vypocetRozdilu(LocalDateTime start, LocalDateTime konec) {
        return Duration.between(start, konec);  // Vrací rozdíl mezi dvěma časy
    }

    // Výpočet rozdílu mezi dvěma LocalDate
    public Period vypocetRozdiluDatum(LocalDate start, LocalDate konec) {
        return Period.between(start, konec);  // Vrací rozdíl mezi dvěma daty
    }
}

class Main12 {
    public static void main(String[] args) {
        PraceSCasem cas = new PraceSCasem();

        // Získání aktuálního data a času
        LocalDateTime aktualniCas = cas.ziskejAktualniCas();
        System.out.println("Aktuální datum a čas: " + aktualniCas);

        // Převod LocalDateTime na String
        String casString = cas.prevodNaString(aktualniCas);
        System.out.println("Datum a čas ve formátu String: " + casString);

        // Převod String na LocalDateTime
        LocalDateTime novyCas = cas.prevodZeStringu(casString);
        System.out.println("Převedený čas: " + novyCas);

        // Získání aktuálního data
        LocalDate aktualniDatum = cas.ziskejAktualniDatum();
        System.out.println("Aktuální datum: " + aktualniDatum);

        // Převod LocalDate na String
        String datumString = cas.prevodNaString(aktualniDatum);
        System.out.println("Datum ve formátu String: " + datumString);

        // Převod String na LocalDate
        LocalDate novyDatum = cas.prevodZeStringuDatum(datumString);
        System.out.println("Převedené datum: " + novyDatum);

        // Výpočet rozdílu mezi dvěma časy
        Duration rozdilCas = cas.vypocetRozdilu(aktualniCas, LocalDateTime.now().plusHours(2));
        System.out.println("Rozdíl v čase: " + rozdilCas.toHours() + " hodin");

        // Výpočet rozdílu mezi dvěma daty
        Period rozdilDatum = cas.vypocetRozdiluDatum(aktualniDatum, LocalDate.now().plusDays(10));
        System.out.println("Rozdíl v datech: " + rozdilDatum.getDays() + " dní");
    }
}
