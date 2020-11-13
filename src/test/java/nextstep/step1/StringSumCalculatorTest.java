package nextstep.step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

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

}
