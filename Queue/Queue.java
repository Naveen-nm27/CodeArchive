import java.util.Scanner;

class Queue {
    int maxSize, front = 0, rear = -1, size = 0;
    String[] queueArray;

    Queue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new String[maxSize];
    }

    // Check if queue is full
    public boolean isFull() {
        return size == maxSize;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Add element to the rear of the queue
    public void enqueue(String x) {
        if (isFull()) {
            System.out.println("Queue Overflow");
        } else {
            rear = (rear + 1) % maxSize; // circular increment
            queueArray[rear] = x;
            size++;
        }
    }

    // Remove element from the front of the queue
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return null;
        } else {
            String frontElement = queueArray[front];
            queueArray[front] = null;
            front = (front + 1) % maxSize; // circular increment
            size--;
            return frontElement;
        }
    }

    // Peek at the front element
    public String peek() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return null;
        } else {
            return queueArray[front];
        }
    }

    // Print all elements from front to rear
    public void print() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % maxSize;
            System.out.print(queueArray[index]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println(" ]");
    }

    // Check if the front element is a palindrome
    public boolean isPalindrome() {
        if (isEmpty()) return false;
        String word = queueArray[front];
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }
        return word.equalsIgnoreCase(reversed);
    }
}

class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue queue = new Queue(5);

        System.out.print("Enter a word to enqueue: ");
        queue.enqueue(sc.nextLine());

        queue.print();
        System.out.println("Front Element: " + queue.peek());
        System.out.println("Is Palindrome? " + queue.isPalindrome());

        // Example enqueue/dequeue
        queue.enqueue("hello");
        queue.enqueue("level");
        queue.print();

        System.out.println("Dequeue: " + queue.dequeue());
        queue.print();
    }
}
