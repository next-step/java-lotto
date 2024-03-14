package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CalculatorTest {
	@DisplayName("계산하기")
	@Test
	void calculate() {
		// given
		String input = "4 * 2 + 3 / 3";

		// when
		Calculator calculator = new Calculator(input);
		int result = calculator.calculatedInteger();

		// then
		assertThat(result).isEqualTo(3);
	}

	@DisplayName("사칙 연산 기호가 아닐 때 예외 처리")
	@Test
	void calculateWithNotArithmetic() {
		// given
		String input = "4 ( 2 + 3 / 3";
		Calculator calculator = new Calculator(input);

		// when & then
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					calculator.calculatedInteger();
				}).withMessageMatching("사칙 연산 기호가 아닙니다.");
	}
}
