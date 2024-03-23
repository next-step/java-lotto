package autoLotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProfitCheckerTest {

    private static final Long PURCHASE_AMOUNT = 4000L;
    private static final float PURCHASE_AMOUNT_FLOAT = 4000f;

    private static final float ALL_WIN_PRIZES = PrizeResultEnum.getPrizeByMatchedCount(PrizeResultEnum.THREE_MATCHED.getMatchedCount())
                                                + PrizeResultEnum.getPrizeByMatchedCount(PrizeResultEnum.FOUR_MATCHED.getMatchedCount())
                                                + PrizeResultEnum.getPrizeByMatchedCount(PrizeResultEnum.FIVE_MATCHED.getMatchedCount())
                                                + PrizeResultEnum.getPrizeByMatchedCount(PrizeResultEnum.SIX_MATCHED.getMatchedCount());
    private static final float ZERO_WIN_PRIZE = 0f;

    @Test
    @DisplayName("3개 ~ 6개의 모든 번호를 한번씩 맞춘 경우의 상금 확인")
    void testLottoProfitChecker_AllPrizes_ShouldReturnCorrectProfits() {
        // given, when
        LottoProfitChecker lottoProfitChecker = new LottoProfitChecker(getAllWinLotto());
        float profit = lottoProfitChecker.getProfitRatio(PURCHASE_AMOUNT);

        // then
        assertThat(profit).isEqualTo(ALL_WIN_PRIZES / PURCHASE_AMOUNT_FLOAT);
    }

    @Test
    @DisplayName("0개의 번호를 맞춘 경우의 상금 확인")
    void testLottoProfitChecker_NoPrize_ShouldReturnCorrectZeroProfit() {
        // given, when
        LottoProfitChecker lottoProfitChecker = new LottoProfitChecker(new HashMap<>());
        float profit = lottoProfitChecker.getProfitRatio(PURCHASE_AMOUNT);

        // then
        assertThat(profit).isEqualTo(ZERO_WIN_PRIZE);
    }

    private HashMap<Integer, Integer> getAllWinLotto() {
        HashMap<Integer, Integer> lotto = new HashMap<>();

        for (int i = PrizeResultEnum.THREE_MATCHED.getMatchedCount(); i <= PrizeResultEnum.SIX_MATCHED.getMatchedCount(); i++) {
            lotto.put(i, 1);
        }

        return lotto;
    }

}
