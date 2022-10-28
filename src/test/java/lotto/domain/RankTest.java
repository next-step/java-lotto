package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.NO_MATCH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;


class RankTest {

    @ParameterizedTest
    @MethodSource
    void 랭킹_생성(int countOfMatch, Rank rank) {
        Assertions.assertThat(Rank.of(countOfMatch)).isEqualTo(rank);
    }

    private static Stream<Arguments> 랭킹_생성() {
        return Stream.of(
                Arguments.of(6, FIRST),
                Arguments.of(5, SECOND),
                Arguments.of(4, THIRD),
                Arguments.of(3, FOURTH),
                Arguments.of(2, NO_MATCH),
                Arguments.of(1, NO_MATCH),
                Arguments.of(0, NO_MATCH)
        );
    }
}
