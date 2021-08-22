package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorTest {
	private StringAddCalculator stringAddCalculator;

	@BeforeEach
	void init() {
		stringAddCalculator = new StringAddCalculator();
	}

	@DisplayName(value = "입력 값이 null 또는 빈 값일 경우 0을 반환")
	@NullAndEmptySource
	@ParameterizedTest
	void inputNullOrEmpty(String input) {
		int result = stringAddCalculator.splitAndSum(input);
		assertThat(result).isEqualTo(0);
	}

	@DisplayName(value = "숫자 하나를 입력할 경우 해당 숫자를 반환")
	@ValueSource(strings = {"1", "2", "3", "4", "5"})
	@ParameterizedTest
	void inputSingleNumber(String input) {
		int result = stringAddCalculator.splitAndSum(input);
		int expect = Integer.parseInt(input);
		assertThat(result).isEqualTo(expect);
	}

	@DisplayName(value = "커스텀 구분자 테스트")
	@Test
	void inputUsingCustomSeparator() {
		String input = "//;\n1;2;3";
		int expect = 6;
		int result = stringAddCalculator.splitAndSum(input);
		assertThat(result).isEqualTo(expect);
	}

	@DisplayName(value = "숫자 이외의 값 또는 음수를 전달하는 경우 예외를 던짐")
	@ValueSource(strings = {"1,-2,3", "1,2,a", "a,b,c"})
	@ParameterizedTest
	void inputNonNumericOrNegative(String input) {
		assertThatThrownBy(() -> stringAddCalculator.splitAndSum(input))
			.isInstanceOf(RuntimeException.class);
	}
}
