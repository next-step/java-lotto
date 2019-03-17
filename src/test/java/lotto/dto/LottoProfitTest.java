package lotto.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoProfitTest {

    @Test
    public void 수익금계산테스트() {
        LottoProfit lottoProfit = new LottoProfit(1, 1500);
        lottoProfit.calculateProfit(0, 1, 0, 0, 0);
        assertThat(lottoProfit.getProfit()).isEqualTo(50.0);
    }

}