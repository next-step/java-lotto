package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("Lotto add 확인")
    void add() {
        Lottos lottos = new Lottos();
        lottos.add(new Lotto());
        assertThat(lottos.lottos().size()).isEqualTo(1);
    }

}