package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@DisplayName("더하기")
	@Test
	public void sum() {
		int a = 5;
		int b = 3;
		int expected = 8;
		assertEquals(expected, Calculator.ADD.apply(a, b));
	}

	@DisplayName("빼기")
	@Test
	public void minus() {
		int a = 9;
		int b = 4;
		int expected = 5;
		assertEquals(expected, Calculator.SUBTRACT.apply(a, b));
	}

	@DisplayName("곱하기")
	@Test
	public void multiple() {
		int a = 4;
		int b = 4;
		int expected = 16;
		assertEquals(expected, Calculator.MULTIPLY.apply(a, b));
	}

	@DisplayName("나누기")
	@Test
	public void divide() {
		int a = 10;
		int b = 2;
		int expected = 5;
		assertEquals(expected, Calculator.DIVIDE.apply(a, b));
	}
}
