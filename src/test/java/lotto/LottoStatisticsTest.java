package lotto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @Test
    void getLottoBuyingCount() {
        assertThat(LottoStatistics.getLottoBuyingCount(14000)).isEqualTo(14);
    }

    @Test
    void threeMatch() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.collectWin(3);
        assertThat(lottoStatistics.threeMatch()).isEqualTo(1);
    }

    @Test
    void fourMatch() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.collectWin(4);
        assertThat(lottoStatistics.fourMatch()).isEqualTo(1);
    }

    @Test
    void fiveMatch() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.collectWin(5);
        assertThat(lottoStatistics.fiveMatch()).isEqualTo(1);
    }

    @Test
    void sixMatch() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.collectWin(6);
        assertThat(lottoStatistics.sixMatch()).isEqualTo(1);
    }

    @Test
    void calculateTotalProfit() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.collectWin(3);
        assertThat(lottoStatistics.calculateTotalProfit()).isEqualTo(5000 / 1000);
        lottoStatistics.collectWin(4);
        BigDecimal bg1 = new BigDecimal(55000);
        BigDecimal bg2 = new BigDecimal(2000);
        assertThat(lottoStatistics.calculateTotalProfit()).isEqualTo(bg1.divide(bg2, 2, BigDecimal.ROUND_HALF_DOWN).doubleValue());
    }
}

