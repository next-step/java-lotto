package lotto;

import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {


    @Test
    void lotto_금액_exception_test() {

        assertThatThrownBy(() -> Lottos.getLottoCount(2200)).isInstanceOf(IllegalArgumentException.class);
        assertThat(Lottos.getLottoCount(2000)).isEqualTo(2);

    }
}
