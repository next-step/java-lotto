package camp.nextcamp.edu.cacluator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextcamp.edu.calculator.entity.CalculatorNumberInput;

public class CalculatorInputTest {

	@ParameterizedTest
	@DisplayName("숫자로 체크")
	@ValueSource(strings = {"1", "2", "3", "4"})
	void 숫자로_주기(String param) {
		CalculatorNumberInput input = new CalculatorNumberInput(param);
		assertThat(input.getInputTypeInt())
			.isInstanceOf(Integer.class);
	}

	@ParameterizedTest
	@DisplayName("음수 체크 RuntimeException")
	@ValueSource(strings = {"-1", "-2", "-3", "-4"})
	void 음수_테스트(String param) {

		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> new CalculatorNumberInput(param))
			.withMessageMatching("0 이상의 정수만 가능합니다.");

	}
}

