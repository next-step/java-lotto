package autoLotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProfitCheckerTest {

    private static final int NUMBER_OF_TOTAL_LOTTOS = 4;

    @Test
    @DisplayName("1등에서 5등까지 모든 상금을 받음")
    void testLottoProfitChecker_AllPrizes_ShouldReturnCorrectProfits() {
        // given, when
        LottoProfitChecker lottoProfitChecker = new LottoProfitChecker(getAllWinLotto());
        BigDecimal profitRatio = lottoProfitChecker.getProfitRatio(NUMBER_OF_TOTAL_LOTTOS);

        // then
        assertThat(profitRatio).isEqualTo(BigDecimal.valueOf(507887.50).setScale(2));
    }

    @Test
    @DisplayName("꼴등의 상금, 즉, 0원을 받음")
    void testLottoProfitChecker_NoPrize_ShouldReturnCorrectZeroProfit() {
        // given, when
        EnumMap<PrizeEnum, Integer> prize = new EnumMap<>(PrizeEnum.class){{
            put(PrizeEnum.MISS, 1);
        }};
        LottoProfitChecker lottoProfitChecker = new LottoProfitChecker(prize);
        BigDecimal profit = lottoProfitChecker.getProfitRatio(NUMBER_OF_TOTAL_LOTTOS);

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

    private BigDecimal getAllWinPrizes() {
        BigDecimal totalWinAmount = BigDecimal.ZERO;
        Map<PrizeEnum, Integer> lottos = getAllWinLotto();

        for (PrizeEnum prize : lottos.keySet()) {
            BigDecimal prizeResult = BigDecimal.valueOf(prize.getPrize());
            totalWinAmount = totalWinAmount.add(prizeResult);
        }

        return totalWinAmount;
    }

}
