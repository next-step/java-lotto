package autoLotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProfitCheckerTest {

    private static final String PURCHASE_AMOUNT_STRING = "4000";
    private static final float PURCHASE_AMOUNT_FLOAT = 4000f;

    private static final List<Integer> ALL_WIN_LOTTOS = new ArrayList<>(Arrays.asList(0,1,1,1,1));
    private static final List<Integer> ALL_FAIL_LOTTOS = new ArrayList<>(Arrays.asList(4,0,0,0,0));

    private static final float ALL_WIN_PRIZES = PrizeResultEnum.getPrizeByIndex(PrizeResultEnum.THREE_MATCHED.getIndex())
                                                + PrizeResultEnum.getPrizeByIndex(PrizeResultEnum.FOUR_MATCHED.getIndex())
                                                + PrizeResultEnum.getPrizeByIndex(PrizeResultEnum.FIVE_MATCHED.getIndex())
                                                + PrizeResultEnum.getPrizeByIndex(PrizeResultEnum.SIX_MATCHED.getIndex());
    private static final float ZERO_WIN_PRIZE = 0f;

    @Test
    @DisplayName("LottoProfitChecker 객체 생성 : 성공 (모든 상금을 1개씩 받음)")
    void testLottoProfitChecker_AllPrizes_ShouldReturnCorrectProfits() {
        // given, when
        LottoProfitChecker lottoProfitChecker = new LottoProfitChecker(getAllWinLotto());
        float profit = lottoProfitChecker.getProfitRatio(PURCHASE_AMOUNT_STRING);

        // then
        assertThat(profit).isEqualTo(ALL_WIN_PRIZES / PURCHASE_AMOUNT_FLOAT);
    }

    @Test
    @DisplayName("LottoProfitChecker 객체 생성 : 성공 (상금이 없음)")
    void testLottoProfitChecker_NoPrize_ShouldReturnCorrectProfits() {
        // given, when
        LottoProfitChecker lottoProfitChecker = new LottoProfitChecker(new HashMap<>());
        float profit = lottoProfitChecker.getProfitRatio(PURCHASE_AMOUNT_STRING);

        // then
        assertThat(profit).isEqualTo(ZERO_WIN_PRIZE);
    }

    private HashMap<Integer, Integer> getAllWinLotto() {
        HashMap<Integer, Integer> lotto = new HashMap<>();

        for (int i = PrizeResultEnum.THREE_MATCHED.getIndex(); i <= PrizeResultEnum.SIX_MATCHED.getIndex(); i++) {
            lotto.put(i, 1);
        }

        return lotto;
    }

}
