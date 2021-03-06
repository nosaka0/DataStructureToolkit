package LinkedLists;

import java.util.NoSuchElementException;

public class LinkedQueue<E> {

	private Node first;
	private Node last;
	private int size;

	LinkedQueue(){
		first = null;
		last = null;
		size = 0;
	}

	public boolean isEmpty(){
		return first == null;
	}

	public int size(){
		return size;
	}

	public E getFirst(){
		return first.element;
	}

	public void enqueue(E element){
		Node prev = last;
		last = new Node();
		last.element = element;

		if(isEmpty()){
			first.element = element;
		} else {
			prev.next = last;
		}

		last.element = element;
		size++;
	}

	public E dequeue(){
		if(isEmpty()) throw new NoSuchElementException("Queue is empty");

		E element = first.element;
		first = first.next;

		if(isEmpty()) last = null;

		size--;
		return element;
	}

	//small helper class for allowing for more generic use of the LinkedLists.LinkedQueue class
	private class Node{
		private E element;
		private Node next;
	}
}