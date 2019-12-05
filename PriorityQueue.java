
public class PriorityQueue<V> implements QueueInterface<V>{
    private NodeBase<V>[] queue;
    private int capacity, currentSize;
    public PriorityQueue(int capacity) {
         this.capacity=capacity;
         this.currentSize=0;
         queue=new NodeBase[this.capacity];
    }
    public void add(int priority,V data){
         Node<V> n=new Node<V>(priority,data);
         this.enqueue(n);
    }
    public NodeBase<V> removeMin(){
         return this.dequeue();
    }
    public int size() {
         return this.currentSize;
    }

    public boolean isEmpty() {
         return (this.currentSize==0);
    }
    public boolean isFull() {
         return (this.currentSize==this.capacity);
    }
    public void enqueue(Node<V> node) {
         if(isFull()){
              System.out.println("Queue if Full");
         }
         else{
             this.queue[currentSize]=node;
             this.currentSize++;
        }
    }
    public NodeBase<V> dequeue() {
         if(isEmpty()){
              return null;
         }
         else{
            int indexofminpriorityvalue=0;
            int priority=queue[0].getPriority();
            for(int i=0; i<currentSize; i++){
                 if(queue[i].getPriority()<priority){
                      indexofminpriorityvalue=i;
                      priority=queue[i].getPriority();
                 }
            }
            NodeBase<V> n=queue[indexofminpriorityvalue];
            for(int i=indexofminpriorityvalue; i<currentSize-1; i++){
                queue[i]=queue[i+1];
            }
            currentSize--;
            return n;
        }
    }
    public void display () {
         if (this.isEmpty()) {
              System.out.println("Queue is empty");
         }
         for(int i=0; i<currentSize; i++) {
              queue[i].show();
         }
    }
}
