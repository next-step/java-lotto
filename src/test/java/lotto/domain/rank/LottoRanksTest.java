package lotto.domain.rank;

import lotto.domain.Constant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

class LottoRanksTest {

    @DisplayName("당첨 내역들로부터 수익률을 계산 할 수 있다")
    @Test
    public void getProfitRateTest() {
        List<LottoRank> results = Arrays.asList(LottoRank.THREE, LottoRank.TWO, LottoRank.TWO);
        LottoRanks lottoRanks = LottoRanks.of(results);

        int threeWinningPrize = LottoRank.THREE.getWinningPrize();

        BigDecimal winningPrizeTotal = BigDecimal.valueOf(threeWinningPrize);
        BigDecimal paidMoney = BigDecimal.valueOf(Constant.PRICE_PER_GAME * results.size());
        float expectedProfitRate = winningPrizeTotal.divide(paidMoney, 2, BigDecimal.ROUND_CEILING).floatValue();

        float profitRate = lottoRanks.getProfitRate();

        Assertions.assertThat(profitRate).isEqualTo(expectedProfitRate);
    }

}
