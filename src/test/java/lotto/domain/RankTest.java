package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    public static Stream<Arguments> provideCountAndRank() {
        return Stream.of(
                Arguments.of(0, false, Rank.NON_MATCH),
                Arguments.of(0, true, Rank.NON_MATCH),
                Arguments.of(1, false, Rank.NON_MATCH),
                Arguments.of(1, true, Rank.NON_MATCH),
                Arguments.of(2, false, Rank.NON_MATCH),
                Arguments.of(2, true, Rank.NON_MATCH),
                Arguments.of(3, false, Rank.NON_MATCH),
                Arguments.of(3, true, Rank.NON_MATCH),
                Arguments.of(4, false, Rank.FORTH),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(6, false, Rank.FIRST)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCountAndRank")
    void match_rank_by_count(int count, boolean matchBonus, Rank rank) {
        assertThat(Rank.match(count, matchBonus)).isEqualTo(rank);
    }

    @Test
    void calculate_prize() {
        assertThat(Rank.SECOND.calculatePrize(2)).isEqualTo(Rank.SECOND.getPrize() * 2);
    }
}
