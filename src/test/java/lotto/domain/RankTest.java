package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.math.BigDecimal;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @ParameterizedTest
    @MethodSource("testNumbersWithBonus")
    void setting_rank_map_test(int matchingCount, boolean containBonusNumber, Prize prize) {
        Rank rank = new Rank();
        rank.settingRank(matchingCount, containBonusNumber);
        assertThat(rank.findRank(prize)).isOne();
    }

    @DisplayName("구매금액과 당첨금액의 수익금 계산 테스트")
    @ParameterizedTest
    @MethodSource("yieldTestParameters")
    public void yield_test(BigDecimal purchasePrice, Rank rank, double expectYield) {
        double yield = rank.calculateYield(purchasePrice);
        assertThat(yield).isEqualTo(expectYield,  withPrecision(0.01));
    }

    static Stream<Arguments> testNumbersWithBonus() {
        return Stream.of(
                arguments(6, true, Prize.RANK_1TH),
                arguments(5, false, Prize.RANK_2TH),
                arguments(5, true, Prize.RANK_2TH_WITH_BONUS),
                arguments(4, false, Prize.RANK_3TH)
        );
    }

    static Stream<Arguments> yieldTestParameters() {
        return Stream.of(
                arguments(BigDecimal.valueOf(1000L), initRank(4, false), 50.0),
                arguments(BigDecimal.valueOf(14000L), initRank(5, false), 107.142),
                arguments(BigDecimal.valueOf(1000L), initRank(5, true), 30000.0),
                arguments(BigDecimal.valueOf(14000L), initRank(6, false), 142857.14)
        );
    }

    private static Rank initRank(int matchingCount, boolean containBouns) {
        Rank rank = new Rank();
        rank.settingRank(matchingCount, containBouns);
        return rank;
    }

}
