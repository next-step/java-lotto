package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @ParameterizedTest
    @MethodSource("rankCheck")
    @DisplayName("일치하는 개수에 따라 등수가 정해진다.")
    void matchNumber_getRank(int matchCount, Rank rankCheck, boolean hasBonusBall) {
        Rank rank = Rank.valueOf(matchCount, hasBonusBall);
        assertThat(rank).isEqualTo(rankCheck);
    }

    @Test
    @DisplayName("수익률 계산")
    void buyLotto_purchaseMoney_percent_test() {
        Rank rank = Rank.valueOf(1, false);
        EnumMap<Rank, Integer> rankIntegerEnumMap = new EnumMap<>(
            Map.of(
                rank, 1,
                Rank.FIFTH, 1
            )
        );

        double yield = Rank.yield(rankIntegerEnumMap, 1000);

        assertThat(yield).isEqualTo(5);
    }

    private static Stream<Arguments> rankCheck() {
        return Stream.of(
            Arguments.of(0, Rank.LOSER, false),
            Arguments.of(3, Rank.FIFTH, false),
            Arguments.of(4, Rank.FOURTH, false),
            Arguments.of(5, Rank.THIRD, false),
            Arguments.of(5, Rank.SECOND, true),
            Arguments.of(6, Rank.FIRST, false)
        );
    }
}