import java.util.Random;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.FactoryWorker;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.NumberQueue;

public class Producer extends FactoryWorker {
  NumberQueue queue;

  public Producer(int id, NumberQueue queue) {super("Producer",id, queue);this.queue=queue;}

  @Override
  public void message(int number) {System.out.println("Producer " + id + " generated: " + number);}

  @Override
  public int action() {Random random = new Random();int number= random.nextInt(10000);queue.enqueue(number);return number;}

  @Override
  public void run() {while(!Thread.currentThread().isInterrupted()){try{int number=action();message(number);} catch (Exception e) {throw new RuntimeException(e);}
    }
  }
}
