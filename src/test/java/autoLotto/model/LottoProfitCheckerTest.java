package autoLotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProfitCheckerTest {

    private static final String PURCHASE_AMOUNT_STRING = "4000";
    private static final float PURCHASE_AMOUNT_FLOAT = 4000f;

    private static final int[] ALL_WIN_LOTTOS = {0,1,1,1,1};
    private static final int[] ALL_FAIL_LOTTOS = {4,0,0,0,0};

    private static final float ALL_WIN_PRIZES = PrizeResultEnum.getPrizeByIndex(1)
                                                + PrizeResultEnum.getPrizeByIndex(2)
                                                + PrizeResultEnum.getPrizeByIndex(3)
                                                + PrizeResultEnum.getPrizeByIndex(4);
    private static final float ZERO_WIN_PRIZE = 0f;

    @Test
    @DisplayName("LottoProfitChecker 객체 생성 : 성공 (모든 상금을 1개씩 받음)")
    void testLottoProfitChecker_AllPrizes_ShouldReturnCorrectProfits() {
        // given, when
        LottoProfitChecker lottoProfitChecker = new LottoProfitChecker(ALL_WIN_LOTTOS, PURCHASE_AMOUNT_STRING);
        float profit = lottoProfitChecker.getProfit();

        // then
        assertThat(profit).isEqualTo(ALL_WIN_PRIZES / PURCHASE_AMOUNT_FLOAT);
    }

    @Test
    @DisplayName("LottoProfitChecker 객체 생성 : 성공 (상금이 없음)")
    void testLottoProfitChecker_NoPrize_ShouldReturnCorrectProfits() {
        // given, when
        LottoProfitChecker lottoProfitChecker = new LottoProfitChecker(ALL_FAIL_LOTTOS, PURCHASE_AMOUNT_STRING);
        float profit = lottoProfitChecker.getProfit();

        // then
        assertThat(profit).isEqualTo(ZERO_WIN_PRIZE);
    }

}
