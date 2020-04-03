package eg.edu.alexu.csd.datastructure.stack;
import java.util.*;
/**
 * 
 * @author smart
 *
 */
public class ExpressionEvaluator implements IExpressionEvaluator {
    /**
     * this function clear spaces from string 
     * @param expression
     * infix expression
     * @return new expression without spaces
     */
	public String clearSpaces(String expression) {
		String result="";
		for (int i=0;i<expression.length();i++) {
			//step over white spaces if it is found
			if(expression.charAt(i)==' ') {
			}
			else
				result += expression.charAt(i);
		}
		return result;
	}
	
	
	@Override
	public String infixToPostfix(String expression) {
		Stack stack = new Stack();
		String expression1=clearSpaces(expression);
		//save in result the "postfix" expression 
		String result="";
		
		for (int i=0;i<expression1.length();i++) {			
			//when the input is number 
			if(Character.isLetterOrDigit(expression1.charAt(i))) {
				if(i+1<expression1.length() &&( Character.isLetter(expression1.charAt(i+1)))) {
					throw new RuntimeException("input is  invalid");
				}
				
				//if number has more than one digit
				else {
					if(i!=0 &&( Character.isDigit(expression1.charAt(i-1)))){
						result += expression1.charAt(i);
					}
					else {
						if(i!=0) {
							result += ' ';
						}
					    result += expression1.charAt(i);
					}
				}
			}
	
			// when input is an operand "*" or "/" as they have Priority
			else if( expression1.charAt(i)=='*' || expression1.charAt(i)=='/') {	
				if(i==0) {
					throw new RuntimeException("input is  invalid");
				}
				//like "**" "+*" and so on 
				else if(i-1>0 &&(expression1.charAt(i-1)=='*' || expression1.charAt(i-1)=='/' ||
						expression1.charAt(i-1)=='+' || expression1.charAt(i-1)=='-')) {
					throw new RuntimeException("input is  invalid");
				}
				else if(!stack.isEmpty()) {
					//here "+" or "-" has less priority than "*" or "/"
					if(((char)stack.peek()=='+' ||(char)stack.peek()=='-' ||(char)stack.peek()=='(' )) {
						stack.push(expression1.charAt(i));
					}
					else {
						result += ' ';
						result += stack.pop();
						stack.push(expression1.charAt(i));
					}
				}
				else if(stack.isEmpty()) {
					stack.push(expression1.charAt(i));
				}		
			}
			
			// when input is an operand "-" or "+"
			else if(expression1.charAt(i) == '-' || expression1.charAt(i) == '+') {
				//if we found it at first the it is sign not operator
				// like "-100" "+100" "-(3)" "+(3)"
				if(i==0) {
					if( Character.isLetterOrDigit(expression1.charAt(i+1)) || expression1.charAt(i+1)=='(' ) {
						if(expression1.charAt(i) == '-') {
							result += '0';
							stack.push(expression1.charAt(i));
						}
					}
					else
						throw new RuntimeException("input is  invalid"); 
				}
				//if we found operator before it and digit after it the it is sign not operator
				//like  "100 + -3" or "100 + - (3)" 
				else if(i != 0 &&(expression1.charAt(i-1)=='+' || expression1.charAt(i-1)=='-'
					|| expression1.charAt(i-1)=='*' || expression1.charAt(i-1)=='/' || expression1.charAt(i-1)=='(')) {
					if(+1<expression1.length() &&( Character.isLetterOrDigit(expression1.charAt(i+1)) 
								 || expression1.charAt(i+1)=='(')) {
						if(expression1.charAt(i) == '-') {
						result += ' ';
						result += '0'; 
						stack.push(expression1.charAt(i));
						}
					}
					else
						throw new RuntimeException("input is  invalid"); 
				}
				//here will treat with it as an operator
				else if(!stack.isEmpty()) {
					if(((char)stack.peek()=='+')){
						result += ' ';
						result += stack.pop();
						stack.push(expression1.charAt(i));
					}
					else if((char)stack.peek()=='*'||(char)stack.peek()=='/'||(char)stack.peek()=='-') {
						result += ' ';
						result += stack.pop();
						if(!stack.isEmpty() && ((char)stack.peek()!='(')) {
							result += ' ';
							result += stack.pop();
						}
						stack.push(expression1.charAt(i));
						}
						else if((char)stack.peek()=='(')
							stack.push(expression1.charAt(i));		
					}
				else if(stack.isEmpty())
					stack.push(expression1.charAt(i));
			}
			
			// when input is an open parentheses.
			else if( expression1.charAt(i)=='(') {
				stack.push(expression1.charAt(i));	
			}			
			
			//when input is an open parentheses and do the operation inside.
			else if(expression1.charAt(i)==')') { 
				if(expression1.charAt(i)==')' && (expression1.charAt(i-1)=='+' || expression1.charAt(i-1)=='-'
						|| expression1.charAt(i-1)=='*' || expression1.charAt(i-1)=='/')){
	    			throw new RuntimeException("input is  invalid");
	    		}	
				while(!stack.isEmpty()&&(char)stack.peek() != '('  ) {
					result += ' ';
					result += stack.pop();
				}
				//close parentheses without open parentheses
				if(stack.isEmpty()) {
					throw new RuntimeException("input is  invalid"); 
				}
				if((char)stack.peek()=='(') {
					stack.pop();	
				}
				//if there is operation before parentheses 
				if(!stack.isEmpty()&&(char)stack.peek()!='(') {
					result += ' ';
					result += stack.pop();
				}
			}
			
			// if one element is not number or one of operation symbols
			else
				throw new RuntimeException("input is  invalid"); 
		    
			//at the end of operation
			if(i==expression1.length()-1) {
		    	while(!stack.isEmpty()) {
		    		//if the last thing in expression is an operator
		    		if(expression1.charAt(i)=='+' || expression1.charAt(i)=='-'
							|| expression1.charAt(i)=='*' || expression1.charAt(i)=='/' || expression1.charAt(i)=='(') {
						throw new RuntimeException("input is  invalid"); 
		    		}
		    		
				    //if there are open parentheses without closed parentheses  
		    		if((char)stack.peek() == '(')
						throw new RuntimeException("input is  invalid"); 
		    		result += ' ';
		    		result += stack.pop();
		    	}
		    }
			
		}
		return result;
	}
	
	
	@Override
	public int evaluate(String expression) {
		Stack stack = new Stack();
		float result =0;
		for (int i=0;i<expression.length();i++) {
			float x ,y;
			if(expression.charAt(i)==' ') {
			}
			else if(Character.isLetter(expression.charAt(i))){
				throw new RuntimeException("letter is invalid");
				
			}
			else if(expression.charAt(i)=='+') {
				x= Float.parseFloat(stack.pop().toString());
				y= Float.parseFloat(stack.pop().toString());
				result = y + x;
				stack.push(result);
			}
			else if(expression.charAt(i)=='-') {
				if(i+1<expression.length() && Character.isDigit(expression.charAt(i+1))) {
					String temp ="";
					while(i<expression.length() && expression.charAt(i) != ' ') {
					    temp +=(expression.charAt(i));
						i++;
					}
					i--;
					
					stack.push(temp);
				}
				else {
					x= Float.parseFloat(stack.pop().toString());
					y= Float.parseFloat(stack.pop().toString());
					result = y - x;
					stack.push(result);
				}
				
			}
			else if(expression.charAt(i)=='*') {
				x= Float.parseFloat(stack.pop().toString());
				y= Float.parseFloat(stack.pop().toString());
				result = y * x;
				stack.push(result);
			}
			else if(expression.charAt(i)=='/') {
				x= Float.parseFloat(stack.pop().toString());
				y= Float.parseFloat(stack.pop().toString());
				// if devided by zero 
				if(x==0) {
					throw new RuntimeException("Invalid : Devided by zero"); 
				}
				result = y / x;
				stack.push(result);
			}
			else if(Character.isDigit(expression.charAt(i))) {
				String temp ="";
				while(i<expression.length() && expression.charAt(i) != ' ' ) {
				    temp +=(expression.charAt(i));
					i++;
				}
				i--;
				
				stack.push(temp);
			}
		}
		
		/*if(!stack.isEmpty())
			throw new RuntimeException("input is invalid"); 
		*/
		return (int) result;
	}
}
