class Stack{
	int maxSize,top = -1;
	String[] stackArray;
	
	Stack(int size){
		maxSize = size;
		stackArray = new String[maxSize];
	}
	
	
	public void pop(){
		if(isEmpty()){
			System.out.println("Error");
		} else {
			String temp = stackArray[top];
			stackArray[top] = null;
			top--;
			return temp;
		}
	}
	
	public void push(String s){
		if(isEmpty()){
			System.out.println("Error");
		} else {
			stackArray[top] = s;
			top++;
		}
	}
}