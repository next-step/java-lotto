package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoProfitTest {

    @Test
    public void winningAsSecondOrThird() {
        assertThat(LottoProfit.valueOf(5,true)).isEqualTo(LottoProfit.SECOND);
        assertThat(LottoProfit.valueOf(5,false)).isEqualTo(LottoProfit.THIRD);
    }

    @Test
    public void miss() {
        assertThat(LottoProfit.valueOf(0,true)).isEqualTo(LottoProfit.MISS);
        assertThat(LottoProfit.valueOf(0,false)).isEqualTo(LottoProfit.MISS);
    }

    @Test
    public void winningAsFirst() {
        assertThat(LottoProfit.valueOf(6,true)).isEqualTo(LottoProfit.FIRST);
        assertThat(LottoProfit.valueOf(6,false)).isEqualTo(LottoProfit.FIRST);
    }


}
