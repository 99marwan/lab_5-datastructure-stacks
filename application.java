package eg.edu.alexu.csd.datastructure.stack;

import java.util.Scanner;

/**
 * this class is an application to test expression evaluator
 * @author smart
 *
 */
public class application {
	/**
	 * print the actions of application
	 */
	public static void print() {
		System.out.println("1: infix to postfix");
		System.out.println("2: evaluate");
		System.out.println("3: exit");
		System.out.println("====================================================================");
		
	}
	
	public static void main(String[] args) {
		String infix="";
		String postfix="";
		ExpressionEvaluator x = new ExpressionEvaluator();
		while (true) {
			print();
			Scanner scan = new Scanner(System.in);
			System.out.println("Choose an action:");
			int choose = scan.nextInt();
			System.out.println("====================================================================");
			switch (choose) {
			  case 1:
			    
			    try {
			    	System.out.println("Enter infix expression:");
			        scan = new Scanner(System.in);
				    infix = scan.nextLine();
				    postfix = x.infixToPostfix(infix);
				    System.out.println("postfix :" + postfix);
				    System.out.println("====================================================================");
			    }
			    catch(Exception e) {
			    	System.out.println(e.getMessage());
			    	System.out.println("====================================================================");
			    }
			    break;
			  case 2:
			    try {
			    	if(postfix=="") {
			    		System.out.println("The postfix does not set yet");
			    		break;
			    	}	
			    	for(int i=0 ; i<postfix.length();i++) {
			    		if(Character.isLetter(postfix.charAt(i))) {
			    		    scan = new Scanner(System.in);
			    		    System.out.println(postfix.charAt(i) + "= ");
			    		    int num = scan.nextInt();
			    			postfix =postfix.replace(Character.toString(postfix.charAt(i)),Integer.toString(num));

			    		}
			    	}
			    	System.out.println("The value : " + x.evaluate(postfix));
			    	System.out.println("====================================================================");
			    }
			    catch(Exception e) {
				    System.out.println(e.getMessage());
				    System.out.println("====================================================================");
			    }
			    break;
			  case 3:
				  System.exit(0);
			    break;
			  default:
				  System.out.println("invalid action");
				  System.out.println("====================================================================");
				  
			}  
		}
	}
}

