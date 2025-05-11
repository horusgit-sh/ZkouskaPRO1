/*
 * Perzistentní ukládání dat v Javě zahrnuje uchovávání dat, která přetrvávají i po ukončení běhu aplikace.
 * K tomu se využívají různé techniky jako I/O proudy, serializace, a práce se soubory.
 *
 * **I/O proudy**: Vstupní a výstupní (I/O) proudy slouží k čtení a zápisu dat mezi programem a vnějšími zdroji, jako jsou soubory.
 * **Serializace**: Proces převodu objektu do formátu, který lze uložit do souboru nebo přenést přes síť.
 * **Textové soubory**: Práce s textovými soubory zahrnuje čtení a zápis textu pomocí různých I/O nástrojů.
 *
 * Tento příklad ukazuje použití I/O proudů pro čtení a zápis textového souboru a serializaci objektů.
 */

// Třída pro demonstraci perzistentního ukládání dat

import java.io.*;

// Třída pro serializaci
class Osoba1 implements Serializable {
    private String jmeno;
    private int vek;

    public Osoba1(String jmeno, int vek) {
        this.jmeno = jmeno;
        this.vek = vek;
    }

    @Override
    public String toString() {
        return "Osoba{" + "jmeno='" + jmeno + '\'' + ", vek=" + vek + '}';
    }
}

// Třída pro práci s I/O a serializací
class PerzistentniUkladani {

    // Zápis do textového souboru
    public void zapisDoSouboru(String soubor, String obsah) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(soubor))) {
            writer.write(obsah);  // Zápis textu do souboru
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Čtení z textového souboru
    public String cteniZeSouboru(String soubor) {
        StringBuilder obsah = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(soubor))) {
            String radek;
            while ((radek = reader.readLine()) != null) {
                obsah.append(radek).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obsah.toString();  // Vrátí obsah souboru jako text
    }

    // Serializace objektu do souboru
    public void serializujDoSouboru(String soubor, Osoba1 osoba) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(soubor))) {
            oos.writeObject(osoba);  // Serializace objektu
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserializace objektu ze souboru
    public Osoba1 deserializujZeSouboru(String soubor) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(soubor))) {
            return (Osoba1) ois.readObject();  // Deserializace objektu
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        PerzistentniUkladani aplikace = new PerzistentniUkladani();

        // Příklad zápisu a čtení textového souboru
        String souborText = "textovySoubor.txt";
        aplikace.zapisDoSouboru(souborText, "Toto je testovací text.");
        System.out.println(aplikace.cteniZeSouboru(souborText));

        // Příklad serializace a deserializace objektu
        Osoba1 osoba = new Osoba1("Jan Novák", 30);
        String souborObjekt = "osoba.ser";
        aplikace.serializujDoSouboru(souborObjekt, osoba);
        Osoba1 deserializovanaOsoba = aplikace.deserializujZeSouboru(souborObjekt);
        System.out.println(deserializovanaOsoba);  // Výstup: Osoba{jmeno='Jan Novák', vek=30}
    }
}
