package nextstep.step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class StringSumCalculatorTest {
	private StringSumCalculator underTest = new StringSumCalculator();
	@ParameterizedTest
	@DisplayName("쉼표나 콜론 구분자로 가지는 문자열 전달하면 해당 숫자의 sum을 반환")
	@CsvSource(value = {"1=1","1,2=3", "1,2:3=6", "1,2,3,4:5:6=21"}, delimiter = '=')
	public void sumCalculateTest(String input, int expected) {
		assertThat(underTest.sum(input)).isEqualTo(expected);
	}

	@Test
	@DisplayName("널이나 empty이면 0을 반환")
	public void nullOrBlankReturnZeroTest() {
		assertThat(underTest.sum( null)).isEqualTo(0);
		assertThat(underTest.sum(",,,,")).isEqualTo(0);
		assertThat(underTest.sum("::::")).isEqualTo(0);
		assertThat(underTest.sum(",:,:")).isEqualTo(0);
	}

	@Test
	@DisplayName("더할 값이 문자열인 경우 예외를 던진다.")
	public void invalidateInputStringTest() {
		Assertions.assertThatExceptionOfType(RuntimeException.class)
				.isThrownBy(() -> underTest.sum("a,b"))
				.withMessage("input값은 양수만 가능합니다.");
	}

	@Test
	@DisplayName("더할 값이 음수 경우 예외를 던진다.")
	public void invalidatePositiveNumberTest() {
		Assertions.assertThatExceptionOfType(RuntimeException.class)
				.isThrownBy(() -> underTest.sum("-1,2,3"))
				.withMessage("input값은 양수만 가능합니다.");
	}

	@Test
	@DisplayName("커스텀 구분자를 지정하여 합을 구할수 있다.")
	public void customDelimiterTest() {
		assertThat(underTest.sum("//;\n1;2;3")).isEqualTo(6);
		assertThat(underTest.sum("//&\n1&2&3&4")).isEqualTo(10);
		assertThat(underTest.sum("//%\n1%2%3%4%5")).isEqualTo(15);
		assertThat(underTest.sum("//@\n1@2@3@4@5@6")).isEqualTo(21);
	}
}
