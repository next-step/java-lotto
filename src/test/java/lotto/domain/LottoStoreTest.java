package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoStoreTest {
    @Test
    void sell() {
        Store store = new LottoStore();
        Lottos lottos = store.sell(new Money(4_000L));

        assertThat(lottos.size()).isEqualTo(4);
    }
}