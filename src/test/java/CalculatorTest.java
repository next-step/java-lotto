import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
	private Calculator calculator;

	@BeforeEach
	void setUp() {
		this.calculator = new Calculator();
	}

	@Test
	void add_oneAndTwo_three() {
		calculator.calculate(1, Operator.PLUS.symbol(),2);
		int actual = calculator.result();
		int expected = 1 + 2;

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void subtract_towAndOne_one() {
		calculator.calculate(2, Operator.MINUS.symbol(), 1);
		int actual = calculator.result();
		int expected = 2 - 1;

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void multiply_towAndThree_six() {
		calculator.calculate(2, Operator.MULTIPLICATION.symbol(), 3);
		int actual = calculator.result();
		int expected = 2 * 3;

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void divide_sixAndTwo_three() {
		calculator.calculate(6, Operator.DIVISION.symbol(), 2);
		int actual = calculator.result();
		int expected = 6 / 2;

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void given_leftBracket_throwsException() {
		char leftBracket = '(';

		assertThatThrownBy(
				() -> calculator.calculate(6, leftBracket, 2)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void calculate_validInputExpression_validResult() {
		String inputExpression = InputView.inputExpression("2 + 3 * 4 / 2");
		String[] inputs = inputExpression.split(" ");
		calculator.calculate(inputs);
		int actual = calculator.result();
		int expected = (((2 + 3) * 4) / 2);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void calculate_inputExpressionWithLeftBracket_throwsException() {
		String inputExpression = InputView.inputExpression("2 + 3 * 4 ( 2");
		String[] inputs = inputExpression.split(" ");
		
		assertThatThrownBy(
				() -> calculator.calculate(inputs)
		).isInstanceOf(IllegalArgumentException.class);
	}
}
