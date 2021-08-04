package calculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringAddCalculatorTest {

	StringAddCalculator stringAddCalculator;

	@ParameterizedTest
	@CsvSource(value = {"1,2,3=6", ",=0", "1;2,3=6"}, delimiter = '=')
	@DisplayName("구분자를 통해 분리하여 덧셈")
	void splitAndAddStringSuccess(String input, int expected) {
		stringAddCalculator = new StringAddCalculator(input);

		int result = stringAddCalculator.splitAndAdd();

		assertThat(result).isEqualTo(expected);
	}

	@Test
	@DisplayName("커스텀 구분자를 추가 후 분리하여 덧셈")
	void addCustomSeparatorSuccess() {
		stringAddCalculator = new StringAddCalculator("//+\n1+2,3");

		int result = stringAddCalculator.splitAndAdd();

		assertThat(result).isEqualTo(6);
	}

	@Test
	@DisplayName("음수를 입력했을때 예외 발생")
	void checkNegativeNumbers() {
		stringAddCalculator = new StringAddCalculator("-1;2,3");

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				stringAddCalculator.splitAndAdd();
			}).withMessage("양수만 입력이 가능합니다.");
	}

	@Test
	@DisplayName("입력된 숫자 검증")
	void checkNumber() {
		stringAddCalculator = new StringAddCalculator("dd;ff,3");

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				stringAddCalculator.splitAndAdd();
			}).withMessage("숫자가 아닙니다.");
	}
}