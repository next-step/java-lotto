package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProfitTest {

    private static final int PURCHASE_AMOUNT = 4000;

    @Test
    @DisplayName("1등에서 5등까지 모든 상금을 받음")
    void testLottoProfitChecker_AllPrizes_ShouldReturnCorrectProfits() {
        // given, when
        PurchaseAmount purchaseAmount = new PurchaseAmount(PURCHASE_AMOUNT);
        LottoProfit lottoProfit = new LottoProfit(getAllWinLotto());
        BigDecimal profitRatio = lottoProfit.getProfitRatio(purchaseAmount);

        // then
        assertThat(profitRatio).isEqualTo(BigDecimal.valueOf(507887.50).setScale(2));
    }

    @Test
    @DisplayName("꼴등의 상금, 즉, 0원을 받음")
    void testLottoProfitChecker_NoPrize_ShouldReturnCorrectZeroProfit() {
        // given, when
        PurchaseAmount purchaseAmount = new PurchaseAmount(PURCHASE_AMOUNT);
        EnumMap<PrizeEnum, Integer> prize = new EnumMap<>(PrizeEnum.class){{
            put(PrizeEnum.MISS, 1);
        }};
        LottoProfit lottoProfit = new LottoProfit(prize);
        BigDecimal profit = lottoProfit.getProfitRatio(purchaseAmount);

        // then
        assertThat(profit).isEqualTo(BigDecimal.ZERO.setScale(2));
    }

    private Map<PrizeEnum, Integer> getAllWinLotto() {
        Map<PrizeEnum, Integer> lottos = new EnumMap<>(PrizeEnum.class);

        lottos.put(PrizeEnum.FIRST, 1);
        lottos.put(PrizeEnum.SECOND, 1);
        lottos.put(PrizeEnum.THIRD, 1);
        lottos.put(PrizeEnum.FOURTH, 1);
        lottos.put(PrizeEnum.FIRST, 1);

        return lottos;
    }

}
