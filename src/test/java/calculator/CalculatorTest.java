package calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

	@Test
	void 덧셈() {
		Calculator calculator = new Calculator(Arrays.asList("1", "+", "2"));

		assertThat(calculator.result()).isEqualTo(3);
	}

	@Test
	void 뺄셈() {
		Calculator calculator = new Calculator(Arrays.asList("3", "-", "1"));

		assertThat(calculator.result()).isEqualTo(2);
	}

	@Test
	void 곱셈() {
		Calculator calculator = new Calculator(Arrays.asList("3", "*", "2"));

		assertThat(calculator.result()).isEqualTo(6);
	}

	@Test
	void 나눗셈() {
		Calculator calculator = new Calculator(Arrays.asList("10", "/", "2"));

		assertThat(calculator.result()).isEqualTo(5);
	}

	@Test
	void 덧셈_뺄셈() {
		Calculator calculator = new Calculator(Arrays.asList("1", "+", "5", "-", "3"));

		assertThat(calculator.result()).isEqualTo(3);
	}

	@Test
	void 덧셈_뺄셈_곱셈() {
		Calculator calculator = new Calculator(Arrays.asList("1", "+", "5", "-", "3", "*", "6"));

		assertThat(calculator.result()).isEqualTo(18);
	}

	@Test
	void 덧셈_뺄셈_곱셈_나눗셈() {
		Calculator calculator = new Calculator(Arrays.asList("1", "+", "5", "-", "3", "*", "6", "/", "9"));

		assertThat(calculator.result()).isEqualTo(2);
	}

}
