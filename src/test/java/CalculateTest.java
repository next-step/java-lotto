import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculateTest {

	@Test
	void 더하기() {
		Assertions.assertThat(Calculate.PLUS.calculate(1, 3)).isEqualTo(1 + 3);
	}

	@Test
	void 뺄셈() {
		Assertions.assertThat(Calculate.MINUS.calculate(4, 3)).isEqualTo(4 - 3);
	}


	@Test
	void 곱셈() {
		Assertions.assertThat(Calculate.TIMES.calculate(1, 3)).isEqualTo(1 * 3);
	}


	@Test
	void 나눗셈() {
		Assertions.assertThat(Calculate.DIVIDE.calculate(3, 3)).isEqualTo(3 / 3);
	}


}