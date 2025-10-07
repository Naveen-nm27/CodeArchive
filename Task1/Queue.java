public class Queue{
	int[] queueArray;
	int front,rear,maxSize;
	
	public Queue(int size){
		maxSize = size;
		queueArray = new int[maxSize];
		front = 0;
		rear = -1;	
	}
	
	public boolean isFull(){
		return rear == maxSize - 1;
	}
	
	public boolean isEmpty(){
		return rear == front - 1;
	}
	
	public void enQueue(int element){
		if(isFull()){
			System.out.println("Queue Overflow");
		} else {
			rear++;
			queueArray[rear] = element;
		}
	}
	
	public int deQueue(){
		if(isEmpty()){
			System.out.println("Queue is Empty");
		} else {
			front++;
			int temp = queueArray[front];
			return temp;
		}
		return -1;
	}
	
	public void printElement(){
		if(isEmpty()){
			System.out.println("Queue is Empty");
		} else {
			for(int i = front;i <= rear;i++){
				System.out.print(queueArray[i] + " ");
			}
		}
	}
	
}

class App{
	public static void main(String[] args){
		Queue queue = new Queue(10);
		
		queue.enQueue(5);
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(5);
		
		queue.printElement();
		
		queue.deQueue();
		
		System.out.println();
		
		queue.printElement();
	}
}