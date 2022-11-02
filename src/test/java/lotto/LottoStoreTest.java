package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {
    @Test
    void name() {
        assertThat(new LottoStore(10).purchase(140)).hasSize(14);
    }
}
