package lotto.enums;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PrizeTest {

	private static Stream<Arguments> toInteger() {
		return Stream.of(
			Arguments.of(Prize.ZERO, 0),
			Arguments.of(Prize.ONE, 1),
			Arguments.of(Prize.TWO, 2),
			Arguments.of(Prize.THREE, 3),
			Arguments.of(Prize.FOUR, 4),
			Arguments.of(Prize.FIVE, 5),
			Arguments.of(Prize.SIX, 6)
		);
	}

	@DisplayName("ENUM 숫자 변환")
	@ParameterizedTest(name = "입력: \"{0}\", 숫자: \"{1}\"")
	@MethodSource
	void toInteger(Prize input, int expected) {
		assertThat(input.ordinal()).isEqualTo(expected);
	}

	private static Stream<Arguments> toPrize() {
		return Stream.of(
			Arguments.of(Prize.ZERO, 0),
			Arguments.of(Prize.ONE, 0),
			Arguments.of(Prize.TWO, 0),
			Arguments.of(Prize.THREE, 5_000),
			Arguments.of(Prize.FOUR, 50_000),
			Arguments.of(Prize.FIVE, 1_500_000),
			Arguments.of(Prize.SIX, 2_000_000_000)
		);
	}

	@DisplayName("ENUM 상금 변환")
	@ParameterizedTest(name = "입력: \"{0}\", 상금: \"{1}\"")
	@MethodSource
	void toPrize(Prize input, int expected) {
		assertThat(input.getPrize()).isEqualTo(expected);
	}

	private static Stream<Arguments> toEnum() {
		return Stream.of(
			Arguments.of(0, Prize.ZERO),
			Arguments.of(1, Prize.ONE),
			Arguments.of(2, Prize.TWO),
			Arguments.of(3, Prize.THREE),
			Arguments.of(4, Prize.FOUR),
			Arguments.of(5, Prize.FIVE),
			Arguments.of(6, Prize.SIX)
		);
	}

	@DisplayName("숫자 ENUM 변환")
	@ParameterizedTest(name = "숫자: \"{0}\", ENUM: \"{1}\"")
	@MethodSource
	void toEnum(int input, Prize expected) {
		assertThat(Prize.valueOf(input)).isEqualTo(expected);
	}
}
