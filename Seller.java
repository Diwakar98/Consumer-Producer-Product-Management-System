import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Seller<V> extends SellerBase<V> {
	public Seller (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, Queue<V> inventory) {
		this.lock=lock;
		this.full=full;
		this.empty=empty;
		this.catalog=catalog;
		this.inventory=inventory;
		this.setSleepTime(sleepTime);
	}
	public void sell() throws InterruptedException {
		try {
			lock.lock();
			if(catalog.isFull()){
				full.await();
			}
			else{
				NodeBase<V> node=inventory.dequeue();
				catalog.enqueue((Node<V>)node);
				empty.signal();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
}
