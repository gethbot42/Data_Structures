package datastructs;

/**
 * This class is a simple implementation of an ArrayList. The list is backed by a 
 * java array.
 *
 * @author Todd Qualiano
 * @param <E> The type of elements in the ArrayList
 */
public class MyArrayList<E>{

    private static final int INIT_CAPACITY = 10;

    private E[] data; //the backing array
    private int size; //how many elements are in the list
    private int capacity; //max amount of elements a list can hold before resize

    public MyArrayList() {
        this(INIT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        data = (E[]) new Object[capacity];
        this.capacity = capacity;
    }

    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException();
        } else if (size == capacity) {
            this.reallocate();
        }
        data[size] = e;
        size++;

        return true;
    }

    /**
     * Adds a new element to the list at the specified index.
     * @param index The index where the new element will be placed
     * @param e The data to add.
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        if (e == null) {
            throw new NullPointerException();
        }

        if (size == capacity) {
            reallocate();
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = e;
        size++;
    }

    public void clear() {
        this.data = (E[]) new Object[this.capacity];
        this.size = 0;
    } 

    public void print() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println("Index: " + i + " Element: " + this.get(i));
        }
    }
    
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return data[index];
    } // End get(int index) method

    public int indexOf(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }

        for (int i = 0; i < size; i++) {
            if (data[i].equals((E) o)) {
                return i;
            }
        }

        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes the element at the specified index.
     * @param index 
     * @return The value of the element removed
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        E temp = data[index];

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        size--;
        return temp;
    }

    public boolean remove(Object o) {
        int indexOfO = indexOf(o);

        if (indexOfO == -1) {
            return false;
        }

        return true;
    }

    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        if (e == null) {
            throw new NullPointerException();
        }
        E temp = data[index];
        data[index] = e;
        return temp;
    }

    public int size() {
        return size;
    }

    /**
     * If the size of the list is going to exceed the capacity, we must make
     * a new backing array with a higher capacity.
     */
    private void reallocate() {
    	System.out.println("creating higher capacity list");
        E[] dataNew = (E[]) new Object[this.capacity + 10];
        for(int i = 0; i < data.length; i++) {
        	dataNew[i] = data[i];
        }
        data = dataNew;
    } 

}
