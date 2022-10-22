package step1.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.model.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

	Calculator calculator;

	@BeforeEach
	void beforeEach() {
		calculator = Calculator.init(10);
	}

	@Test
	@DisplayName("더하기 테스트")
	void plusTest() {
		calculator.calculate("+", 1);
		assertEquals(calculator.getResult(), 11);
	}

	@Test
	@DisplayName("빼기 테스트")
	void minusTest() {
		calculator.calculate("-", 1);
		assertEquals(calculator.getResult(), 9);
	}

	@Test
	@DisplayName("곱하기 테스트")
	void multiplyTest() {
		calculator.calculate("*", 2);
		assertEquals(calculator.getResult(), 20);
	}

	@Test
	@DisplayName("나누기 테스트")
	void divideTest() {
		calculator.calculate("/", 2);
		assertEquals(calculator.getResult(), 5);
	}


}
