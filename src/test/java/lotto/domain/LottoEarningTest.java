package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class LottoEarningTest {
    @Test
    @DisplayName("당첨 결과를 통해 총 수익을 계산한다.")
    void calculateTotalEarningTest() {
        Map<Rank, Integer> lottoResult = Map.of(
                Rank.THREE_MATCH, 2, // 5_000 * 2
                Rank.FOUR_MATCH, 1,  // 50_000 * 1
                Rank.FIVE_MATCH, 1  // 1_500_000 * 1
        );
        int purchasePrice = 5000;

        LottoEarning lottoEarning = new LottoEarning(lottoResult, purchasePrice);

        Assertions.assertEquals(5_000 * 2 + 50_000 * 1 + 1_500_000 * 1, lottoEarning.getProfit());
    }

    @Test
    @DisplayName("당첨 결과를 통해 수익률을 계산한다.")
    void calculateReturnRateTest() {
        Map<Rank, Integer> lottoResult = Map.of(
                Rank.THREE_MATCH, 2, // 5_000 * 2
                Rank.FOUR_MATCH, 1,  // 50_000 * 1
                Rank.FIVE_MATCH, 1  // 1_500_000 * 1
        );
        int purchasePrice = 5000;

        LottoEarning lottoEarning = new LottoEarning(lottoResult, purchasePrice);

        Assertions.assertEquals((double) (5_000 * 2 + 50_000 * 1 + 1_500_000 * 1) / purchasePrice, lottoEarning.getReturnRate());
    }

}
