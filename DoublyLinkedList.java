package Lists;

public class DoublyLinkedList{
class Node{
	int data;
	Node nextNode;
	Node preNode;
	Node(int data){
		this.data = data;
	}
}
	Node head = null;
	Node tail = null;
	public Node CurNode=null;
    private int size = 0;
	public void append(int num) {
		 Node newNode = new Node(num);
	        if (tail == null) {
	            head = newNode;
	            tail = newNode;
	        } else {
	        	newNode.preNode = tail;
	            tail.nextNode = newNode;
	            tail = newNode;
	        }
	        size++;
	}
    public void prepend	(int num) {
    	Node newNode = new Node(num);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
        	newNode.nextNode = head;
            head.preNode = newNode;
            head = newNode;
        }
        size++;
	}
    public void delete(int ele) {
    	 CurNode = head;
        while (CurNode != null) {
            if (CurNode.data == ele) {
                if (CurNode == head && CurNode == tail) {
                    head = null;
                    tail = null;
                } else if (CurNode == head) {
                    head = CurNode.nextNode;
                    head.preNode = null;
                } else if (CurNode == tail) {
                    tail = CurNode.preNode;
                    tail.nextNode = null;
                } else {
                	CurNode.preNode.nextNode = CurNode.nextNode;
                	CurNode.nextNode.preNode = CurNode.preNode;
                }
                size--;
                break;
            }
            CurNode = CurNode.nextNode;
        }
    }
    public void display() {
    	       CurNode = head;
          while (CurNode != null) {
              System.out.println(CurNode.data + " ");
              CurNode = CurNode.nextNode;
          }
         
      }
    public int get() {
    	if(CurNode == null) {
    	 CurNode = head;
    	}else {
            CurNode = CurNode.nextNode;
    	}
    	
    	 return CurNode.data;
    }
    
    public int  pop() {
    	int num = tail.data;
    	tail.preNode.nextNode = tail.nextNode;
    	tail.nextNode.preNode = tail.preNode;
    	tail= tail.preNode;
    	return num;
    }
   
    public int shift() {
    	int num = head.data;
    	head.nextNode.preNode = head.preNode;
    	head.preNode.nextNode = head.nextNode;
    	head = head.nextNode;
    	return num;
    }
    
    public int size() {
    	return size;
    }
    public boolean 	isEmpty() {
    	if(head == null) {
    		return true;
    	}
    	return false;
    }
    
    public void clear() {
    	head = null;
    	tail = null;
    	CurNode = null;
    	size = 0;
    }
}


