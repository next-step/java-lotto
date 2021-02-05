package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("of()로 각각의 Rank 가져오기")
    @MethodSource("getRankParameterSources")
    @ParameterizedTest
    void of(int count, boolean containsBonusBall, Rank expectedRank) {
        // given & when
        Rank rank = Rank.of(count, containsBonusBall);

        // then
        assertThat(rank).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> getRankParameterSources() {
        return Stream.of(
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(6, false, Rank.FIRST)
        );
    }

    @DisplayName("Rank의 모든 상수들을 등수의 오름차순으로 가져오기(NONE 제외)")
    @Test
    void getValuesAscendingOrder() {
        // given & when
        List<Rank> ranksAscendingOrder = Rank.getValuesAscendingOrder();

        // then
        assertThat(ranksAscendingOrder.get(0)).isEqualTo(Rank.FIFTH);
        assertThat(ranksAscendingOrder.get(1)).isEqualTo(Rank.FOURTH);
        assertThat(ranksAscendingOrder.get(2)).isEqualTo(Rank.THIRD);
        assertThat(ranksAscendingOrder.get(3)).isEqualTo(Rank.SECOND);
        assertThat(ranksAscendingOrder.get(4)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("Rank 상수별로 count를 받아 총 상금을 리턴")
    @Test
    void getTotalPrizeByCount() {
        // given & when
        BigDecimal firstRanksTotalPrize = Rank.FIRST.getTotalPrizeByCount(1);
        BigDecimal secondRanksTotalPrize = Rank.SECOND.getTotalPrizeByCount(3);

        // then
        assertThat(firstRanksTotalPrize).isEqualTo(BigDecimal.valueOf(2_000_000_000L));
        assertThat(secondRanksTotalPrize).isEqualTo(BigDecimal.valueOf(90_000_000L));
    }
}