package step1.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step1.domain.StringCalculator.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step1.exception.DivideZeroException;

class StringCalculatorTest {
	StringCalculator sc = new StringCalculator();

	@Test
	@DisplayName("덧셈 테스트")
	void sumTest() {
		assertThat(calculate("1 + 2")).isEqualTo(3);
		assertThat(calculate("3 + 4")).isEqualTo(7);
		assertThat(calculate("1 + 2 + 3")).isEqualTo(6);
	}

	@Test
	@DisplayName("뺄셈 테스트")
	void diffTest() {
		assertThat(calculate("2 - 1")).isEqualTo(1);
		assertThat(calculate("3 - 5")).isEqualTo(-2);
		assertThat(calculate("6 - 3 - 2")).isEqualTo(1);
	}

	@Test
	@DisplayName("곱하기 테스트")
	void multiplyTest() {
		assertThat(calculate("3 * 2")).isEqualTo(6);
		assertThat(calculate("-1 * 2")).isEqualTo(-2);
		assertThat(calculate("1 * 2 * 0")).isEqualTo(0);
	}

	@Test
	@DisplayName("나누기 테스트")
	void divideTest() {
		assertThat(calculate("4 % 1")).isEqualTo(4);
		assertThat(calculate("8 % 2 % 2")).isEqualTo(2);
	}

	@Test
	@DisplayName("나눗셈 결과는 정수로 떨어지는지 체크하는 테스트")
	void isDivideReturnNaturalNumberTest() {
		assertThat(calculate("5 % 2")).isEqualTo(2);
	}

	@Test
	@DisplayName("사칙연산의 우선순위가 입력 순인지 체크하는 테스트")
	void calculateSequenceTest() {
		assertThat(calculate("1 + 2 * 3")).isEqualTo(9);
	}

	@Test
	@DisplayName("나누기 0 할시 throw 테스트")
	void divideZeroTest() {
		assertThatThrownBy(() -> {
			calculate("3 % 0");
		}).isInstanceOf(DivideZeroException.class);
	}
}