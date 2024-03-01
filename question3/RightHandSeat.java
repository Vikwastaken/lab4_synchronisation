import java.util.concurrent.locks.ReentrantLock;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.Seat;
public class RightHandSeat implements Seat {
  ReentrantLock LeftFork;ReentrantLock RightFork;@Override
  public void askFork1() {LeftFork.lock();}@Override
  public void askFork2() {RightFork.lock();}@Override
  public void assignForks(ReentrantLock reentrantLock, ReentrantLock reentrantLock1) {
    LeftFork=reentrantLock;
    RightFork=reentrantLock1;
  }
}
