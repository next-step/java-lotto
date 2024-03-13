package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
	@DisplayName("계산하기")
	@Test
	void calculateArithmetic() {
		// given
		String input = "4 * 2 + 3 / 3";

		// when
		Calculator calculator = new Calculator(input);
		int result = calculator.calculatedInteger();

		// then
		assertThat(result).isEqualTo(3);
	}
}
