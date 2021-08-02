package calculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringAddCalculatorTest {

	@ParameterizedTest
	@CsvSource(value = {"1,2,3=6", ",=0", "1;2,3=6"}, delimiter = '=')
	@DisplayName("구분자를 통해 분리하여 덧셈")
	void splitAndAddStringSuccess(String input, int expected) {
		int result = StringAddCalculator.splitAndAdd(input);

		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"//+\n1+2,3=6", "//@\n1,2@3=6"}, delimiter = '=')
	@DisplayName("커스텀 구분자를 추가 후 분리하여 덧셈")
	void addCustomSeparatorSuccess(String input, int expected) {
		int result = StringAddCalculator.splitAndAdd(input);

		assertThat(result).isEqualTo(expected);
	}
}