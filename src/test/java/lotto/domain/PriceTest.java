package lotto.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PriceTest {
    @Test
    public void 수익률() {
        LottoPrice price = new LottoPrice(10000);
        assertThat(price.getProfit(1000)).isEqualTo(0.1);
    }

    @Test
    public void 로또개수() {
        assertThat(new LottoPrice(10000).count()).isEqualTo(10);
    }
}
