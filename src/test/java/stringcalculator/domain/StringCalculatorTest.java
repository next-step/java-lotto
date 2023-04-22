package stringcalculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	@DisplayName("덧셈")
	@Test
	void test1() {
		assertThat(StringCalculator.ADD.calculate("1", "2")).isEqualTo("3");
	}

	@DisplayName("뺄셈")
	@Test
	void test2() {
		assertThat(StringCalculator.SUBTRACT.calculate("9", "1")).isEqualTo("8");
	}

	@DisplayName("곱셈")
	@Test
	void test3() {
		assertThat(StringCalculator.MULTIPLY.calculate("5", "3")).isEqualTo("15");
	}

	@DisplayName("나눗셈")
	@Test
	void test4() {
		assertThat(StringCalculator.DIVIDE.calculate("9", "2")).isEqualTo("4");
	}

	@DisplayName("나눗셈 예외 케이스 - 나누려는 숫자가 0인 경우")
	@Test
	void test5() {
		assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.DIVIDE.calculate("9", "0"));
	}

	@DisplayName("findCalculator() 메서드 정상 동작확인")
	@Test
	void test6() {
		StringCalculator calculator = StringCalculator.findCalculator(new Operator("+"));
		assertThat(calculator.calculate("5", "3")).isEqualTo("8");
	}
}
