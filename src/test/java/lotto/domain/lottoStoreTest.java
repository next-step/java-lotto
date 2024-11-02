package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class lottoStoreTest {

    @Test
    void 로또_발행() {
        List<Lotto> lottos = lottoStore.issueLottos(10000);

        assertThat(lottos).hasSize(10);
    }

    @Test
    void 로또_발행_음수_허용X() {

        assertThatThrownBy(() ->
                lottoStore.issueLottos(-10000)
        ).isInstanceOf(IllegalArgumentException.class);

    }
}