class Queue{
	Object[] queueArray;
	int front,rear,maxSize;
	
	public Queue(int size){
		maxSize = size;
		queueArray = new Object[maxSize];
		front = 0;
		rear = -1;
	}
	
	public boolean isFull(){
		return rear == maxSize - 1;
	}
	
	public boolean isEmpty(){
		return rear == front - 1;
	}
	
	public void enQueue(Object element){
		if(isFull()){
			if(front > 0){
				for(int i = 0; i < front;i++)
				queueArray[i] = element;
			}
		} else {
			rear++;
			queueArray[rear] = element;
		}
	}
	
	public Object deQueue(){
		if(isEmpty()){
			System.out.println("Queue is Empty");
		} else {
			front++;
			Object temp = queueArray[front];
			return temp;
		}
		return -1;
	}
	
	public void printElement(){
		if(isEmpty()){
			System.out.println("Queue is Empty");
		} else {
			StringBuilder stringbilder = new StringBuilder("[ ");
			for(int i = front;i <= rear;i++){
				stringbilder.append(String.valueOf(queueArray[i]) + " ");
			}
			stringbilder.append("]");
			System.out.println(stringbilder.toString());
		}
		
	}
	
}

class Task3{
	public static void main(String[] args){
		Queue queue = new Queue(10);
		
		queue.enQueue(5);
		queue.enQueue("bob");
		queue.enQueue(6);
		queue.enQueue("cat");
		queue.enQueue(7);
		queue.enQueue(8);
		queue.enQueue(9);
		queue.enQueue(10);
		queue.enQueue(11);
		queue.enQueue(55.5);
		
		queue.printElement();
		
		queue.deQueue();
		queue.deQueue();
		queue.enQueue("hello");
		System.out.println();
		
		queue.printElement();
	}
}