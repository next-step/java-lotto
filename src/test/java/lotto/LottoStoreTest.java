package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {

    @Test
    void shouldBuyLotto(){
        LottoStore store = new LottoStore();
        Assertions.assertThat(store.buy(14000)).isEqualTo(14);
    }
}