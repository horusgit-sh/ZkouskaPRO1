/*
 * Formáty pro předávání dat, jako jsou XML a JSON, jsou běžně používané pro výměnu informací mezi aplikacemi.
 * Tyto formáty umožňují strukturované předávání dat, která mohou být snadno přenášena mezi různými platformami.
 *
 * **XML (Extensible Markup Language)**: Formát pro strukturované textové reprezentace dat. Používá značky pro popis struktury.
 * **JSON (JavaScript Object Notation)**: Lehčí a jednodušší formát než XML pro přenos dat, běžně používaný v moderních webových aplikacích.
 *
 * **Parsery**:
 * - **XML Parsery**: Knihovny jako `DOM`, `SAX`, nebo `StAX` slouží k parsování XML souborů.
 * - **JSON Parsery**: Knihovny jako `Jackson`, `Gson`, nebo `org.json` umožňují čtení a zápis JSON dat.
 *
 * **Mapování dat na třídy**: Tento proces umožňuje převod dat z formátu XML nebo JSON do objektů v jazyce Java.
 * - **XML**: K tomu se používají knihovny jako `JAXB` (Java Architecture for XML Binding).
 * - **JSON**: K tomu se používají knihovny jako `Jackson` nebo `Gson`, které umožňují automatické mapování mezi JSON a Java objekty.
 *
 * Příklad ukazuje, jak použít knihovnu `Gson` pro práci s JSON formátem a jak použít `JAXB` pro práci s XML.
 */

// Knihovny pro práci s JSON a XML:
// - Gson (pro JSON): https://github.com/google/gson
// - JAXB (pro XML): https://javaee.github.io/jaxb-v2/

import com.google.gson.Gson;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

// Třída pro mapování JSON a XML dat

// Třída pro serializaci a deserializaci JSON a XML
class FormatyPredavaniDat {

    // Třída pro mapování objektu (JSON a XML)
    @XmlRootElement
    static class Osoba {
        private String jmeno;
        private int vek;

        // Getter a Setter pro JAXB a Gson
        public String getJmeno() {
            return jmeno;
        }

        @XmlElement
        public void setJmeno(String jmeno) {
            this.jmeno = jmeno;
        }

        public int getVek() {
            return vek;
        }

        @XmlElement
        public void setVek(int vek) {
            this.vek = vek;
        }

        @Override
        public String toString() {
            return "Osoba{" + "jmeno='" + jmeno + '\'' + ", vek=" + vek + '}';
        }
    }

    // Metoda pro serializaci objektu do JSON formátu pomocí Gson
    public String serializeToJson(Osoba osoba) {
        Gson gson = new Gson();
        return gson.toJson(osoba);  // Serializuje objekt do JSON
    }

    // Metoda pro deserializaci JSON formátu na objekt pomocí Gson
    public Osoba deserializeFromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Osoba.class);  // Deserializuje JSON na objekt
    }

    // Metoda pro serializaci objektu do XML formátu pomocí JAXB
    public void serializeToXml(Osoba osoba, String fileName) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Osoba.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(osoba, new File(fileName));  // Serializuje objekt do XML souboru
    }

    // Metoda pro deserializaci XML formátu na objekt pomocí JAXB
    public Osoba deserializeFromXml(String fileName) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Osoba.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Osoba) unmarshaller.unmarshal(new File(fileName));  // Deserializuje XML na objekt
    }

    public static void main(String[] args) throws Exception {
        FormatyPredavaniDat aplikace = new FormatyPredavaniDat();

        // Příklad práce s JSON
        Osoba osobaJson = new Osoba();
        osobaJson.setJmeno("Jan Novák");
        osobaJson.setVek(30);

        String json = aplikace.serializeToJson(osobaJson);  // Serializace do JSON
        System.out.println("JSON: " + json);

        Osoba deserializedOsobaJson = aplikace.deserializeFromJson(json);  // Deserializace z JSON
        System.out.println("Deserializovaná Osoba z JSON: " + deserializedOsobaJson);

        // Příklad práce s XML
        Osoba osobaXml = new Osoba();
        osobaXml.setJmeno("Petr Svoboda");
        osobaXml.setVek(25);

        aplikace.serializeToXml(osobaXml, "osoba.xml");  // Serializace do XML
        Osoba deserializedOsobaXml = aplikace.deserializeFromXml("osoba.xml");  // Deserializace z XML
        System.out.println("Deserializovaná Osoba z XML: " + deserializedOsobaXml);
    }
}
