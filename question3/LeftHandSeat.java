import java.util.concurrent.locks.ReentrantLock;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.Seat;

public class LeftHandSeat implements Seat {
  ReentrantLock LeftFork;ReentrantLock RightFork;

  @Override
  public void askFork1() {RightFork.lock();
  }

  @Override
  public void askFork2() {LeftFork.lock();}

  @Override
  public void assignForks(ReentrantLock reentrantLock, ReentrantLock reentrantLock1) {LeftFork=reentrantLock;RightFork=reentrantLock1;

  }
}
