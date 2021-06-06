package lists.mychracterlinkedlsit.doublelinkedlist;

import java.util.*;

public class MyChracterDoubleLinkedList implements Iterable<Character>{
    private Node head;
    private Node tail;
    private int size;

    public MyChracterDoubleLinkedList(){
        head = tail = null;
        size =0;
    }

    /**
     * add a new element at the beginning of the list
     * @param c
     */
    public void addFirst(char c){
        var newNode = new Node(c);
        if(isEmpyt())
        head = tail = newNode;
        else{
            newNode.previous = head;
            head.next = newNode;
            head = newNode;
        }
        size++; 
    }

    /**
     * add a new element at the end of the lsit
     * @param c
     */
    public void addLast(char c){
        var newNode = new Node(c);
        if(isEmpyt())
            head = tail = newNode;
        else{
            newNode.previous = tail;
            tail.next= newNode;
            tail = newNode;
        }
    }
    
    /**
     * checks for a given character data and returns a boolean true 
     * if it finds it in the list
     * @param c
     * @return either true or false depending whether the 
     * element exists or not respectively
     */
    public boolean contains(char c){
        var node = head;
        for(int i =0; i< listSize(); i++){
            if (node.data ==c)
                return true;
            node = node.previous;
            
        }
        return false;
    }

    /**
     * 
     * @param index
     * @return character data item at the given list index entered 
     * from the head 
     */
    public char getFirst(int index){
        if(isEmpyt() || index < 0 || index > listSize() )
            throw new IndexOutOfBoundsException();
        var currentNode = head;
        for(int i = 0; i<= index; i++){
           currentNode = currentNode.previous; 
        }
        return currentNode.data;
    }

    /**
     * 
     * @param index
     * @return character data at the givrn list idex from the tail
     */
    public char getLast(int index){
        if(isEmpyt() || index < 0 || index > listSize() )
            throw new IndexOutOfBoundsException();
        var currentNode = head;
        for(int i = 0; i<= index; i++){
           currentNode = currentNode.next; 
        }
        return currentNode.data;
    }

    /**
     * removes a node at a given list index starting from the head
     * @param index
     */
    public void removeAt(int index){
        if(index < 0 || index> listSize())
            throw new IndexOutOfBoundsException();
        var currentNode = head;
        for( int i = 0; i< index; i++){
            currentNode = currentNode.next;
        }
        currentNode.previous.next = currentNode.next;
        currentNode.next.previous = currentNode.previous;
        currentNode.next = null;
        currentNode.previous = null;
    }
    

    /**
     *  adds a  new node and data item at the given index for data 
     * added from the tail
     * @param item
     * @param index
     */
    public void insertAt(char item,int index){
        if(index < 0 || index> listSize())
            throw new IndexOutOfBoundsException();
        var currentNode = head;
        for( int i = 0; i< index; i++){
            currentNode = currentNode.next;
        }
        var newNode = new Node(item);
        currentNode.previous.next = newNode;
        newNode.next = currentNode.next;
        currentNode.next.previous = newNode;
        newNode.previous = currentNode.previous;
        currentNode.next = null;
        currentNode.previous = null;
    }


    public void printInReverse(){
        var node = tail;
        String buf = "[" + node.data;
        for(int i =1; i<listSize();i++){
            node = node.next;
            buf = buf + "," + node.data;
        }
        System.out.println(buf + "]");
    }

    public String toString(){
        var node = head;
        String buf = "[" + node.data;
		
		for(int i= 1; i<listSize();i++) {
			node= node.previous;
            buf = buf +"," + node.data;
        }
		
		return buf+ "]";
    }

    private int listSize(){
        return size;
    }
    private boolean isEmpyt(){
        return (size==0);
    }

    @Override
    public Iterator<Character> iterator() {
		return new DoubleLinkedListIterator<Character>();
	}
	
	private class DoubleLinkedListIterator<c> implements Iterator<Character> {
		private Node nextNode;
		
		private DoubleLinkedListIterator() {
			nextNode = head;
		}

		@Override
		public boolean hasNext() {
			return (nextNode != null);
		}

		@Override
		public Character next() {
			if(!hasNext())
				throw new NoSuchElementException();
			char nextData = nextNode.data;
			nextNode = nextNode.previous;
			return nextData;
		}
	}
    
    private class Node{
        private Node next;
        private Node previous;
        private char data;

        private Node(){}

        private Node(char data, Node next, Node previous){
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        private Node(char data){
            this(data, null, null);
        }    
    }
}
