package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoStoreTest {

    @Test
    void shouldBuyLotto(){
        LottoStore store = new LottoStore();
        assertThat(store.buy(14000)).isEqualTo(14);
    }

    @Test
    void shouldGetLotto(){
        LottoStore lottoStore = new LottoStore();
        assertThat(lottoStore.getLotto().getLotto().size()).isEqualTo(6);
    }
}