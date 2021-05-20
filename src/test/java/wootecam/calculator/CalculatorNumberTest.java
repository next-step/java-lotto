package wootecam.calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorNumberTest {

	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "13", "109", "199"})
	@DisplayName("계산기에 전달되는 값이 숫자인지 테스트")
	void testCalculatorNumber(String input) {
		CalculatorNumber calculatorNumber = new CalculatorNumber(input);
		assertThat(calculatorNumber.getNumber()).isInstanceOf(Integer.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "-2", "-13", "-109", "-199", "t", "@"})
	@DisplayName("계산기에 전달되는 값이 음수, 숫자가 아닌경우에 대해 RuntimeException")
	void testCalculatorNumberException(String input) {
		assertThatThrownBy(() -> {
			new CalculatorNumber(input);
		}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining("0이상 정수만 입력 가능합니다.");
	}
}
