package com.woowahan.calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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

	private void assertSplitAndSumMethod(String input, int expected) {
		int result = StringAddCalculator.splitAndSum(input);
		assertThat(result).isEqualTo(expected);
	}
}