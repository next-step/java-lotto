package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
	@Test
	void 덧셈() {
		Calculator calculator = new Calculator();
		assertThat(calculator.run("3 + 2 + 1")).isEqualTo(6);
	}

	@Test
	void 뺄셈() {
		Calculator calculator = new Calculator();
		assertThat(calculator.run("3 - 2 - 1")).isEqualTo(0);
	}

	@Test
	void 곱셈() {
		Calculator calculator = new Calculator();
		assertThat(calculator.run("3 * 2 * 1")).isEqualTo(6);
	}

	@Test
	void 나눗셈() {
		Calculator calculator = new Calculator();
		assertThat(calculator.run("3 / 2 / 2")).isEqualTo(0);
	}

	@Test
	void 복합계산() {
		Calculator calculator = new Calculator();
		assertThat(calculator.run("2 + 3 * 4 / 2")).isEqualTo(10);
	}

}
