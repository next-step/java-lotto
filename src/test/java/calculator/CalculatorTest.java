package calculator;

import calculator.domain.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {
	private static final Calculator calculator = new Calculator();

	@Test
	void 덧셈() {
		assertThat(calculator.calculate(new String[]{"1", "+", "1"})).isEqualTo(2);
	}

	@Test
	void 뺄셈() {
		assertThat(calculator.calculate(new String[]{"1", "-", "1"})).isEqualTo(0);
	}

	@Test
	void 곱하기() {
		assertThat(calculator.calculate(new String[]{"1", "*", "1"})).isEqualTo(1);
	}

	@Test
	void 나누기() {
		assertThat(calculator.calculate(new String[]{"1", "/", "1"})).isEqualTo(1);
	}

	@Test
	void 빈_값_입력시_예외_호출() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> calculator.calculate(new String[]{}))
				.withMessageMatching("빈 값을 입력했습니다.");

	}

	@Test
	void 올바르지_않은_식_입력시_예외_호출() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> calculator.calculate(new String[]{"/", "1"}))
				.withMessageMatching("식을 잘못 입력했습니다.");

		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> calculator.calculate(new String[]{"1", "+", "1", "/"}))
				.withMessageMatching("식을 잘못 입력했습니다.");
	}
}
