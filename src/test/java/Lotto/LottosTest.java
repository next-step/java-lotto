package Lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottosTest {
    @Test
    void 로또개수입력() {
        Lottos lottos = new Lottos(1000);
        Assertions.assertThat(lottos.lottoQuantity()).isEqualTo(1);
    }

    @Test
    void 금액을_1000원단위로_입력_안한경우() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> new Lottos(1100));
    }
}
