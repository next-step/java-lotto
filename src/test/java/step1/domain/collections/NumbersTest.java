package step1.domain.collections;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step1.domain.Number;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

	@ParameterizedTest
	@MethodSource("provideConstructSource")
	void testConstruction(String input, Pattern delimiter, List<Number> expect) {
		assertThat(new Numbers(input, delimiter)).isEqualTo(new Numbers(expect));
	}

	@ParameterizedTest
	@MethodSource("provideSumSource")
	void testSum(String input, Pattern delimiter, Number expect) {
		assertThat(new Numbers(input, delimiter).sum()).isEqualTo(expect);
	}

	private static Stream<Arguments> provideConstructSource() {
		List<Number> numbers = List.of(new Number(1), new Number(2));
		List<Number> numbers2 = List.of(new Number(4), new Number(1), new Number(3));

		return Stream.of(
				Arguments.of("1:2", Pattern.compile(":"), numbers),
				Arguments.of("4;1;3", Pattern.compile(";"), numbers2)
		);
	}

	private static Stream<Arguments> provideSumSource() {
		return Stream.of(
				Arguments.of("1:2", Pattern.compile(":"), new Number(3)),
				Arguments.of("4;1;3", Pattern.compile(";"), new Number(8))
		);
	}

}