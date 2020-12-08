package com.woowahan.calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {

	@DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환")
	@ParameterizedTest
	@NullAndEmptySource
	void nullOrEmpty(String input) {

		int expected = 0;

		assertSplitAndSumMethod(input, expected);
	}

	@DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
	@ParameterizedTest
	@CsvSource({"1,1", "2,2", "3,3"})
	void singleNumber(String input, int expected) {

		assertSplitAndSumMethod(input, expected);

	}

	@DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환")
	@ParameterizedTest
	@MethodSource("argSplitComma")
	void splitComma(String input, int expected) {

		assertSplitAndSumMethod(input, expected);
	}

	public static Stream<Arguments> argSplitComma() {
		return Stream.of(
			Arguments.of("0,0", 0),
			Arguments.of("0,5", 5),
			Arguments.of("3,5", 8),
			Arguments.of("10,100", 110)
		);
	}

	@DisplayName("구분자를 컴마(,)와 콜론(:)을 함께 사용해도 합이 반환됨")
	@ParameterizedTest
	@MethodSource("argSplitCommaAndColon")
	void splitCommaAndColon(String input, int expected) {

		assertSplitAndSumMethod(input, expected);

	}

	public static Stream<Arguments> argSplitCommaAndColon() {
		return Stream.of(
			Arguments.of("0,1:2", 3),
			Arguments.of("1:2,3", 6),
			Arguments.of("1:2:3,4", 10),
			Arguments.of("1:2,3,4", 10),
			Arguments.of("1,2:3:4", 10)
		);
	}

	@DisplayName("'//'와 '\\n' 문자 사이에 커스텀 구분자를 지정")
	@ParameterizedTest
	@MethodSource("argCustomDelimiter")
	void splitCustomDelimiter(String input, int expected) {

		assertSplitAndSumMethod(input, expected);

	}

	public static Stream<Arguments> argCustomDelimiter() {
		return Stream.of(
			Arguments.of("//@\n0@1@2", 3),
			Arguments.of("//!\n1!2!3", 6),
			Arguments.of("//#\n3#4#5", 12)
		);
	}

	@DisplayName("문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,-3", "1,-2,-3", "-1,-2,-3", "a,2,3", "1,a,3", "1,2,a", "a,b,c", "-1,-2,a"})
	void passNaNOrNegative(String input) {
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> {
				StringAddCalculator.splitAndSum(input);
			}).withMessage(ValidationUtil.MSG_NOT_A_NUMBER_OR_NEGATIVE);
	}

	private void assertSplitAndSumMethod(String input, int expected) {
		int result = StringAddCalculator.splitAndSum(input);
		assertThat(result).isEqualTo(expected);
	}
}