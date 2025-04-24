package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private static final int LOTTO_PRICE = 1_000;

    @Test
    public void testRank() {
        // when
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(4,5,16,7,8,9));
        Lotto lotto3 = new Lotto(List.of(1,2,3,4,5,11));
        Lottos lottos = new Lottos(List.of(lotto,lotto2,lotto3));
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,16));
        int bonusNumber = 6;

        // given
        LottoResult result = lottos.rankCounts(winningLotto, bonusNumber, LOTTO_PRICE);

        // then
        assertThat(result.rankCount(Rank.SECOND)).isEqualTo(1);
        assertThat(result.rankCount(Rank.THIRD)).isEqualTo(1);
        assertThat(result.rankCount(Rank.FIFTH)).isEqualTo(1);
        assertThat(result.totalInvestment()).isEqualTo(lottos.count()*LOTTO_PRICE);

        int expectedPrize = Rank.SECOND.getWinningMoney() + Rank.THIRD.getWinningMoney() + Rank.FIFTH.getWinningMoney();
        assertThat(result.totalPrize()).isEqualTo(expectedPrize);
    }


}
