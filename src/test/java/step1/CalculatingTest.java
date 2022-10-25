package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step1.controller.CalculatorController;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatingTest {
	@ParameterizedTest
	@DisplayName("정상적인 계산기 작동 테스트")
	@ValueSource(strings = {"2 + 3 * 4 / 5", "1 + 2 + 1", "4 * 3 / 3"})
	void calculatingTest(String input){
 		CalculatorController controller = new CalculatorController(input);
		assertEquals(controller.calculating(), 4);
	}

	@ParameterizedTest
	@DisplayName("비정상적인 계산기 작동 테스트")
	@ValueSource(strings = {"1 + 2 ab 3","0.1 + 2 + 3", "1 + + 2 3" })
	void incorrectInputTest(String input){
		Assertions.assertThatThrownBy(() -> new CalculatorController(input).calculating())
				.isInstanceOf(IllegalArgumentException.class);
	}
}
