package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottosTest {
    @DisplayName("로또를 여러개 생성할 수 있다.")
    @Test
    void createLottos() {
        Lottos lottos = new Lottos(5);
        assertThat(lottos.values()).hasSize(5);
    }

    @DisplayName("로또를 0개 생성하는 경우 예외 발생")
    @Test
    void createZeroLottos() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lottos.create(0));
    }
}