package calculator;

import calculator.Calculator;
import calculator.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
	private Calculator calculator;

	@BeforeEach
	void setUp() {
		this.calculator = new Calculator();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:+:2:3", "2:-:1:1", "2:*:3:6", "8:/:4:2"}, delimiter = ':')
	@DisplayName("calculate 는 유효한 숫자와 연산자가 주어지면 계산된 결과를 반환한다")
	void calculate_validTwoNumbers_calculatedResult(int left, String operator, int right, int expected) {
		calculator.calculate(left, operator, right);
		int actual = calculator.result();

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	@DisplayName("calculate 는 사칙연산자 이외 연산자가 주어지면 유효한 연산자를 입력하라는 예외를 던진다")
	void calculate_leftBracket_throwsException() {
		String leftBracket = "(";

		assertThatThrownBy(
				() -> calculator.calculate(6, leftBracket, 2)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("calculate 는 유효한 연산자 문자열이 입력되면 계산된 결과를 반환한다")
	void calculate_validInputExpression_validResult() {
		String inputExpression = InputView.inputExpression("2 + 3 * 4 / 2");
		String[] inputs = inputExpression.split(" ");
		calculator.calculate(inputs);
		int actual = calculator.result();
		int expected = (((2 + 3) * 4) / 2);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	@DisplayName("calculate 는 사칙연산자 이외 연산자가 포함된 문자열이 주어지면 유효한 연산자를 입력하라는 예외를 던진다")
	void calculate_inputExpressionWithLeftBracket_throwsException() {
		String inputExpression = InputView.inputExpression("2 + 3 * 4 ( 2");
		String[] inputs = inputExpression.split(" ");
		
		assertThatThrownBy(
				() -> calculator.calculate(inputs)
		).isInstanceOf(IllegalArgumentException.class);
	}
}
