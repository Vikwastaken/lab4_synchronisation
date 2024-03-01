public class Belt extends CyclicQueue {

    public Belt(int capacity) {
        super(capacity);
    }

    @Override
    public synchronized void enqueue(int number)  {
        while (isFull()) {
            try{wait();}
            catch (InterruptedException e) {
              Thread.currentThread().interrupt();
              return;
            }
        }
        super.enqueue(number);
        notifyAll();
    }

    private boolean isFull() {return capacity==count;   }

    @Override
    public synchronized int dequeue() {
        while (isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return 0;
            }
        }
        int number = super.dequeue();notifyAll();return number;
    }
}
