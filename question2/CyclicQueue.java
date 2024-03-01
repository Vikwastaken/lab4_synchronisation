import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.NumberQueue;

public class CyclicQueue implements NumberQueue {
    private int[] queue;
    int head, tail, count, capacity;

    public CyclicQueue(int capacity) {this.capacity = capacity;this.queue = new int[capacity];this.head = 0;this.tail = 0;this.count = 0;
    }

    @Override
    public void enqueue(int number) {if (count >= capacity) {throw new IndexOutOfBoundsException("Queue is full");}
        queue[tail] = number;tail = (tail + 1) % capacity;count++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        int number = queue[head];head = (head + 1) % capacity;count--;return number;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
    

}
