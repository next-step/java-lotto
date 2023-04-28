package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("로또들의 가격을 구할 수 있다")
    public void lottosPrice() {
        Lotto lotto1 = Lotto.of(1, 2, 3, 4, 5, 6);
        Lotto lotto2 = Lotto.of(1, 2, 3, 4, 5, 6);

        Lottos lottos = Lottos.of(lotto1, lotto2);

        assertThat(lottos.price()).isEqualTo(2000);
    }

}
