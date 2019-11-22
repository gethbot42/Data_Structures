package datastructs;

import java.util.LinkedList;
/**
 * A simple implementation of a queue that is backed by a linked list.
 * @author Todd A. Qualiano
 * @param <E>
 */
public class MyQueue <E>{
    private LinkedList<E> list;
    
    public MyQueue(){
        list = new LinkedList<>();
    }
    
    //Adds an element to the end of the queue
    public void enqueue(E e){
        list.add(e);
    }
    
	//Removes from the front of the queue
    public E dequeue(){
        return list.remove();
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
}
