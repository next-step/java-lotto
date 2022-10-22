package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.controller.CalculatorController;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatingTest {
	@Test
	@DisplayName("정상적인 계산기 작동 테스트")
	void calculatingTest(){
		String input = "2 + 3 * 4 / 5";
 		CalculatorController controller = new CalculatorController(input);
		assertEquals(controller.calculating(), 4);
	}

	@Test
	@DisplayName("비정상적인 계산기 작동 테스트")
	void incorrectInputTest(){
		Assertions.assertThatThrownBy(() -> new CalculatorController("1 + 2 ab 3").calculating()).isInstanceOf(IllegalArgumentException.class);
		Assertions.assertThatThrownBy(() -> new CalculatorController("0.1 + 2 + 3").calculating()).isInstanceOf(IllegalArgumentException.class);
		Assertions.assertThatThrownBy(() -> new CalculatorController("1 + + 2 3").calculating()).isInstanceOf(IllegalArgumentException.class);
	}
}
