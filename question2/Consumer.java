import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.FactoryWorker;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.NumberQueue;

public class Consumer extends FactoryWorker {
  NumberQueue queue;
  public Consumer(int id, NumberQueue queue) {super("Consumer",id, queue);this.queue=queue;}

  @Override
  public void message(int number) {System.out.println("Consumer " + id + " picked: " + number + " from the belt.");}

  @Override
  public int action() {
    return queue.dequeue();
  }

  @Override
  public void run() {
    while(!Thread.currentThread().isInterrupted()){
      try{
        int number=action();
        message(number);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
}
