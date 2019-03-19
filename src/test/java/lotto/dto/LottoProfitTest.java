package lotto.dto;

import lotto.vo.LottoMatchCount;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoProfitTest {

    @Test
    public void 수익금계산테스트() {
        LottoProfit lottoProfit = new LottoProfit(3, 2, 5500);
        LottoMatchCount lottoMatchCount = new LottoMatchCount(0, 0, 0, 0, 1);
        lottoProfit.calculateProfit(lottoMatchCount);
        assertThat(lottoProfit.getProfit()).isEqualTo(1.0);
    }

}