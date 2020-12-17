package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoRankTest {

    @DisplayName("당첨 결과에 따른 당첨 금액을 구한다")
    @ParameterizedTest
    @CsvSource(value = {"3,false,5000", "4,false,50000", "5,false,1500000", "6,false,2000000000"})
    public void findRank(int winningCount, boolean matchBonus, int expectedReward) {
        //when
        LottoRank lottoRank = LottoRank.getLottoRank(winningCount, matchBonus);

        //then
        assertEquals(expectedReward, lottoRank.getReward());
    }

    @Test
    @DisplayName("구입 금액 대비 당첨 금액에 따른 수익률을 구한다.")
    public void returnRewardRatio() {
        //given
        int purchaseAmount = 14_000;
        long totalReward = 5_000;

        //when
        double rewardRatio = LottoResult.rateCalculation(totalReward, purchaseAmount);

        //then
        assertEquals(0.35, rewardRatio);
    }

    @Test
    @DisplayName("당첨 통계에 2등도 추가해야 한다. (2등: 5개 일치 + 보너스 볼 일치")
    public void secondPrize() {
        //given
        int winningCount = 5;
        boolean matchBonus = true;

        //when
        LottoRank lottoRank = LottoRank.getLottoRank(winningCount, matchBonus);
        //then
        assertThat(lottoRank).isEqualTo(LottoRank.FIVE_WITH_BONUS);
    }
}
