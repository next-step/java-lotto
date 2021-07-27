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
		assertThat(StringAddCalculator.splitAndSum(inputText)).isZero();
	}

	@DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
	@ValueSource(strings = {"1", "2", "3"})
	@ParameterizedTest
	void oneNumber(String inputText) {
		assertThat(StringAddCalculator.splitAndSum(inputText)).isEqualTo(Integer.parseInt(inputText));
	}

	@DisplayName("숫자 2개를 구분자(,)로 입력할 경우 두 숫자의 합을 반환한다.")
	@ValueSource(strings = {"1,2"})
	@ParameterizedTest
	void twoNumber(String inputText) {
		assertThat(StringAddCalculator.splitAndSum(inputText)).isEqualTo(3);
	}

	@DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
	@ValueSource(strings = "1,2:3")
	@ParameterizedTest
	void variousDelimiter(String inputText) {
		assertThat(StringAddCalculator.splitAndSum(inputText)).isEqualTo(6);
	}

}
