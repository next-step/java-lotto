package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OperateTest {

	@Test
	void 더하기() {
		int input1 = 10;
		int input2 = 2;
		int expected = input1 + input2;

		int actual = Operator.SUM.operate(input1, input2);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void 뺴기() {
		int input1 = 10;
		int input2 = 2;
		int expected = input1 - input2;

		int actual = Operator.SUBTRACT.operate(input1, input2);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void 곱하기() {
		int input1 = 10;
		int input2 = 2;
		int expected = input1 * input2;

		int actual = Operator.MUTIPLY.operate(input1, input2);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void 나누기() {
		int input1 = 10;
		int input2 = 2;
		int expected = input1 / input2;

		int actual = Operator.DIVIDE.operate(input1, input2);

		assertThat(actual).isEqualTo(expected);
	}

}
