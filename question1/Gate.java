public class Gate implements Runnable {
    private final Counter counter;private final int guests;

    public Gate(Counter counter, int guests) {this.counter = counter;this.guests = guests;}

    @Override
    public void run() {
        for (int i = 0; i < guests; i++) {
            counter.addOne();
        }
    }
}
