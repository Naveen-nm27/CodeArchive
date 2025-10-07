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
			System.out.println("Queue Overflow");
		} else {
			rear++;
			queueArray[rear] = element;
		}
	}
	
	public Object deQueue() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return null;
		} else {
			Object temp = queueArray[front];
			front++;
			return temp;
		}
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

class Task2{
	public static void main(String[] args){
		Queue queue = new Queue(10);
		
		queue.enQueue(5);
		queue.enQueue("bob");
		queue.enQueue(2);
		queue.enQueue("cat");
		queue.enQueue(2);
		queue.enQueue(55.5);
		
		queue.printElement();
		
		queue.deQueue();
		
		queue.deQueue();
		
		queue.printElement();
	}
}