import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CalculateTest {

	@Test
	void 더하기() {
		assertThat(CalculateLogic.PLUS.calculate(1, 3)).isEqualTo(1 + 3);
	}

	@Test
	void 뺄셈() {
		assertThat(CalculateLogic.MINUS.calculate(4, 3)).isEqualTo(4 - 3);
	}


	@Test
	void 곱셈() {
		assertThat(CalculateLogic.TIMES.calculate(1, 3)).isEqualTo(1 * 3);
	}


	@Test
	void 나눗셈() {
		assertThat(CalculateLogic.DIVIDE.calculate(3, 3)).isEqualTo(3 / 3);
	}

}