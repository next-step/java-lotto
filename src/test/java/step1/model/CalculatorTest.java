package step1.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

	Calculator calculator = new Calculator();

	@Test
	@DisplayName("더하기 테스트")
	void plusTest() {
		calculator.init("+");
		assertEquals(calculator.calculate(1, 1), 2);
	}

	@Test
	@DisplayName("빼기 테스트")
	void minusTest() {
		calculator.init("-");
		assertEquals(calculator.calculate(3,  1), 2);
	}

	@Test
	@DisplayName("곱하기 테스트")
	void multiplyTest() {
		calculator.init("*");
		assertEquals(calculator.calculate(5, 2), 10);
	}

	@Test
	@DisplayName("나누기 테스트")
	void divideTest() {
		calculator.init("/");
		assertEquals(calculator.calculate(10,  2), 5);
	}


}
