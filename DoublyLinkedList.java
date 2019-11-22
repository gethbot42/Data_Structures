package datastructs;

import java.util.NoSuchElementException;

/**
 * A simple linked list with functionality to add and remove elements.  The list
 * can be printed in its standard order or reverse order and you can access any
 * element in the list.
 *
 * @author Todd A. Qualiano
 * @assignment Program 2
 * @description A doubly linked list with several add/remove/print methods
 * @param <E> the type of elements in the list
 */
public class DoublyLinkedList<E> {

    private ListNode<E> first, last;
    int numberOfNodes = 0;

    /**
     * An inner node class.
     *
     * @param <E> Type of elements in the node
     */
    private class ListNode<E> {

        private E value;
        private ListNode<E> next, prev;
        
        private ListNode(){
            this(null, null, null);
        }
        
        private ListNode(E value){
            this(value, null, null);
        }

        private ListNode(E value, ListNode<E> next, ListNode<E> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    /**
     * Adds a new node with the parameter object to the end of the list
     *
     * @param e the value stored in the new node we add
     * @return true if successful
     */
    public boolean add(E e) {
        ListNode<E> newNode;
        if (numberOfNodes == 0) {
            newNode = new ListNode<>(e, null, null);
            this.first = newNode;
            this.last = newNode;
        } else {
            newNode = new ListNode<>(e, null, this.last);
            this.last.next = newNode;
            last = newNode;
        }
        numberOfNodes++;
        return true;
    }

    /**
     * Adds a new node to be placed at the specified index.
     *
     * @param index the intended index of the element we add.
     * @param e the value we add to the list
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, E e) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException();
        } else if (numberOfNodes == 0) {
            this.add(e);
        } else {
            ListNode<E> newNode = new ListNode<>(e, null, null);
            ListNode<E> curr, prev;
            prev = curr = first;
            int counter = 0;
            while (counter < index) {
                prev = curr;
                curr = curr.next;
                counter++;
            }
            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = curr;
            curr.prev = newNode;
            numberOfNodes++;
        }
    }

    /**
     * Adds and element to the front of the list
     *
     * @param e the element we are adding
     */
    public void addFirst(E e) {
        if (numberOfNodes == 0) {
            this.add(e);
        } else {
            ListNode<E> newNode = new ListNode<>(e, this.first, null);
            this.first.prev = newNode;
            this.first = newNode;
            numberOfNodes++;
        }//end else

    }//end method

    public void printForward() {
        ListNode<E> curr = this.first;
        while (curr != null) {
            System.out.println(curr.value.toString());
            curr = curr.next;
        } //end while
    }//end method

    public void printReverse() {
        ListNode<E> curr = this.last;
        while (curr != null) {
            System.out.println(curr.value.toString());
            curr = curr.prev;
        }//end while
    }//end method

    /**
     * Gets the value from the specified index
     * @param index specifying the item in the list 
     * @return value at index
     */
    public E get(int index) {
    	if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } 
    	if(index == 0) {
    		return first.value;
    	}
        ListNode<E> curr = first;
        int count = 0;
        while (count < index) {
            curr = curr.next;
            count++;
        }
        return curr.value;
    }
    
    
    /**
     * Removes the first element of the list and returns it.
     *
     * @return the element we remove
     * @throws NoSuchElementException - if this list is empty
     */
    public E remove() throws NoSuchElementException {
        if (this.size() == 0) {
            throw new NoSuchElementException("empty list");
        }
        E returnValue = first.value;
        this.first = first.next;
        this.first.prev = null;
        this.numberOfNodes--;
        return returnValue;
    }//end method

    /**
     * Removes an element at the given index.
     * @param index the index of the element we remove
     * @return the value of the element we remove
     * @throws IndexOutOfBoundsException - if the index is out of range
     */
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else {
            E returnValue;
            ListNode<E> curr, behindCurr;
            behindCurr = curr = first;
            int count = 0;
            while (count < index) {
                behindCurr = curr;
                curr = curr.next;
                count++;
            }//end while
            returnValue = curr.value;
            if(count == 0) {//remove first element
            	return this.removeFirst();
            }else if(curr.next == null) {
            	return this.removeLast();
            } 
            curr.next.prev = behindCurr;
            behindCurr.next = curr.next;
            this.numberOfNodes--;

            return returnValue;
        }
    }

    /**
     * Removes the first element in the list and returns the value.
     * @return the value we remove
     * @throws NoSuchElementException - if this list is empty 
     */
    public E removeFirst() throws NoSuchElementException{
        if (this.size() == 0) {
            throw new NoSuchElementException("empty list");
        }
        E returnValue = first.value;
        this.first = first.next;
        this.first.prev = null;
        this.numberOfNodes--;
        return returnValue;
    }//end method
    
    /**
     * Removes the last element in the list and returns the value
     * @return the element we remove
     * @throws NoSuchElementException - if this is empty
     */
    public E removeLast() throws NoSuchElementException{
        if (this.size() == 0){
            throw new NoSuchElementException("empty list");
        }
        E returnValue = last.value;
        this.last = last.prev;
        this.last.next = null;
        this.numberOfNodes--;
        return returnValue;
    }

    public int size() {
        return this.numberOfNodes;
    }
    
    public static void main(String[] args) {
    	DoublyLinkedList<String> list = new DoublyLinkedList<>();
    	list.add("first");
    	list.add("second");
    	list.add("third");
    	list.remove(0);
    }
}
