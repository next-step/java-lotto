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
        lottoResult.checkWhetherToWin(3l);
        Long after = lottoPrizeCount.getFourthPrizeCount();
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void checkWhetherToWinTest_3등() {
        LottoPrizeCount lottoPrizeCount = lottoResult.getLottoPrizeCount();

        Long before = lottoPrizeCount.getThirdPrizeCount();
        lottoResult.checkWhetherToWin(4l);
        Long after = lottoPrizeCount.getThirdPrizeCount();
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void checkWhetherToWinTest_2등() {
        LottoPrizeCount lottoPrizeCount = lottoResult.getLottoPrizeCount();

        Long before = lottoPrizeCount.getSecondPrizeCount();
        lottoResult.checkWhetherToWin(5l);
        Long after = lottoPrizeCount.getSecondPrizeCount();
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void checkWhetherToWinTest_1등() {
        LottoPrizeCount lottoPrizeCount = lottoResult.getLottoPrizeCount();

        Long before = lottoPrizeCount.getFirstPrizeCount();
        lottoResult.checkWhetherToWin(6l);
        Long after = lottoPrizeCount.getFirstPrizeCount();
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void calculateProfitRatesTest() throws Exception {
        lottoResult.checkWhetherToWin(4L);
        lottoResult.calculateProfitRates(5);
        assertThat(lottoResult.getProfitRates()).isEqualTo(10);
    }
}
