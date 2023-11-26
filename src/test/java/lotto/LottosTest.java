package lotto;

import lotto.model.Lotto;
import lotto.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @DisplayName("모든 로또들의 숫자 체크")
    @Test
    void numberOfLotto() {
        Lottos lottos = new Lottos(10);

        for (Lotto lotto:lottos.getLottoList()) {
            for (int i = 0; i < 6; i++) {
                assertThat(lotto.getLottoNumber().get(i) >= 1 && lotto.getLottoNumber().get(i) <= 45).isTrue();
            }
        }
    }

    @DisplayName("로또들이 원하는 갯수만큼 만들어진다.")
    @Test
    void numberOfLottos() {
        Lottos lottos = new Lottos(10);

        assertThat(lottos.getLottoList().size()).isEqualTo(10);
    }
}
