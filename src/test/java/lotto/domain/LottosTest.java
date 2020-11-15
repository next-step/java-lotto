package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("Supplier 를 통해 Lottos 를 생성 할 수 있다.")
    void constructor() {
        Lottos lottos = new Lottos(3, () -> new Lotto(Arrays.asList(
                1, 2, 3, 4, 5, 6
        )));
        assertThat(lottos.toString()).isEqualTo(
                "[1, 2, 3, 4, 5, 6]\n"
                        + "[1, 2, 3, 4, 5, 6]\n"
                        + "[1, 2, 3, 4, 5, 6]\n"
        );
    }
}
