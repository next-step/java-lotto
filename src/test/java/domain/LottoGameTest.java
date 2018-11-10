package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void getTotalEarningRate() {
        double earningRate = LottoGame.getTotalEarningRate(14000, 5000);
        assertThat(earningRate).isEqualTo((double) (5000) / (double) 14000);
    }

    @Test
    public void buyLottoCount() {
        int lottoCount = LottoGame.buyLottoCount(5000);
        assertThat(lottoCount).isEqualTo(5);
    }
}