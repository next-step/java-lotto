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
	void from(int countOfMatch, boolean matchBonus, Rank expectedRank) {
		// when
		Rank rank = Rank.from(countOfMatch, matchBonus);

		// then
		assertThat(rank).isEqualTo(expectedRank);
	}

	@DisplayName("from() 메서드 호출시 지정된 범위의 값이 아닐 경우 예외를 던진다.")
	@ParameterizedTest(name = "{index}. countOfMatch : {0}")
	@ValueSource(ints = {Rank.MIN_OF_MATCH - 1, Rank.MAX_OF_MATCH + 1})
	void fromException(int countOfMatch) {
		// given
		boolean matchBonus = false;

		// when then
		assertThatExceptionOfType(RankMatchCountSizeException.class)
			.isThrownBy(() -> Rank.from(countOfMatch, matchBonus));
	}

	private static Stream<Arguments> provideCountOfMatchWithRank() {
		return Stream.of(
			arguments(0, false, Rank.MISS),
			arguments(1, false, Rank.MISS),
			arguments(2, false, Rank.MISS),
			arguments(3, false, Rank.FIFTH),
			arguments(4, false, Rank.FOURTH),
			arguments(5, false, Rank.THIRD),
			arguments(5, true, Rank.SECOND),
			arguments(6, false, Rank.FIRST)
		);
	}
}
