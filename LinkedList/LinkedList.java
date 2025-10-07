class Node{
	Object element;
	Node next;
	
	Node(Object element,Node next){
		this.element = element;
		this.next = next;
	}
	
	public void displayNode(){
		System.out.println("{"+element+"}");
	}
}

class LinkedList {
	int size;
	Node firstnode;
	
	LinkedList(){
		size = 0;
		firstnode = new Node(null,null);
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public Object get(int index){
		Node p = firstnode; 
		
		for(int i = 0;i <= index;i++){
			p = p.next;
		}
		
		return p.element;
	}
	
	public void add(Object element,int index){
		if(index < 0 || index > size){
			System.out.println("Error in index"); 
		} else if(index == 0){
			firstnode = new Node(element,firstnode);
			size++;
 		} else {
			Node p = firstnode;
			for(int i = 0;i < index - 1;i++){
				p = p.next;
			}
			Node newNode = new Node(element,p.next);
			p.next = newNode;
			size++;
		}
	}
	
	public void remove(int index){
		Object remElement = null;
		
		if(index < 0|| index > size){
			System.out.println("Error in index"); 
		} else if(index == 0){
			firstnode = firstnode.next;
			size--;
		} else {
			Node p = firstnode;
			for(int i = 0;i < index - 1;i++){
					p = p.next;	
				}
			remElement = p.element;
			p.next  = p.next.next;
			size--;
		}
	}
	
	public int indexOf(Object element){
		Node p = firstnode;
		for(int i = 0;i <= size;i++){
			if(p.element.equals(element)){
				return i;
			} else {
				p = p.next;
			}
		}
		return -1;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder("[ ");
		Node p = firstnode;
		for(int i = 0;i < size;i++){
			sb.append(p.element);
			if(i < size - 1){
				sb.append(", ");
			}
			p = p.next;
		}
		sb.append(" ]");
		return sb.toString();
	}
	
}

class Demo{
	public static void main(String args[]){
		LinkedList linkedlist  = new LinkedList();
		
		linkedlist.add(Integer.valueOf(1),0);
		linkedlist.add(Integer.valueOf(2),1);
		linkedlist.add(Integer.valueOf(3),2);
		linkedlist.add(Integer.valueOf(4),3	);
		linkedlist.remove(2);
		System.out.println(linkedlist.toString());
	}
}