package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("문자열 덧셈 계산기")
class StringAddCalculatorTest {

	@DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.")
	@NullAndEmptySource
	@ParameterizedTest
	void nullOrEmpty(String inputText) {
		int result = StringAddCalculator.splitAndSum(inputText);
		assertThat(result).isZero();
	}

	@DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
	@ValueSource(strings = {"1", "2", "3"})
	@ParameterizedTest
	void oneNumber(String inputText) {
		int result = StringAddCalculator.splitAndSum(inputText);
		assertThat(result).isEqualTo(Integer.parseInt(inputText));
	}

}
