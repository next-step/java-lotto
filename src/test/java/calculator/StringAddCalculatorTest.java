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
	void colonAsDelimiter(String inputText) {
		assertThat(StringAddCalculator.splitAndSum(inputText)).isEqualTo(6);
	}

	@DisplayName("'//'와 '\n' 문자 사이에 커스텀 구분자를 지정할 수 있다.")
	@ValueSource(strings = "//;\n1;2;3")
	@ParameterizedTest
	void customDelimiter(String inputText) {
		assertThat(StringAddCalculator.splitAndSum(inputText)).isEqualTo(6);
	}

	@DisplayName("음수 또는 숫자 이외의 값을 전달할 경우 RuntimeException 예외가 발생한다.")
	@ValueSource(strings = {"-1,2,3", "a,b,c", "1,a,-1"})
	@ParameterizedTest
	void invalidInputText(String inputText) {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum(inputText))
			.isInstanceOf(RuntimeException.class);
	}

}
