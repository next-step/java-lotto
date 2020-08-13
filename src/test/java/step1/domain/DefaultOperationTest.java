package step1.domain;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.domain.collections.Numbers;
import step1.exception.StringAdderException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DefaultOperationTest {

	@ParameterizedTest
	@MethodSource("provideConstructSource")
	void testConstruction(String input, Numbers expect) {
		assertThat(new DefaultOperation(input)).isEqualTo(new DefaultOperation(expect));
	}

	@ParameterizedTest
	@ValueSource(strings = {"1&2", "a,b,c"})
	void testFailConstruction(String input) {
		assertThrows(StringAdderException.class, () -> new DefaultOperation(input));
	}

	@ParameterizedTest
	@MethodSource("provideSumSource")
	void testSum(String input, int expect) {
		assertThat(new DefaultOperation(input).sum()).isEqualTo(expect);
	}

	private static Stream<Arguments> provideConstructSource() {
		List<Number> numbers = List.of(new Number(1), new Number(2));
		List<Number> numbers2 = List.of(new Number(4), new Number(1), new Number(3));

		return Stream.of(
				Arguments.of("1:2", new Numbers(numbers)),
				Arguments.of("4,1,3", new Numbers(numbers2))
		);
	}

	private static Stream<Arguments> provideSumSource() {
		return Stream.of(
				Arguments.of("1:2", 3),
				Arguments.of("4,1,3", 8)
		);
	}
}