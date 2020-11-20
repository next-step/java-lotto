package domain;

import org.junit.jupiter.api.Test;

import static domain.LottoPrize.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private LottoResult lottoResult = new LottoResult();

    public LottoResultTest() {}

    @Test
    void checkWhetherToWinTest_4등() {
        LottoPrizeCount lottoPrizeCount = lottoResult.getLottoPrizeCount();

        Integer before = lottoPrizeCount.getPrizeCount(FOURTH_PRIZE);
        lottoResult.addPrizeResult(FOURTH_PRIZE);
        Integer after = lottoPrizeCount.getPrizeCount(FOURTH_PRIZE);
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void checkWhetherToWinTest_3등() {
        LottoPrizeCount lottoPrizeCount = lottoResult.getLottoPrizeCount();

        Integer before = lottoPrizeCount.getPrizeCount(THIRD_PRIZE);
        lottoResult.addPrizeResult(THIRD_PRIZE);
        Integer after = lottoPrizeCount.getPrizeCount(THIRD_PRIZE);
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void checkWhetherToWinTest_2등() {
        LottoPrizeCount lottoPrizeCount = lottoResult.getLottoPrizeCount();

        Integer before = lottoPrizeCount.getPrizeCount(SECOND_PRIZE);
        lottoResult.addPrizeResult(SECOND_PRIZE);
        Integer after = lottoPrizeCount.getPrizeCount(SECOND_PRIZE);
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void checkWhetherToWinTest_1등() {
        LottoPrizeCount lottoPrizeCount = lottoResult.getLottoPrizeCount();

        Integer before = lottoPrizeCount.getPrizeCount(FIRST_PRIZE);
        lottoResult.addPrizeResult(FIRST_PRIZE);
        Integer after = lottoPrizeCount.getPrizeCount(FIRST_PRIZE);
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void calculateProfitRatesTest() throws Exception {
        lottoResult.addPrizeResult(THIRD_PRIZE);
        lottoResult.calculateProfitRates();
        assertThat(lottoResult.calculateProfitRates()).isEqualTo(50);
    }
}
