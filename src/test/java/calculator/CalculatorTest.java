package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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

	@DisplayName("입력이 null이거나 빈 공백 문자열일 경우 예외처리")
	@NullAndEmptySource
	@ParameterizedTest
	void calculateWithNullOrEmpty(String input) {
		// given
		Calculator calculator = new Calculator(input);

		// when & then
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					calculator.calculatedInteger();
				}).withMessageMatching("null값이나 빈 공백 문자열은 입력할 수 없습니다. 다시 입력해주세요.");
	}
}
