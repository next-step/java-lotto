package step1.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {
	StringCalculator sc = new StringCalculator();

	@Test
	@DisplayName("덧셈 테스트")
	void sumTest() {
		assertThat(sc.calculate("1 + 2")).isEqualTo(3);
		assertThat(sc.calculate("3 + 4")).isEqualTo(7);
		assertThat(sc.calculate("1 + 2 + 3")).isEqualTo(6);
	}

	@Test
	@DisplayName("뺄셈 테스트")
	void diffTest() {
		assertThat(sc.calculate("2 - 1")).isEqualTo(1);
		assertThat(sc.calculate("3 - 5")).isEqualTo(-2);
		assertThat(sc.calculate("6 - 3 - 2")).isEqualTo(1);
	}

	@Test
	@DisplayName("곱하기 테스트")
	void multiplyTest() {
		assertThat(sc.calculate("3 * 2")).isEqualTo(6);
		assertThat(sc.calculate("-1 * 2")).isEqualTo(-2);
		assertThat(sc.calculate("1 * 2 * 0")).isEqualTo(0);
	}

	@Test
	@DisplayName("나누기 테스트")
	void divideTest() {
		assertThat(sc.calculate("5 % 2")).isEqualTo(2);
		assertThat(sc.calculate("4 % 1")).isEqualTo(4);
		assertThat(sc.calculate("8 % 2 % 2")).isEqualTo(2);
	}

}