import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
	private final static Character PLUS = '+';
	private final static Character MINUS = '-';
	private final static Character MULTIPLICATION = '*';
	private final static Character DIVISION = '/';
	private final static Character LEFT_BRACKET = '(';

	private Calculator calculator;

	@BeforeEach
	void setUp() {
		this.calculator = new Calculator();
	}

	@Test
	void add_oneAndTwo_three() {
		calculator.calculate(1, PLUS,2);
		int result = calculator.result();

		assertThat(result).isEqualTo(3);
	}

	@Test
	void subtract_towAndOne_one() {
		calculator.calculate(2, MINUS, 1);
		int result = calculator.result();

		assertThat(result).isEqualTo(1);
	}

	@Test
	void multiply_towAndThree_six() {
		calculator.calculate(2, MULTIPLICATION, 3);
		int result = calculator.result();

		assertThat(result).isEqualTo(6);
	}

	@Test
	void divide_sixAndTwo_Three() {
		calculator.calculate(6, DIVISION, 2);
		int result = calculator.result();

		assertThat(result).isEqualTo(3);
	}

	@Test
	void given_leftBracket_throwsException() {
		assertThatThrownBy(
				() -> calculator.calculate(6, LEFT_BRACKET, 2)
		).isInstanceOf(IllegalArgumentException.class);
	}
}
