
public class LinkedListADT<T> implements ListADT<T> {

	@SuppressWarnings("hiding")
	class Node<T>{
		Node<T> previous, next;
		T elem;
		
	}

	private Node<T> head, tail;
	private int size = 0;
	
	public LinkedListADT(){
		this.head = this.tail = null;
	}
	
	
	/**
	 * @param elems The elements with which to initialize this LinkedListADT.
	 * 
     * This constructor copies the elements of elems in the order provided, into 
     * this instance of LinkedListADT.	 
	 */
	public LinkedListADT(T[] elems){
		 if (elems != null) {
			 for (T elem : elems) {
				 add(elem);
			 }
		 }
		
	}
	
	
		
	
	public String toString(){
		if(this.head == null){
			return "[]";
		}
		
		else if(this.head.next == null){
			return "[" + this.head.elem + "]";
		}
		
		Node<T> temp = this.head;
		String str = "[";
		while(temp.next != null){
			str += temp.elem.toString() + ", ";
			temp = temp.next;
		}
		
		str += temp.elem.toString() + "]";
		return str;
	}
	
	
	/**
	 * @param elem: The element to add to the end of the list
	 */ 
	public void add(T elem){
		if(this.head == null){
			this.head = new Node<T>();
			this.head.elem = elem;
			this.tail = this.head;
		}
		
		else{
			this.tail.next = new Node<T>();
			this.tail.next.previous = this.tail;
			this.tail = this.tail.next;
			this.tail.elem = elem;
		}
		size++;
	}
	
	
	/**
	 * @param index: The index at which to insert the new element
	 * @param elem: The element to insert inot the list at position @index.
	 * 
	 * Inserts @elem at position @index in the list. Any element at position @index
	 * or later in the list prior to this method being invoked should be moved
	 * one index down (so the element at position @index prior to this method being invoked
	 * should end up at position @index+1 after this method terminates).
	 */
	public void add(int index, T elem){
		// TODO
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index out of range");
		}
		
		Node<T> newNode = new Node<>();
		newNode.elem = elem;
		
		if(index == 0) {
			newNode.next = head;
			
			if (head != null) {
				head.previous = newNode;
			}
			head = newNode;
			
			if (tail == null) tail = head;
			
		} else if (index == size) {
			
			add(elem);
			return;
			
		} else {
			
			Node <T> current = head;
			
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			newNode.previous = current.previous;
			newNode.next = current;
			current.previous.next = newNode;
			current.previous = newNode;
		}
		size++;
	}
	
	
	/**
	 * @param index: The index of the element to return
	 * @return T: The element located at @index to return
	 */
	public T get(int index){
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> current = head;
		
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.elem;
	}
	
	
	/**
	 * @param elem: The element we want to check for membership in the list.
	 * @return boolean: true if elem is in the list, and false otherwise
	 */ 
	public boolean contains(T elem){
		
		Node<T> current = head;
		
		while(current != null) {
			if(current.elem.equals(elem)) return true;
			current = current.next;
		}
		return false;
	}
	
	
	/**
	 * @param elem: The element we want to check for membership in the list.
	 * @return int: The index of the first occurrence of elem, or -1 if elem is not in the list.
	 */ 
	public int findFirstOccurrence(T elem){
		
		Node<T> current = head;
		
		int index = 0;
		
		while (current != null) {
			if (current.elem.equals(elem)) return index;
			current = current.next;
			index++;
		}
		return -1;
	}
	
	
	/**
	 * @param elem: The element we want to check for membership in the list.
	 * @return int: The index of the first occurrence of elem starting from fromIndex (inclusive), 
	 *				or -1 if elem is not in the list.
	 */ 
	public int findFirstOccurrenceSince(int fromIndex, T elem){
		// TODO
		if(fromIndex < 0 || fromIndex >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> current = head;
		int index = 0;
		
		while(index < fromIndex) {
			current = current.next;
			index++;
		}
		while(current != null) {
			if(current.elem.equals(elem)) return index;
			current = current.next;
			index++;
		}
		return -1;
	}
	
	
	/**
	 * @param elem: The element we want to check for membership in the list.
	 * @return int: The index of the last occurrence of elem, or -1 if elem is not in the list.
	 */ 
	public int findLastOccurrence(T elem){
		
		Node<T> current = tail;
		int index = size - 1;
		
		while(current != null) {
			if (current.elem.equals(elem)) return index;
			current = current.previous;
			index--;
			
		}
		return -1;
	}
	
	
	/**
	 * Removes the first occurrence of @elem, if it exists in the list.
	 *
	 * @param elem: The element we wish to remove
	 * @return int: The index of the first occurrence of elem prior to its removal, or -1 if
					@elem is not in the list.
	 */
	public int remove(T elem){
		
		Node<T> current = head;
		int index = 0;
		
		while (current != null) {
			if (current.elem.equals(elem)) {
				
				if(current.previous != null) {
					current.previous.next = current.next;
				}else {
					head = current.next;
				}
				if (current.next != null) {
					current.next.previous = current.previous;
				}
				else {
					tail = current.previous;
				}
				size--;
				return index;
			} 
			current = current.next;
			index++;
			
		}
	    return -1;
	}
	
	/**
	 * Removes the element at @index.
	 *
	 * @param index: The position of the element to remove
	 * @return T: The element removed from the list
	 */
	public T remove(int index){
		
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		if(current.previous != null) {
			current.previous.next = current.next;
		}else {
			head = current.next;
		}
		if (current.next != null) {
			current.next.previous = current.previous;
		}
		else {
			tail = current.previous;
		}
		size--;
		return current.elem;
		
	}
	
	
	/**
	 * Removes all instances of @elem from the list.
	 *
	 * @param elem: The element to remove from the list.
	 */
	public void removeAll(T elem){
		
		Node<T> current = head;
		
		
		while (current != null) {
			
			Node<T> nextNode = current.next;
			if (current.elem.equals(elem)) {
				
				if (current.previous != null) {
					current.previous.next = current.next;
				}else {
					head = current.next; // if first node is removed
				}
				
				if (current.next != null) {
					current.next.previous = current.previous;
				} else {
					tail = current.previous;  // if last node is removed
				}
				size--;
			}
			current = nextNode; // move to next node
		}
		
	}
	
	/**
	 * @return int: The number of elements in the list.
	 */ 
	public int size(){
		return size;
	}
	
}