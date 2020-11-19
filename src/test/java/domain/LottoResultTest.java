package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private LottoResult lottoResult = new LottoResult();

    public LottoResultTest() throws Exception {
    }

    @Test
    void checkWhetherToWinTest_4등() {
        LottoPrizeCount lottoPrizeCount = lottoResult.getLottoPrizeCount();

        Long before = lottoPrizeCount.getFourthPrizeCount();
        lottoResult.addPrizeResult(LottoPrize.FOURTH_PRIZE);
        Long after = lottoPrizeCount.getFourthPrizeCount();
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void checkWhetherToWinTest_3등() {
        LottoPrizeCount lottoPrizeCount = lottoResult.getLottoPrizeCount();

        Long before = lottoPrizeCount.getThirdPrizeCount();
        lottoResult.addPrizeResult(LottoPrize.THIRD_PRIZE);
        Long after = lottoPrizeCount.getThirdPrizeCount();
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void checkWhetherToWinTest_2등() {
        LottoPrizeCount lottoPrizeCount = lottoResult.getLottoPrizeCount();

        Long before = lottoPrizeCount.getSecondPrizeCount();
        lottoResult.addPrizeResult(LottoPrize.SECOND_PRIZE);
        Long after = lottoPrizeCount.getSecondPrizeCount();
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void checkWhetherToWinTest_1등() {
        LottoPrizeCount lottoPrizeCount = lottoResult.getLottoPrizeCount();

        Long before = lottoPrizeCount.getFirstPrizeCount();
        lottoResult.addPrizeResult(LottoPrize.FIRST_PRIZE);
        Long after = lottoPrizeCount.getFirstPrizeCount();
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void calculateProfitRatesTest() throws Exception {
        lottoResult.addPrizeResult(LottoPrize.THIRD_PRIZE);
        lottoResult.calculateProfitRates(5);
        assertThat(lottoResult.getProfitRates()).isEqualTo(10);
    }
}
