class DoublyNode{
	public Object element;
	public DoublyNode next;
	public DoublyNode previous;
	
	DoublyNode(Object element,DoublyNode next,DoublyNode previous){
		this.element = element;
		this.next = next;
		this.previous = previous;
	}
	
	public void displayNode(){
		System.out.println("{ "+element+" }");
	}
}

class DoublyLinedList{
	DoublyNode firstNode;
	DoublyNode lastNode;
	int size;
	
	public DoublyLinedList(){
		firstNode = null;
		lastNode = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
	
	public boolean checkIndex(int index){
		if(index < 0 || index > size){
			throw IndexOutOfBoundsException("Index: "+ index);
		} else {
			return true;
		}
	}
	
	public Object get(int index){
		checkIndex(index);
		
		if(index < size / 2){
			for(int i = 0;i < index;i++){
				p = p.next;
			} 
		} else {
			for(int i = size - 1;i > index;i--){
				p = p.previous;
			}
		}
		return p.element;
	}
	
	
	public void add(Object element,int index){
		checkIndex(index);
		
		if(index == 0){
			DoublyNode newNode = new DoublyNode(element,firstNode,null);
			if(firstNode != null){
				firstNode.previous = newNode;
			} else {
				lastNode = newNode;
			}
			firstNode = newNode;
		} else if(index == size){
			DoublyNode newNode = new DoublyNode(element,null,lastNode);
			if(lastNode != null){
				lastNode.next = newNode;
			}else{
				firstNode = newNode;
			}
			lastNode = newNode
		}else {
			DoublyNode p = firstNode;
			for(int i = 0; i < index;i++){
				p = p.next
			}
			DoublyNode newNode = new DoublyNode(element,p,p.previous);
			p.previous.next = newNode;
			p.previous = newNode;
		}
	}
	
	
	public Object remove(int index){
		checkIndex(index);
		Object rem;
		
		if(index == 0){
				rem = firstNode.element;
				firstNode = firstNode.next;
			if(firstNode != null){
				firstNode.previous = null;
			} else {
				lastNode = null;
			} else if(index == size - 1){
				rem = lastNode.element;
				lastNode = lastNode.previous;
				if(lastNode != null){
					firstNode = null;
				}
			} else {
				DoublyNode p = firstNode;
				for(int i = 0; i < index;i++){
					p = p.next
				}
				rem = p.element;
				p.previous.next = p.next;
				p.next.previous = p.previous;
			}
		}
	}
}