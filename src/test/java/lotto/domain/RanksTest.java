package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RanksTest {

    @Test
    @DisplayName("당첨금 테스트")
    void winningPrizeTest() {
        Ranks ranks = new Ranks(Arrays.asList(Rank.FIRST, Rank.THIRD));
        assertThat(ranks.sumMoney()).isEqualTo(2001500000);
    }

    @Test
    @DisplayName("수익률 테스트")
    void returnMoneyPercentage() {
        Ranks ranks = new Ranks(Arrays.asList(Rank.FIFTH, Rank.NO_MATCH, Rank.NO_MATCH, Rank.NO_MATCH));
        assertThat(ranks.returnMoneyPercentage(new Pay(4000))).isEqualTo(1.25);
    }

    @Test
    @DisplayName("등수 카운팅 테스트")
    void getRankingTest() {
        Ranks ranks = new Ranks(Arrays.asList(Rank.SECOND, Rank.THIRD, Rank.THIRD, Rank.THIRD));
        assertThat(ranks.getCountOf(Rank.SECOND)).isEqualTo(1);
        assertThat(ranks.getCountOf(Rank.THIRD)).isEqualTo(3);
    }
}
