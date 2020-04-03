package eg.edu.alexu.csd.datastructure.stack;

import java.util.Scanner;

/**
 * this class is an application to test stack
 * @author smart
 *
 */
public class testStack {
	/**
	 * print the actions of application
	 */
	public static void print() {
		System.out.println("1: Push");
		System.out.println("2: Pop");
		System.out.println("3: Peek");
		System.out.println("4: Get size");
		System.out.println("5: Check if empty");
		System.out.println("6: Exit");
		System.out.println("====================================================================");
	}
	
	public static void main(String[] args) {
		
		Stack stack = new Stack();
		while(true) {
			print();
			Scanner scan = new Scanner(System.in);
			System.out.println("Choose an action:");
			int choose = scan.nextInt();
			System.out.println("====================================================================");
			switch (choose) {
			  case 1:
			    System.out.println("Enter the element you want to push:");
			    scan = new Scanner(System.in);
			    Object x=scan.next();
			    stack.push(x);
			    System.out.println("====================================================================");
			    break;
			  case 2:
			    try {
			    	System.out.println("pop:" + stack.pop());
			    	System.out.println("====================================================================");
			    }
			    catch(Exception e) {
				    System.out.println("stack is empty");
				    System.out.println("====================================================================");
			    }
			    break;
			  case 3:
				  try {
					  System.out.println("peek:"+stack.peek());
					  System.out.println("====================================================================");
				    }
				    catch(Exception e) {
					    System.out.println("stack is empty");
					    System.out.println("====================================================================");
				    }
			    break;
			  case 4:
				  System.out.println("size:"+stack.size());
				  System.out.println("====================================================================");
			    break;
			  case 5:
				System.out.println("empty:"+stack.isEmpty());
				System.out.println("====================================================================");
			    break;
			  case 6:
			    System.exit(0);
			    System.out.println("====================================================================");
			    break;
			  default:
				  System.out.println("invalid action");
				  System.out.println("====================================================================");
				  
			  
			}
		}
	 }
}
