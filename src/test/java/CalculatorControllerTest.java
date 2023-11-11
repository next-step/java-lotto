import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorControllerTest {
	private Calculator calculator;
	private CalculatorController controller;

	@BeforeEach
	void setUp() {
		this.calculator = new Calculator();
		this.controller = new CalculatorController(this.calculator);
	}

	@Test
	void calculate_validInput_result() {
		String inputExpression = InputView.inputExpression("2 + 3 - 4");
		int actual = ((2 + 3) - 4);

		controller.calculate(inputExpression);
		int expected = calculator.result();

		assertThat(expected).isEqualTo(actual);
	}

	@ParameterizedTest
	@NullAndEmptySource
	void calculate_nullAndEmpty_throwsException(String emptyString) {
		assertThatThrownBy(
				() -> controller.calculate(emptyString)
		).isInstanceOf(IllegalArgumentException.class);
	}
}
