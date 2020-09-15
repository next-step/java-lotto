package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    @Test
    @DisplayName("add rank test")
    public void addRankTest(){
        Winners winners = new Winners();

        winners.addRank(Rank.FIRST);
        winners.addRank(Rank.SECOND);
        winners.addRank(Rank.SECOND);
        winners.addRank(Rank.THIRD);
        winners.addRank(Rank.THIRD);
        winners.addRank(Rank.THIRD);

        assertThat(winners.getWinnersCount(Rank.FIRST)).isEqualTo(Count.of(1));
        assertThat(winners.getWinnersCount(Rank.SECOND)).isEqualTo(Count.of(2));
        assertThat(winners.getWinnersCount(Rank.THIRD)).isEqualTo(Count.of(3));
        assertThat(winners.getWinnersCount(Rank.FOURTH)).isEqualTo(Count.ZERO);
        assertThat(winners.getWinnersCount(Rank.FIFTH)).isEqualTo(Count.ZERO);
        assertThat(winners.getWinnersCount(Rank.MISS)).isEqualTo(Count.ZERO);
        assertThat(winners.getSize()).isEqualTo(6);
    }

    @Test
    @DisplayName("calc winner Prize test")
    public void calcWinnerPrizeTest(){
        Winners winners = new Winners();

        winners.addRank(Rank.FIRST);
        winners.addRank(Rank.SECOND);

        assertThat(winners.calcWinnerPrize()).isEqualTo(Rank.FIRST.getWinningMoney().add(Rank.SECOND.getWinningMoney())  );
    }
}