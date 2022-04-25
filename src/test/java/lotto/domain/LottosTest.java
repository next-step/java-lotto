package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        this.lottos = new Lottos(
                3000
        );
    }

    @Nested
    class length_메서드는 {

        @Test
        void 길이를_리턴한다() {
            assertThat(lottos.length()).isEqualTo(3);
        }
    }
}
