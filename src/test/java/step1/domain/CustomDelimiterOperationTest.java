package step1.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step1.domain.collections.Numbers;
import step1.exception.StringAdderException;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomDelimiterOperationTest {

	@DisplayName("객체 생성 테스트")
	@ParameterizedTest
	@MethodSource("provideConstructSource")
	void testConstruction(Pattern customDelimiter, String input, Numbers expect) {
		assertThat(new CustomDelimiterOperation(customDelimiter, input)).isEqualTo(new CustomDelimiterOperation(expect));
	}

	@DisplayName("객체 생성 실패 테스트")
	@ParameterizedTest
	@MethodSource("provideFailConstructSource")
	void testFailConstruction(Pattern customDelimiter, String input) {
		assertThrows(StringAdderException.class, () -> new CustomDelimiterOperation(customDelimiter, input));
	}

	@DisplayName("문자열 합 검증 테스트")
	@ParameterizedTest
	@MethodSource("provideSumSource")
	void testSum(Pattern customDelimiter, String input, int expect) {
		assertThat(new CustomDelimiterOperation(customDelimiter, input).sum()).isEqualTo(expect);
	}

	private static Stream<Arguments> provideConstructSource() {
		List<Number> numbers = List.of(new Number(1), new Number(2));
		List<Number> numbers2 = List.of(new Number(4), new Number(1), new Number(3));

		return Stream.of(
				Arguments.of(Pattern.compile("~"), "1~2", new Numbers(numbers)),
				Arguments.of(Pattern.compile("@"), "4@1@3", new Numbers(numbers2))
		);
	}

	private static Stream<Arguments> provideFailConstructSource() {
		List<Number> numbers = List.of(new Number(1), new Number(2));
		List<Number> numbers2 = List.of(new Number(4), new Number(1), new Number(3));

		return Stream.of(
				Arguments.of(Pattern.compile("~"), "1(2"),
				Arguments.of(Pattern.compile("@"), "4^1%3")
		);
	}

	private static Stream<Arguments> provideSumSource() {
		return Stream.of(
				Arguments.of(Pattern.compile("~"), "1~2", 3),
				Arguments.of(Pattern.compile("@"), "4@1@3", 8)
		);
	}
}