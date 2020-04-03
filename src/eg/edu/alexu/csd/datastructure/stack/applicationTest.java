package eg.edu.alexu.csd.datastructure.stack;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class applicationTest {

	ExpressionEvaluator test = new ExpressionEvaluator();
	
	@Test
	void test1() {
		String expression="2 + 3 * 4";
		String postfix="2 3 4 * +";
		assertEquals(postfix,test.infixToPostfix(expression));
		assertEquals(14,test.evaluate(postfix));
	}
	

	@Test
	void test2() {
		String expression="a * b + 5";
		String postfix="a b * 5 +";
		assertEquals(postfix,test.infixToPostfix(expression));
		
		RuntimeException thrown = assertThrows(RuntimeException.class,() -> test.evaluate(postfix));
		assertEquals("letter is invalid", thrown.getMessage());
		
	}
	
	@Test
	void test3() {
		String expression="(1 + 2) * 7";
		String postfix=" 1 2 + 7 *";
		assertEquals(postfix,test.infixToPostfix(expression));
		assertEquals(21,test.evaluate(postfix));
	}
	
	@Test
	void test4() {
		String expression="(a / (b - c + d)) * (e - a) * c";
		String postfix=" a b c - d + / e a - * c *";
		assertEquals(postfix,test.infixToPostfix(expression));
		
		RuntimeException thrown = assertThrows(RuntimeException.class,() -> test.evaluate(postfix));
		assertEquals("letter is invalid", thrown.getMessage());
		
	}
	
	@Test
	void test5() {
		String expression="a / b - c + d * e - a * c";
		String postfix="a b / c - d e * + a c * -";
		assertEquals(postfix,test.infixToPostfix(expression));
		
		RuntimeException thrown = assertThrows(RuntimeException.class,() -> test.evaluate(postfix));
		assertEquals("letter is invalid", thrown.getMessage());
		
	}
	
	@Test
	void test6() {
		String expression="(4 + 8) * (6 - 5) / ((3 - 2) * (2 + 2))";
		String postfix=" 4 8 + 6 5 - * 3 2 - 2 2 + * /";
		assertEquals(postfix,test.infixToPostfix(expression));
		assertEquals(3,test.evaluate(postfix));
	}
	
	@Test
	void test7() {
		String expression="-(4 + 8) * (6 - -5) / -((3 - 2) * (2 + 2))";
		String postfix="0 4 8 + - 6 0 5 - - * 0 3 2 - 2 2 + * - /";
		assertEquals(postfix,test.infixToPostfix(expression));
		assertEquals(33,test.evaluate(postfix));
	}
	@Test
	void test8() {
		String expression="-100 + 300 - -400 * -(2 * 4) ";
		String postfix="0 100 - 300 + 0 400 0 2 4 * - * - -";
		assertEquals(postfix,test.infixToPostfix(expression));
		assertEquals(-3000,test.evaluate(postfix));
	}
	
	
	
}
