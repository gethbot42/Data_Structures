package datastructs;

import java.util.NoSuchElementException;

/**
 * A single linked list. Simple implementation of the classic structure.
 * 
 * @author Todd A. Qualiano
 */
public class SinglyLinkedList<E> { // Singularly Linked List with a first reference only.

	private ListNode<E> first;
	private int numOfListNodes = 0;

	private class ListNode<E> {
		private E value;
		private ListNode<E> next;

		public ListNode(E initObj, ListNode<E> initNext) {
			value = initObj;
			next = initNext;
		}

		public E getValue() {
			return value;
		}

	}

	/**
	 * Adds an element to the end of the list.
	 * @param e The value of the element to add.
	 */
	public void add(E e) {
		ListNode<E> newNode = new ListNode<>(e, null);
		ListNode<E> current;

		if (first == null) {
			first = newNode;

		} else {
			current = first;

			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;

		}
		numOfListNodes++;
	}

	/**
	 * Adds an element to the specified index of the list.
	 * @param i the index where you want the new element to be
	 * @param obj the value of the object you're adding
	 */
	public void add(int i, E obj) {
		if (i < 0 || i > this.size()) {
			throw new IndexOutOfBoundsException("index out of bounds");
		}
		if (i == 0) {
			this.addFirst(obj);
		} else if (i == size()) {
			this.add(obj); // same thing as add last
		} else {
			ListNode<E> newNode = new ListNode<E>(obj, null);
			ListNode<E> prev, curr; // previous node, current node
			prev = curr = first;
			int count = 0;
			while (count < i) {

				prev = curr;
				curr = curr.next;
				count++;
			}
			newNode.next = curr;
			prev.next = newNode;
			numOfListNodes++;
		}
	}

	public void addFirst(E obj) {
		ListNode<E> newNode = new ListNode<E>(obj, null);
		if (first == null) {// list is empty
			first = newNode;
		} else {// list is not empty
			newNode.next = first;
			first = newNode;
		} // end else
	}// end method

	public void addRecursive(E obj) {
		ListNode<E> newNode = new ListNode<>(obj, null);
		if (first == null)
			first = newNode;
		else
			addRecHelp(first, newNode);
	}

	private void addRecHelp(ListNode<E> curr, ListNode<E> newNode) {
		if (curr.next != null)
			addRecHelp(curr.next, newNode);
		else
			curr.next = newNode;
	}

	public E remove() throws NoSuchElementException {
		E returnValue = null;
		if (this.size() == 0) {
			throw new NoSuchElementException("List is empty");
		} else {
			returnValue = this.first.getValue();
			first = first.next;
		} // end else
		numOfListNodes--;
		return returnValue;
	}// end method

	public E remove(int index) throws IndexOutOfBoundsException {
		E returnValue = null;
		if (index == 0) {
			this.remove();
		} else if (index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		} else {
			ListNode<E> curr, prev;
			prev = curr = first;
			int count = 0;
			while (count < index) {
				prev = curr;
				curr = curr.next;
				count++;
			}
			prev.next = curr.next;
			numOfListNodes--;
		} // end else

		return returnValue;

	}// end method

	public void print() {
		System.out.println(this.toString());
	}

	public int size() {
		return numOfListNodes;
	}

	public void printForwardUsingRecurison() {
		if (this.size() == 0) {
			System.out.println();
		} else {
			E temp = this.remove();
			System.out.println(temp.toString());
			this.printForwardUsingRecurison();
		} // end else

	}// end method

	public void printInReverse() {
		ListNode<E> curr = first;
		ListNode<E>[] holder = new ListNode[this.size()];
		int counter = 0;
		while (curr != null) {
			holder[counter] = curr;
			curr = curr.next;
			counter++;
		}
		for (int i = this.size() - 1; i >= 0; i--) {
			System.out.println(holder[i].getValue().toString());
		} // end for
	}// end method

	public void printInReverseClass() {
		if (first == null) {
			System.out.println("Empty");
		} else {
			printInReverseClassHelper(first);
		}
	}

	private void printInReverseClassHelper(ListNode<E> curr) {
		if (curr.next != null) {
			printInReverseClassHelper(curr.next);
		} else {
			System.out.println(curr.getValue().toString());
		}

	}

	public String toString() {
		String result = "";
		ListNode<E> current = first;

		while (current != null) {
			result += current.getValue().toString() + "\n";
			current = current.next;
		}

		return result;
	}

}
