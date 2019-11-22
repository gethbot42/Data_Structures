
package mystack;

import java.util.ArrayList;
/**
 * A simple implementation of the classic filo stack.  It is backed by a linked list.
 * @author Todd A. Qualiano
 *
 */
public class MyStack<E> {
    private final LinkedList<E> aList;
    
    public MyStack(){
        aList = new LinkedList<>();
    }
    
    public boolean isEmpty(){
        return aList.isEmpty();
    }
    
    public E peek(){
        return aList.get(aList.size()-1);
    }
    
    public E pop(){
        return aList.remove(aList.size()-1);
    }
    
    public E push(E e){
        if(aList.add(e))
            return e;
        else
            return null;
    }
    
    public void removeAll(){
        if(this.isEmpty()){
            return;
        }
        else{
            this.pop();
            this.removeAll();
        }
    }
    
    
}
