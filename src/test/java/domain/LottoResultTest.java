package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private LottoResult lottoResult = new LottoResult();

    public LottoResultTest() throws Exception {
    }

    @Test
    void checkWhetherToWinTest_4등() {
        Long before = lottoResult.getFourthPrizeCount();
        lottoResult.checkWhetherToWin(3l);
        Long after = lottoResult.getFourthPrizeCount();
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void checkWhetherToWinTest_3등() {
        Long before = lottoResult.getThirdPrizeCount();
        lottoResult.checkWhetherToWin(4l);
        Long after = lottoResult.getThirdPrizeCount();
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void checkWhetherToWinTest_2등() {
        Long before = lottoResult.getSecondPrizeCount();
        lottoResult.checkWhetherToWin(5l);
        Long after = lottoResult.getSecondPrizeCount();
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void checkWhetherToWinTest_1등() {
        Long before = lottoResult.getFirstPrizeCount();
        lottoResult.checkWhetherToWin(6l);
        Long after = lottoResult.getFirstPrizeCount();
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void calculateProfitRatesTest() throws Exception {
        lottoResult.checkWhetherToWin(4L);
        lottoResult.calculateProfitRates(5);
        assertThat(lottoResult.getProfitRates()).isEqualTo(10);
    }
}
