package nextstep.calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {
	/*
	 * 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
	 * 가능한 연산자 입력값 +,-,*,/ + 숫자
	 * 숫자로 시작하고 숫자, 사칙 연산이 번갈아서 나오고, 마지막은 숫자로 끝나야 한다.
	* */
	@DisplayName("null, 빈 문자열 또는 공백은 처리할 수 없습니다.")
	@NullAndEmptySource
	@ValueSource(strings = {"  ", " "})
	@ParameterizedTest
	public void spec01(final String expression) {
		assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(expression)).withMessage("표현식은 공백일 수 없습니다.");
	}

	@DisplayName("숫자로 시작하고 숫자, 사칙 연산이 번갈아서 나오고, 마지막은 숫자로 끝나야 한다.")
	@ValueSource(strings = {"1 + +", "+ 1 + 2", "1 2 3"})
	@ParameterizedTest
	public void spec02(final String expression) {
		assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(expression)).withMessageStartingWith("유효하지 않은 포맷입니다.");
	}

	@DisplayName("+,-,*,/,숫자 이외의 입력값은 받을 수 없다.")
	@ValueSource(strings = {"1 + 2 =", "4 $ a #"})
	@ParameterizedTest
	public void spec03(final String expression) {
		assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(expression)).withMessageStartingWith("유효하지 않은 포맷입니다.");
	}

	@DisplayName("정상 입력값")
	@CsvSource({
			"'1 + 2', 3",
			"'1 * 2 + 5 ', 7",
			"'2 * 3 + 5', 11",
			"'2 + 2 / 2', 2"
	})
	@ParameterizedTest
	public void spec04(final String expression, final int answer) {
		assertThat(StringCalculator.calculate(expression)).isEqualTo(new Number(answer+""));
	}

}
