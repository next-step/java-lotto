package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    @Test
    void successTest() {
        Lottos lottos = new Lottos(new PurchasePrice("10000"));
        assertThat(lottos.getLottoCount()).isEqualTo(10);
    }

    @Test
    void failTest() {
        assertThatThrownBy(() -> new Lottos(new PurchasePrice("10001")))
                .isInstanceOf(IllegalArgumentException.class);
    }

}