package datastructs;

/**
 * A priority queue.  Backed by a Java array of MyQueues.  For this simple example, we require classes
 * that will be in our queue to 'extend' the Priority interface.
 * @author ta03q
 * @param <E> - the elements in the QueuePriority
 */
public class QueuePriority <E extends Priority>{ //The elements E must extend priority
    MyQueue<E>[] queue;
    int priorityMax;
    public QueuePriority(int priorityMax){
        this.priorityMax = priorityMax;
        queue = new MyQueue[this.priorityMax];
        for(int i = 0; i < this.priorityMax; i++){
            queue[i] = new MyQueue<>();
        }
    }
    
    public void enqueue(E e){
        queue[e.getPriority() - 1].enqueue(e);
    }
    
    public E dequeue(){
        E temp = null;
        boolean jumpOut = true;
        int start = 0;
        while(jumpOut && start < priorityMax){
            if(!queue[start].isEmpty()){
                temp = queue[start].dequeue();
                jumpOut = false;
            }
            start++;
        }
        if(temp == null)
            System.out.println("QueuePriority is empty");
        return temp;
    }
}
