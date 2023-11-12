import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
	@DisplayName("유효한 문자열이 주어지면 controller 는 정상 계산을 한다")
	void calculate_validInput_result() {
		final String inputExpression = InputView.inputExpression("2 + 3 - 4");
		final int actual = ((2 + 3) - 4);

		controller.calculate(inputExpression);
		final int expected = calculator.result();

		assertThat(expected).isEqualTo(actual);
	}

	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("controller 는 빈 문자열이 주어지면 유효한 문자열을 입력하라는 예외를 던진다")
	void calculate_nullAndEmpty_throwsException(String emptyString) {
		assertThatThrownBy(
				() -> controller.calculate(emptyString)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("controller 는 나누기 0이 주어지면 0으로 나눌 수 없다는 예외를 던진다.")
	void calculate_divideByZero_throwsException() {
		final String inputExpression = "3 + 2 / 0";

		assertThatThrownBy(
				() -> controller.calculate(inputExpression)
		).isInstanceOf(IllegalArgumentException.class);
	}
}
