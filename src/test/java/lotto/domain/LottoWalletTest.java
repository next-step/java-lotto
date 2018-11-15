package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWalletTest {

    private LottoWallet lottoWallet;

    @Before
    public void setup() {
        lottoWallet = LottoWallet.create(14_000, lottos);
    }

    @Test
    public void 복권을_몇개_구매할수있는지_알수있다() {
        assertThat(lottoWallet.numberOfBuy(1_000)).isEqualTo(14);
    }

    @Test
    public void 수익률을_알수있다() {
        assertThat(lottoWallet.rateReturn(13_000)).isLessThan(BigDecimal.ONE);
    }
}