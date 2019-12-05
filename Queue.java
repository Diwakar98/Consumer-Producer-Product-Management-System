public class Queue<V> implements QueueInterface<V>{
    private NodeBase<V>[] queue;
    private int capacity, currentSize, front, rear;
    public Queue(int capacity) {
         this.capacity=capacity;
         this.queue=new NodeBase[capacity];
         this.currentSize=0;
         this.front=0;
         this.rear=-1;
    }
    public int size() {
         return this.currentSize;
    }
    public boolean isEmpty() {
         return this.currentSize==0;
    }
    public boolean isFull() {
         return this.currentSize==this.capacity;
    }
    public void enqueue(Node<V> node) {
         if(isFull()){
              System.out.println("Queue if full");
         }
         else{
              this.rear++;
              this.front=0;
             this.queue[rear]=node;
             this.currentSize++;
         }
    }
    public NodeBase<V> dequeue() {
         if(isEmpty()){
              System.out.println("Queue is Empty");
              return null;
         }
         else{
             NodeBase<V> node=queue[rear];
             rear--;
             currentSize--;
             return node;
        }
    }
}
