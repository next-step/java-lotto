package domain;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottoMoneyTest {
    @Test
    public void 구매가능한_로또_개수를_반환한다() {
        LottoMoney lottoMoney = new LottoMoney(10_000);
        assertThat(lottoMoney.getLottoCount()).isEqualTo(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 단위가_틀리면_예외가_발생한다() {
        new LottoMoney(15_500);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 음수면_예외가_발생한다() {
        new LottoMoney(-15_000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 할당량_이상_구매하면_예외가_발생한다() {
        new LottoMoney(200_000);
    }
}
