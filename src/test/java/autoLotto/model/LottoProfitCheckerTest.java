package autoLotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProfitCheckerTest {

    private static final Long PURCHASE_AMOUNT = 4000L;

    @Test
    @DisplayName("1등에서 5등까지 모든 상금을 받음")
    void testLottoProfitChecker_AllPrizes_ShouldReturnCorrectProfits() {
        // given, when
        LottoProfitChecker lottoProfitChecker = new LottoProfitChecker(getAllWinLotto());
        BigDecimal profitRatio = lottoProfitChecker.getProfitRatio(PURCHASE_AMOUNT);

        // then
        BigDecimal allWinPrizes = getAllWinPrizes();
        BigDecimal purchaseAmount = BigDecimal.valueOf(PURCHASE_AMOUNT);
        assertThat(profitRatio).isEqualTo(allWinPrizes.divide(purchaseAmount, 2, RoundingMode.DOWN));
    }

    @Test
    @DisplayName("꼴등의 상금, 즉, 0원을 받음")
    void testLottoProfitChecker_NoPrize_ShouldReturnCorrectZeroProfit() {
        // given, when
        HashMap<PrizeEnum, Integer> prize = new HashMap<>(){{
            put(PrizeEnum.MISS, 1);
        }};
        LottoProfitChecker lottoProfitChecker = new LottoProfitChecker(prize);
        BigDecimal profit = lottoProfitChecker.getProfitRatio(PURCHASE_AMOUNT);

        // then
        assertThat(profit).isEqualTo(BigDecimal.ZERO.setScale(2));
    }

    private HashMap<PrizeEnum, Integer> getAllWinLotto() {
        HashMap<PrizeEnum, Integer> lottos = new HashMap<>();

        lottos.put(PrizeEnum.FIRST, 1);
        lottos.put(PrizeEnum.SECOND, 1);
        lottos.put(PrizeEnum.THIRD, 1);
        lottos.put(PrizeEnum.FOURTH, 1);
        lottos.put(PrizeEnum.FIRST, 1);

        return lottos;
    }

    private BigDecimal getAllWinPrizes() {
        BigDecimal totalWinAmount = BigDecimal.ZERO;
        HashMap<PrizeEnum, Integer> lottos = getAllWinLotto();

        for (PrizeEnum prize : lottos.keySet()) {
            BigDecimal prizeResult = BigDecimal.valueOf(prize.getPrize());
            totalWinAmount = totalWinAmount.add(prizeResult);
        }

        return totalWinAmount;
    }

}
