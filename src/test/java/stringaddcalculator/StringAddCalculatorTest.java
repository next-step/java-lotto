package stringaddcalculator;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringAddCalculatorTest {

	@DisplayName("빈 문자열 및 NULL 입력 시 0을 반환한다.")
	@NullAndEmptySource
	@ParameterizedTest
	void 빈_문자열_입력에_0이_반환된다(String emptyText) {
		int result = StringAddCalculator.sum(emptyText);
		assertThat(result).isEqualTo(0);
	}

	@DisplayName("하나의 숫자가 입력되면 해당 입력된 숫자를 반환한다")
	@Test
	void 하나의_숫자에_입력한_결과가_반환된다() {
		int result = StringAddCalculator.sum("1");
		assertThat(result).isEqualTo(1);
	}

	@DisplayName("구분자가 컴마로 구성된 문자열이 입력될 경우 이를 합한 숫자가 반환된다.")
	@CsvSource(value = {"3,4! 7", "5,6! 11", "5,6,7! 18"}, delimiter = '!')
	@ParameterizedTest
	void 컴마로_구성된_문자열의_합이_리턴된다(String value, Integer result) {
		assertThat(StringAddCalculator.sum(value)).isEqualTo(result);
	}

	@DisplayName("구분자가 콜론으로 구성된 문자열이 입력될 경우 이를 합한 숫자가 반환된다.")
	@CsvSource(value = {"3:4! 7", "5:6! 11", "5:6:7! 18"}, delimiter = '!')
	@ParameterizedTest
	void 콜론으로_구성된_문자열의_합이_리턴된다(String value, Integer result) {
		assertThat(StringAddCalculator.sum(value)).isEqualTo(result);
	}

	private static Stream<Arguments> provideCustomDelimiterSources() { // argument source method
		return Stream.of(
			Arguments.of("//;\n1;2;3", 6),
			Arguments.of("//@\n2@5@9", 16),
			Arguments.of("//#\n32#29#7", 68),
			Arguments.of("//%\n2%90%5", 97)
		);
	}

	@DisplayName("커스텀 구분자로 지정된 문자열의 합이 리턴된다.")
	@MethodSource("provideCustomDelimiterSources")
	@ParameterizedTest
	void 커스텀_구분자로_구성된_문자열의_합이_리턴된다(String value, Integer result) {
		assertThat(StringAddCalculator.sum(value)).isEqualTo(result);
	}
}
