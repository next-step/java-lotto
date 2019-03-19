package lotto;

import lotto.dto.LottoProfit;
import lotto.vo.LottoMatchCount;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoProfitTest {

    @Test
    public void 수익금계산테스트() {
        LottoProfit lottoProfit = new LottoProfit(1, 1500);
        LottoMatchCount lottoMatchCount = new LottoMatchCount(0, 0, 0, 1, 0);
        lottoProfit.calculateProfit(lottoMatchCount);
        assertThat(lottoProfit.getProfit()).isEqualTo(50.0);
    }

}