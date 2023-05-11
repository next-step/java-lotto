package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @Test
    @DisplayName("로또 구매 금액과 당첨 금액을 입력하면 수익률을 계산한다")
    void calculateProfitRate() {
        // given
        int purchaseAmount = 10000;
        int winningMoney = 20000;

        // when
        float profitRate = LottoStatistics.calculateProfitRate(purchaseAmount, winningMoney);

        // then
        assertThat(profitRate).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 결과를 입력하면 총 당첨 금액을 계산한다")
    void sumOfLottoResult() {
        // given
        LottoResult lottoResult1 = LottoResult.FORTH;
        LottoResult lottoResult2 = LottoResult.FORTH;

        // when
        int sumOfLottoResult = LottoStatistics.sumOfLottoResult(List.of(lottoResult1, lottoResult2));

        // then
        assertThat(sumOfLottoResult).isEqualTo(100000);
    }

}