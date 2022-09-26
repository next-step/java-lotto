package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @DisplayName("로또를 여러개 생성할 수 있다.")
    @Test
    void createLottos() {
        Lottos lottos = new Lottos(5);
        assertThat(lottos.values()).hasSize(5);
    }
}