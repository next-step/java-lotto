package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @MethodSource("provideLottoWithRankResult")
    void valueOf_n개일치_m위(int matchCount, boolean matchBonus,Rank rank) {
        assertThat(Rank.valueOf(matchCount, matchBonus)).isEqualTo(rank);
    }

    static Stream<Arguments> provideLottoWithRankResult() {
        return Stream.of(
                Arguments.of(6, true, Rank.FIRST),
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, true, Rank.FOURTH),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(3, true, Rank.FIFTH),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(2, true, Rank.MISS),
                Arguments.of(2, false, Rank.MISS),
                Arguments.of(1, true, Rank.MISS),
                Arguments.of(1, false, Rank.MISS),
                Arguments.of(0, true, Rank.MISS),
                Arguments.of(0, false, Rank.MISS)
        );
    }
}
