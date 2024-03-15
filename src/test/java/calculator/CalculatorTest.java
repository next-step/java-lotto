package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	private Calculator sut;

	@BeforeEach
	void setUp() {
		sut = new Calculator();
	}

	@Test
	void 더하기() {
		int input1 = 10;
		int input2 = 2;
		int expected = input1 + input2;

		int actual = sut.sum(input1, input2);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void 뺴기() {
		int input1 = 10;
		int input2 = 2;
		int expected = input1 - input2;

		int actual = sut.substact(input1, input2);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void 곱하기() {
		int input1 = 10;
		int input2 = 2;
		int expected = input1 * input2;

		int actual = sut.multiply(input1, input2);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void 나누기() {
		int input1 = 10;
		int input2 = 2;
		int expected = input1 / input2;

		int actual = sut.divide(input1, input2);

		assertThat(actual).isEqualTo(expected);
	}

}
