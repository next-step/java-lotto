package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RankResultsTest {

    @Test
    @DisplayName("수익률을 구한다")
    void calculateProfitRatio() {
        //given
        Money principal = new Money(100000);
        List<RankResult> rankResultList = List.of(
                new RankResult(Rank.FIRST, 0),
                new RankResult(Rank.SECOND, 0),
                new RankResult(Rank.THIRD, 1),
                new RankResult(Rank.FOURTH, 1)
        );

        RankResults rankResults = new RankResults(rankResultList);

        //when
        double profitRatio = rankResults.calculateProfitRatio(principal);

        //then
        assertThat(profitRatio).isEqualTo(15.5);
    }
}