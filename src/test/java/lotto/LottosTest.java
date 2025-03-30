package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 개수만큼 Lotto를 갖는다.")
    @Test
    void purchase() {
        int purchasePrice = 15000;
        Lottos lottos = new Lottos(purchasePrice);
        assertThat(lottos.count()).isEqualTo(15);
    }
}
