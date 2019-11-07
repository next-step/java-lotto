package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LottoPriceTest {
    private LottoPrice lottoPrice;

    @Test
    void validate() {
        assertThatThrownBy(() -> new LottoPrice(999)).isInstanceOf(IllegalArgumentException.class);
        assertThat(new LottoPrice(1000)).isInstanceOf(LottoPrice.class);
    }

    @Test
    void isBuyAvailable() {
        int budget = 1999;
        lottoPrice = new LottoPrice(budget);
        assertThat(lottoPrice.isEnoughBudget()).isTrue();
        assertThat(lottoPrice.isEnoughBudget()).isFalse();
    }
}
