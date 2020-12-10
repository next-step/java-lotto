package com.woowahan.lotto.util;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationUtilTest {

	@DisplayName("isNotNumber 메소드는 숫자가 아닌 문자 또는 null 또는 empty를 입력하면 true를 반환한다.")
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"a", "!", "a3517"})
	void isNotNumber(String input) {

		boolean expected = true;
		boolean result = ValidationUtil.isNotNumber(input);

		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("isZeroOrNegative 메소드는 0또는 음수 문자를 입력하면 true를 반환한다. 아니면 false를 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"0:true", "-1:true", "-100:true", "1:false", "100:false"}, delimiter = ':')
	void isZeroOrNegative(String input, boolean expected) {

		boolean result = ValidationUtil.isZeroOrNegative(input);

		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("existRemainder 메소드는 value 파라미터에 divider로 나눈 나머지가 0아 아니면 true를 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"1000:100:false", "1000:11:true", "-100:1000:true"}, delimiter = ':')
	void existRemainder(int value, int divider, boolean expected) {

		boolean result = ValidationUtil.existRemainder(value, divider);

		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("isNullOrEmpty 메소드는 전달되는 null 또는 empty면 true를 반환한다.")
	@ParameterizedTest
	@NullAndEmptySource
	void hasNotNumber(String input) {

		boolean expected = true;
		boolean result = ValidationUtil.isNullOrEmpty(input);

		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("hasNotNumber 메소드는 전달되는 List<String>객체에 숫자가 아닌 문자 또는 null 또는 empty가 포함되어 있으면 true를 반환한다.")
	@ParameterizedTest
	@MethodSource("argHasNotNumber")
	void hasNotNumber(List<String> input, boolean expected) {

		boolean result = ValidationUtil.hasNotNumber(input);

		assertThat(result).isEqualTo(expected);
	}

	public static Stream<Arguments> argHasNotNumber() {
		return Stream.of(
			Arguments.of(Arrays.asList(null, "1", "5", "7", "9", "10"), true),
			Arguments.of(Arrays.asList("", "1", "5", "7", "9", "10"), true),
			Arguments.of(Arrays.asList("1", "a", "5", "7", "9", "10"), true),
			Arguments.of(Arrays.asList("1", "3", "5", "7", "9", ""), true),
			Arguments.of(Arrays.asList("1", "3", "5", "7", "9", "10"), false)
		);
	}

	@DisplayName("hasWrongNumber 메소드는 전달되는 List<String>객체가 null이거나 해당 요소의 문자를 숫자로 변환한 수가 1 ~ 45사이가 아닌 경우 true를 반환한다.")
	@ParameterizedTest
	@MethodSource("argHasWrongNumber")
	void hasWrongNumber(List<String> numbers, boolean expected) {

		boolean result = ValidationUtil.hasWrongNumber(numbers);

		assertThat(result).isEqualTo(expected);
	}

	public static Stream<Arguments> argHasWrongNumber() {
		return Stream.of(
			Arguments.of(Arrays.asList("1", "5", "7", "9", "10", "46"), true),
			Arguments.of(Arrays.asList("0", "5", "7", "9", "10", "45"), true),
			Arguments.of(Arrays.asList("-5", "5", "7", "9", "10", "45"), true),
			Arguments.of(null, true),
			Arguments.of(Arrays.asList("1", "5", "7", "9", "10", "45"), false)
		);
	}

}