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
    void match_rank(int matchNum, boolean isMatchBonusNum, Rank rank) {
        Assertions.assertThat(Rank.matchRank(matchNum, isMatchBonusNum)).isEqualTo(rank);
    }

    static Stream<Arguments> matchNumAndRank() {
        return Stream.of(
            Arguments.arguments(6, false, Rank.FIRST),
            Arguments.arguments(5, true, Rank.SECOND),
            Arguments.arguments(5, false, Rank.THIRD),
            Arguments.arguments(4, false, Rank.FOURTH),
            Arguments.arguments(3, false, Rank.FIFTH),
            Arguments.arguments(2, false, Rank.NOT),
            Arguments.arguments(1, false, Rank.NOT),
            Arguments.arguments(0, false, Rank.NOT)
        );
    }
}
