/*
 * Principy tvorby grafického uživatelského rozhraní (GUI) v Javě zahrnují několik klíčových konceptů:
 *
 * 1. **Událostmi řízené programování (Event-Driven Programming)**:
 *    - V tomto modelu program reaguje na události, které jsou generovány uživatelem (např. kliknutí na tlačítko, pohyb myši).
 *    - Události jsou zpracovávány pomocí posluchačů (listeners), kteří čekají na specifické události a reagují na ně.
 *
 * 2. **Model-View-Controller (MVC)**:
 *    - Tento designový vzor rozděluje aplikaci na tři hlavní komponenty:
 *      - **Model**: Spravuje data aplikace a logiku.
 *      - **View**: Zobrazuje data (GUI komponenty).
 *      - **Controller**: Zpracovává události a interakci mezi modelem a pohledem.
 *    - MVC zajišťuje oddělení zodpovědnosti, což zlepšuje udržovatelnost a flexibilitu.
 *
 * 3. **Komponenty**:
 *    - **GUI komponenty**: Základní stavební kameny grafického rozhraní (např. tlačítka, textová pole, labely).
 *    - Komponenty mohou být propojeny s modelem, aby data byla dynamicky aktualizována na základě interakce s uživatelem.
 *
 * 4. **Layouty**:
 *    - Layouty určují, jak budou komponenty umístěny na obrazovce.
 *    - V Javě se používají různé typy layoutů (např. BorderLayout, GridLayout, FlowLayout) pro efektivní rozmístění komponent.
 */

// Příklad GUI aplikace v Javě s využitím událostmi řízeného programování a layoutu

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SimpleGUI {

    // Hlavní metoda pro spuštění aplikace
    public static void main(String[] args) {
        // Vytvoření okna (frame)
        JFrame frame = new JFrame("Ukázka GUI");
        frame.setSize(400, 300);  // Nastavení velikosti okna
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Vytvoření layoutu (layout manager)
        frame.setLayout(new BorderLayout());

        // Vytvoření komponent
        JLabel label = new JLabel("Klikněte na tlačítko!", SwingConstants.CENTER);
        JButton button = new JButton("Klikni");

        // Přidání komponent do okna s použitím layoutu
        frame.add(label, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        // Akce při kliknutí na tlačítko (událost)
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Tlačítko bylo kliknuto!"); // Změní text labelu
            }
        });

        // Zobrazení okna
        frame.setVisible(true);
    }
}
