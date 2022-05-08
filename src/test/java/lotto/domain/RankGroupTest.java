package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RankGroupTest {

    @Test
    @DisplayName("당첨금 테스트")
    void winningPrizeTest() {
        RankGroup rankGroup = new RankGroup(Arrays.asList(Rank.FIRST, Rank.SECOND));
        assertThat(rankGroup.sumMoney()).isEqualTo(2001500000);
    }

    @Test
    @DisplayName("1등이 1개 2등이 2개 당첨된다")
    void rankGroupTest() {
        RankGroup rankGroup = new RankGroup(Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.SECOND));

        assertThat(rankGroup.getCountOfMatchCount(5)).isEqualTo(2);
        assertThat(rankGroup.getCountOfMatchCount(6)).isEqualTo(1);
    }


    @Test
    @DisplayName("수익률 테스트")
    void returnMoneyPercentage() {
        RankGroup rankGroup = new RankGroup(Arrays.asList(Rank.FOURTH, Rank.NO_MATCH, Rank.NO_MATCH, Rank.NO_MATCH));

        assertThat(rankGroup.returnMoneyPercentage(4000)).isEqualTo(1.25);
    }
}
