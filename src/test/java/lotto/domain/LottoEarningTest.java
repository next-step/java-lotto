package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoEarningTest {
    @Test
    @DisplayName("당첨 결과를 통해 수익과 수익률을 계산한다.")
    void calculateTotalEarningTest() {
        Map<Rank, Integer> lottoResult = Map.of(
                Rank.THREE_MATCH, 2,
                Rank.FOUR_MATCH, 1,
                Rank.FIVE_MATCH, 1
        );
        int purchasePrice = 5000;

        LottoEarning lottoEarning = LottoEarning.from(lottoResult, purchasePrice);

        // 수익
        int expectProfit = Rank.THREE_MATCH.getPrize() * 2 + Rank.FOUR_MATCH.getPrize() + Rank.FIVE_MATCH.getPrize();
        assertEquals(expectProfit, lottoEarning.getProfit());

        // 수익률
        double expectReturnRate = (double) expectProfit / purchasePrice;
        assertEquals(expectReturnRate, lottoEarning.getReturnRate());
    }

}
