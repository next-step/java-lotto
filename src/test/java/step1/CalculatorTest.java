package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {

	@DisplayName(value = "문자열의 총 합을 구하는 기능 테스트")
	@Test
	void getIntegerSumOfStrings() {
		String value = "5,4,3,2";
		int result = Calculator.getIntegerSumOfStrings(value);
		assertThat(result).isEqualTo(14);
	}

	@DisplayName(value = "숫자 이외의 값이나 음수 입력 시 예외 발생 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"3,5,-1,2", "a:b:1:4"})
	void getIntegerSumOfStringsException(String value) {
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(
				() -> Calculator.getIntegerSumOfStrings(value)
		).isInstanceOf(RuntimeException.class);
	}

}
