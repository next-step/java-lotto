package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exceptions.InvalidPatternException;

public class StringAddCalculatorTest {

	@DisplayName("빈 문자열 또는 null 값이면 참이다.")
	@Test
	void isEmpty_True() {
		assertThat(StringAddCalculator.isEmpty("")).isTrue();
		assertThat(StringAddCalculator.isEmpty(null)).isTrue();
	}

	@DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.")
	@Test
	void compute_EmptyString_0() {
		assertThat(StringAddCalculator.compute("")).isEqualTo(0);
		assertThat(StringAddCalculator.compute(null)).isEqualTo(0);
	}

	@DisplayName("올바른 패턴의 숫자를 입력할 경우 합계를 반환한다.")
	@ParameterizedTest(name = "입력: \"{0}\", 합: \"{1}\"")
	@CsvSource(value = {"1=1", "1,2=3", "1,2:3=6", "//;\\n1,2:3;4=10", "//*\\n1*2=3"}, delimiter = '=')
	void compute_Numbers_Success(String input, int expected) {
		assertThat(StringAddCalculator.compute(input)).isEqualTo(expected);
	}

	@DisplayName("잘못된 입력을 할 경우 에러를 발생한다.")
	@ParameterizedTest(name = "입력: \"{0}\"")
	@ValueSource(strings = {"a", "-1", "//;\\n1=2"})
	void compute_InvalidPattern_ExceptionThrown(String input) {
		assertThatExceptionOfType(InvalidPatternException.class).isThrownBy(() -> {
			StringAddCalculator.compute(input);
		});
	}

	@DisplayName("구분자 목록 문자열을 생성한다.")
	@ParameterizedTest(name = "입력: \"{0}\", 구분자 목록: \"{1}\"")
	@CsvSource(value = {"=,|:", ";=,|:|;", "*=,|:|*"}, delimiter = '=')
	void loadDelimiters(String input, String expected) {
		assertThat(StringAddCalculator.loadDelimiters(input)).isEqualTo(expected);
	}

	private static Stream<Arguments> captureNumbers_WithDelimiters_Success() {
		return Stream.of(
			Arguments.of("1", Collections.singletonList("1")),
			Arguments.of("1,2", Arrays.asList("1", "2")),
			Arguments.of("1,2:3", Arrays.asList("1", "2", "3")),
			Arguments.of("//;\\n1,2:3;4", Arrays.asList("1", "2", "3", "4")),
			Arguments.of("//*\\n1*2", Arrays.asList("1", "2"))
		);
	}

	@DisplayName("문자열을 숫자 목록으로 변환한다.")
	@ParameterizedTest(name = "입력: \"{0}\", 숫자 목록: \"{1}\"")
	@MethodSource
	void captureNumbers_WithDelimiters_Success(String input, List<String> expected) {
		assertThat(StringAddCalculator.captureNumbers(input)).isEqualTo(expected);
	}

	private static Stream<Arguments> captureNumbers_WithMetaCharacter_Success() {
		return Stream.of(
			Arguments.of("//*\\n1*2", Arrays.asList("1", "2")),
			Arguments.of("//+\\n1+2+3", Arrays.asList("1", "2", "3"))
		);
	}

	@DisplayName("문자열 변환 처리 중 Meta Character 구분자를 처리한다.")
	@ParameterizedTest(name = "입력: \"{0}\", 숫자 목록: \"{1}\"")
	@MethodSource
	void captureNumbers_WithMetaCharacter_Success(String input, List<String> expected) {
		assertThat(StringAddCalculator.captureNumbers(input)).isEqualTo(expected);
	}

	@DisplayName("패턴에 알맞지 않은 문자열 입력은 처리를 실패한다.")
	@ParameterizedTest(name = "입력: \"{0}\"")
	@ValueSource(strings = {"a", "-1", "//;\\n1=2"})
	void captureNumbers_InvalidPattern_ExceptionThrown(String input) {
		assertThatExceptionOfType(InvalidPatternException.class).isThrownBy(() -> {
			StringAddCalculator.captureNumbers(input);
		});
	}

	private static Stream<Arguments> sum() {
		return Stream.of(
			Arguments.of(Collections.singletonList("1"), 1),
			Arguments.of(Arrays.asList("1", "2"), 3),
			Arguments.of(Arrays.asList("5", "11"), 16)
		);
	}

	@DisplayName("문자열 목록을 더한다.")
	@ParameterizedTest(name = "입력: \"{0}\", 합: \"{1}\"")
	@MethodSource
	void sum(List<String> input, int expected) {
		assertThat(StringAddCalculator.sum(input)).isEqualTo(expected);
	}
}
