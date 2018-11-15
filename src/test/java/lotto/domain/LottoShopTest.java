package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoShopTest {

    @Test
    public void 로또셋을_구매_할수있다() {
        int amount = 14_000;
        LottoSet lottoSet = LottoShop.buy(amount);
        assertThat(lottoSet).isNotNull();
        assertThat(lottoSet.sizeOfAutomatic()).isEqualTo(14);
    }
}
