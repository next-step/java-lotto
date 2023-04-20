package stringcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	@DisplayName("덧셈")
	@Test
	void test1() {
		StringCalculator stringCalculator = new StringCalculator("1", "2");
		Number result = stringCalculator.add();
		assertThat(result).isEqualTo(new Number(3));
	}

	@DisplayName("뺄셈")
	@Test
	void test2() {
		StringCalculator stringCalculator = new StringCalculator("9", "1");
		Number result = stringCalculator.subtract();
		assertThat(result).isEqualTo(new Number(8));
	}

	@DisplayName("곱셈")
	@Test
	void test3() {
		StringCalculator stringCalculator = new StringCalculator("5", "3");
		Number result = stringCalculator.multiply();
		assertThat(result).isEqualTo(new Number(15));
	}

	@DisplayName("나눗셈")
	@Test
	void test4() {
		StringCalculator stringCalculator = new StringCalculator("9", "2");
		Number result = stringCalculator.divide();
		assertThat(result).isEqualTo(new Number(4));
	}

	@DisplayName("나눗셈 예외 케이스 - 나누려는 숫자가 0인 경우")
	@Test
	void test5() {
		StringCalculator stringCalculator = new StringCalculator("9", "0");
		assertThatThrownBy(stringCalculator::divide).isInstanceOf(IllegalArgumentException.class);
	}
}
