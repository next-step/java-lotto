package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    private static final RandomGenerator LOTTO_RANDOM_GENERATOR = () -> List.of(3, 10, 5, 20, 43, 31);

    @DisplayName("구매한 로또 개수를 구한다")
    @Test
    void count() {
        Integer purchaseAmount = 14000;
        Lottos lottos = new Lottos(LOTTO_RANDOM_GENERATOR, purchaseAmount);

        assertThat(lottos.count()).isEqualTo(14);
    }
}