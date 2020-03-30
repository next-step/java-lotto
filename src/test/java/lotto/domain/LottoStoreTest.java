package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {
    @Test
    void sellLotto() {
        List<Lotto> lottos = LottoStore.sellLotto(14000);

        assertThat(lottos).hasSize(14);
    }
}
