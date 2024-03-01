public class Zoo {
    public static void main(String[] args) {
        final int numberOfGates = 5;
        final int guestsPerGate = 100;
        Counter counter = new Counter();
        Thread[] gateThreads = new Thread[numberOfGates];
        for (int i = 0; i < numberOfGates; i++) {gateThreads[i] = new Thread(new Gate(counter, guestsPerGate));gateThreads[i].start();}
        for (int i = 0; i < numberOfGates; i++) {try {gateThreads[i].join();} catch (InterruptedException e) {e.printStackTrace();}}
        int expectedGuests = numberOfGates * guestsPerGate;
        System.out.println("Expected guests: " + expectedGuests);
        System.out.println("Actual counter state: " + counter.getCounter());
    }
}
