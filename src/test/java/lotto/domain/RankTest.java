package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.RankMatchCountSizeException;

class RankTest {
	@DisplayName("from() 메서드를 통한 Rank 생성을 검증한다.")
	@ParameterizedTest(name = "{index}. countOfMatch : {0}, expectedRank : {1}")
	@MethodSource("provideCountOfMatchWithRank")
	void from(int countOfMatch, Rank expectedRank) {
		// when
		Rank rank = Rank.from(countOfMatch);

		// then
		assertThat(rank).isEqualTo(expectedRank);
	}

	@DisplayName("from() 메서드 호출시 지정된 범위의 값이 아닐 경우 예외를 던진다.")
	@ParameterizedTest(name = "{index}. countOfMatch : {0}")
	@ValueSource(ints = {Rank.MIN_OF_MATCH - 1, Rank.MAX_OF_MATCH + 1})
	void fromException(int countOfMatch) {
		// when then
		assertThatExceptionOfType(RankMatchCountSizeException.class)
			.isThrownBy(() -> Rank.from(countOfMatch));
	}

	private static Stream<Arguments> provideCountOfMatchWithRank() {
		return Stream.of(
			arguments(0, Rank.MISS),
			arguments(1, Rank.MISS),
			arguments(2, Rank.MISS),
			arguments(3, Rank.FORTH),
			arguments(4, Rank.THIRD),
			arguments(5, Rank.SECOND),
			arguments(6, Rank.FIRST)
		);
	}
}
