package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @Test
    void shouldBuyLotto() {
        assertThat(LottoStore.buy(14000, 0).size()).isEqualTo(14);
    }

    @Test
    void shouldBuyLotto_whenManualLotto() {
        assertThat(LottoStore.buy(14000, 3).size()).isEqualTo(11);
    }

}
