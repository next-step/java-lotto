package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @Test
    @DisplayName("주어진 개수만큼 로또를 생성한다")
    void shouldCreateLottos() {
        Lottos lottos = new Lottos(3);
        assertThat(lottos.getValues().size()).isEqualTo(3);
    }
}