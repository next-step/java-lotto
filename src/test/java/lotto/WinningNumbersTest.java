package lotto;

import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class WinningNumbersTest {

	@DisplayName("특정 숫자를 포함하고 있는지 확인한다")
	@ParameterizedTest
	@MethodSource("containsArguments")
	void contains(Set<Integer> numbers, int number, boolean expected) {
		boolean contains = new WinningNumbers(numbers).contains(number);
		assertThat(contains).isEqualTo(expected);
	}

	private static Stream<Arguments> containsArguments() {
		return Stream.of(
				Arguments.of(Stream.of(1, 2, 3, 4, 5, 6).collect(toSet()), 1, true),
				Arguments.of(Stream.of(1, 2, 3, 4, 5, 6).collect(toSet()), 7, false)
		);
	}
}
