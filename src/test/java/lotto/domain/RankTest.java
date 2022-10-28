package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.NO_MATCH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;


class RankTest {

    @ParameterizedTest
    @MethodSource
    void 랭킹_생성(int countOfMatch, boolean isMatchBonus, Rank rank) {
        Assertions.assertThat(Rank.of(countOfMatch, isMatchBonus)).isEqualTo(rank);
    }

    private static Stream<Arguments> 랭킹_생성() {
        return Stream.of(
                Arguments.of(6, false, FIRST),
                Arguments.of(5, true, SECOND),
                Arguments.of(5, false, THIRD),
                Arguments.of(4, true, FOURTH),
                Arguments.of(4, false, FOURTH),
                Arguments.of(3, true, FIFTH),
                Arguments.of(3, false, FIFTH),
                Arguments.of(2, true, NO_MATCH),
                Arguments.of(2, false, NO_MATCH),
                Arguments.of(0, true, NO_MATCH),
                Arguments.of(0, false, NO_MATCH)
        );
    }
}
