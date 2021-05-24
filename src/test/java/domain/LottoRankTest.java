package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoRankTest {

    @DisplayName("당첨 결과에 따른 당첨 금액을 구한다")
    @ParameterizedTest
    @CsvSource(value = {"3,5000,false", "4,50000,false", "5,1500000,false", "5,30000000,true", "6,2000000000,false"})
    public void findRank(int winningCount, int expectedReward, boolean matchBonus) {
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
        assertThat(rewardRatio).isEqualTo(0.35);
    }

    @Test
    @DisplayName("보너스 당첨 2등을 확인한다. (2등: 5개 일치 + 보너스볼)")
    public void secondRank() {
        //given
        int winningCount = 5;
        boolean matchBonus = true;

        //when
        LottoRank lottoRank = LottoRank.getLottoRank(winningCount, matchBonus);

        //then
        assertThat(lottoRank).isEqualTo(LottoRank.FIVE_WITH_BONUS);

    }
}
