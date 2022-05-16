package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RankResultsTest {

    @ParameterizedTest
    @CsvSource(value ={"10000:200", "20000:100", "40000:50"}, delimiter = ':')
    @DisplayName("금액 대비 수익률을 반환한다")
    void profitRatioTest(int money, double ratio) {
        List<RankResult> rankResultList = List.of(
                new RankResult(Rank.FIRST, 0),
                new RankResult(Rank.THIRD, 1),
                new RankResult(Rank.FOURTH, 9),
                new RankResult(Rank.FIFTH, 10)
        );

        RankResults rankResults = new RankResults(rankResultList);
        double profitRatio = rankResults.getProfitRatio(new Money(money));

        assertThat(profitRatio).isEqualTo(ratio);
    }

    @Test
    @DisplayName("RankResult 리스트를 반환")
    void getRankResultListTest() {
        List<RankResult> rankResultList = List.of(
                new RankResult(Rank.FIRST, 0),
                new RankResult(Rank.THIRD, 1),
                new RankResult(Rank.FOURTH, 9),
                new RankResult(Rank.FIFTH, 10)
        );

        RankResults rankResults = new RankResults(rankResultList);

        assertThat(rankResults.getRankResultList()).isEqualTo(rankResultList);
    }
}