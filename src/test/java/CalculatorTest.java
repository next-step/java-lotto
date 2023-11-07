import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
	@Test
	void add_oneAndTwo_three() {
		Calculator c = new Calculator();
		int result = c.calculation(1, '+',2);

		assertThat(result).isEqualTo(3);
	}

	@Test
	void subtract_towAndOne_one() {
		Calculator c = new Calculator();
		int result = c.calculation(2, '-', 1);

		assertThat(result).isEqualTo(1);
	}

	@Test
	void multiply_towAndThree_six() {
		Calculator c = new Calculator();
		int result = c.calculation(2, '*', 3);

		assertThat(result).isEqualTo(6);
	}

	@Test
	void divide_sixAndTwo_Three() {
		Calculator c = new Calculator();
		int result = c.calculation(6, '/', 2);

		assertThat(result).isEqualTo(3);
	}

	@Test
	void given_leftBracket_throwsException() {
		Calculator c = new Calculator();
		assertThatThrownBy(
				() -> c.calculation(6, '(', 2)
		).isInstanceOf(IllegalArgumentException.class);
	}
}
