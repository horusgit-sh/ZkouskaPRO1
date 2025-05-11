/*
 * Asociace je vztah mezi dvěma třídami, např. "Student navštěvuje školu".
 * V UML se asociace značí spojnicí mezi dvěma třídami, často s uvedením násobnosti (např. 1..*, 1..1).
 * V Javě se tento vztah realizuje tak, že třída obsahuje atribut, který je instancí jiné třídy.
 * Pokud je vztah 1:1, použijeme jednoduchý objekt. Pokud je vztah 1:N, použijeme kolekci (např. List).
 * Asociace může být jednostranná (jen jedna třída ví o druhé) nebo obousměrná (obě třídy se znají navzájem).
 */

// Jednoduchá asociace 1:1 – student je přiřazen ke škole

class Skola {
    private String nazev;

    public Skola(String nazev) {
        this.nazev = nazev;
    }

    public String getNazev() {
        return nazev;
    }
}

class Student {
    private String jmeno;
    private Skola skola;  // Asociace – každý student je spojen s jednou školou

    public Student(String jmeno, Skola skola) {
        this.jmeno = jmeno;
        this.skola = skola;
    }

    public void vypisInfo() {
        System.out.println("Student: " + jmeno + ", Škola: " + skola.getNazev());
    }
}

// Příklad použití v hlavní třídě

class M {
    public static void main(String[] args) {
        Skola gymnazium = new Skola("Gymnázium Jana Nerudy");
        Student student = new Student("Petr Novak", gymnazium);

        student.vypisInfo(); // Výstup: Student: Petr Novak, Škola: Gymnázium Jana Nerudy
    }
}
