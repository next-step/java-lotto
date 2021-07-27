package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@DisplayName("문자열 덧셈 계산기")
class StringAddCalculatorTest {

	@DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.")
	@NullAndEmptySource
	@ParameterizedTest
	void nullOrEmpty(String inputText) {
		int result = StringAddCalculator.splitAndSum(inputText);
		assertThat(result).isZero();
	}

}
