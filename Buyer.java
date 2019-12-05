import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Buyer<V> extends BuyerBase<V> {
     public Buyer (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, int iteration) {
          this.lock=lock;
          this.full=full;
          this.empty=empty;
          this.catalog=catalog;
          this.setSleepTime(sleepTime);
          this.setIteration(iteration);
     }
     public void buy() throws InterruptedException {
          try {
               lock.lock();
               if(catalog.isEmpty()){
                    empty.await();
               }
               else{
                    NodeBase<V> n=catalog.dequeue();
                    System.out.print("Consumed "); // DO NOT REMOVE (For Automated Testing)
                    n.show();
                    full.signal();
               }
          }
          catch (Exception e) {
               e.printStackTrace();
          }
          finally {
               lock.unlock();
          }
     }
}
