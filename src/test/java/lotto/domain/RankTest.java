package lotto.domain;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RankTest {

	@DisplayName("로또의 등수를 확인한다.")
	@ParameterizedTest
	@MethodSource("matchNumAndRank")
	void match_rank(int matchNum, Rank rank) {
		Assertions.assertThat(Rank.matchRank(matchNum)).isEqualTo(rank);
	}

	static Stream<Arguments> matchNumAndRank() {
		return Stream.of(
			Arguments.arguments(6, Rank.FIRST),
			Arguments.arguments(5, Rank.SECOND),
			Arguments.arguments(4, Rank.THIRD),
			Arguments.arguments(3, Rank.FOURTH),
			Arguments.arguments(2, Rank.NOT),
			Arguments.arguments(1, Rank.NOT),
			Arguments.arguments(0, Rank.NOT)
		);
	}
}
