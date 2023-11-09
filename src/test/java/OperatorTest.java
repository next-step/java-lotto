import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {
	private final static int FOUR = 4;
	private final static int TWO = 2;

	@Test
	void add_fourAndTwo_six() {
		int actual = FOUR + TWO;
		int expected = Operator.calculate(FOUR, Operator.PLUS.symbol(), TWO);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void subtract_fourAndTwo_two() {
		int actual = FOUR - TWO;
		int expected = Operator.calculate(FOUR, Operator.MINUS.symbol(), TWO);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void multiply_fourAndTwo_eight() {
		int actual = FOUR * TWO;
		int expected = Operator.calculate(FOUR, Operator.MULTIPLICATION.symbol(), TWO);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void divide_fourAndTwo_two() {
		int actual = FOUR / TWO;
		int expected = Operator.calculate(FOUR, Operator.DIVISION.symbol(), TWO);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void from_plus_plusOperator() {
		Operator actual = Operator.PLUS;
		Operator expected = Operator.from(Operator.PLUS.symbol());

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void from_leftBracket_throwsException() {
		char leftBracket = '(';

		assertThatThrownBy(
				() -> Operator.from(leftBracket)
		).isInstanceOf(IllegalArgumentException.class);
	}
}
