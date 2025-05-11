/*
 * Vícevláknové aplikace v Javě umožňují paralelní zpracování více úloh najednou. Vlákna (threads) jsou samostatné běžící
 * jednotky programu, které mohou běžet současně, což je ideální pro aplikace, které vyžadují vysoký výkon nebo reagují
 * na různé události současně.
 *
 * Principy vícevláknového programování:
 * - **Vlákno** je nejmenší jednotka vykonávajícího programu. V Javě je vlákno objekt třídy `Thread` nebo může implementovat
 *   rozhraní `Runnable`.
 * - **Synchronizace** je technika, která zajišťuje, že k určitému bloku kódu nebo sdílenému prostředku má přístup vždy jen
 *   jedno vlákno, čímž se zamezí vzniku závodních podmínek (race conditions).
 * - **Nástroje** pro práci s více vlákny v Javě zahrnují třídy a rozhraní, jako jsou `Thread`, `Runnable`, `ExecutorService`,
 *   a synchronizační nástroje jako `synchronized`, `ReentrantLock` a `CountDownLatch`.
 *
 * Příklad ukazuje, jak spustit více vláken a synchronizovat přístup k sdílenému prostředku.
 */

// Třída pro demonstraci vícevláknového programování a synchronizace

class SynchronizedExample {

    // Sdílený prostředek, který bude upravovat více vláken
    private int counter = 0;

    // Synchronizovaná metoda pro zvýšení hodnoty counteru
    public synchronized void increment() {
        counter++;
    }

    // Metoda pro získání aktuální hodnoty counteru
    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {
        // Vytvoření instance třídy pro práci s vlákny
        SynchronizedExample example = new SynchronizedExample();

        // Vytvoření dvou vláken, která budou současně zvyšovat counter
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    example.increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    example.increment();
                }
            }
        });

        // Spuštění vláken
        thread1.start();
        thread2.start();

        // Čekáme na dokončení obou vláken
        thread1.join();
        thread2.join();

        // Výpis výsledku
        System.out.println("Counter: " + example.getCounter()); // Očekáváme 2000, protože obě vlákna přičítala k counteru
    }
}
