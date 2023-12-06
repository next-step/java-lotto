package lotto;

import lotto.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    Lottos lottos = new Lottos();

    @DisplayName("로또 총 갯수 출력")
    @Test
    void 로또_총_개수() {
        lottos.manualLotto("1,2,3,4,5,6");
        lottos.autoLotto(10);

        assertThat(lottos.getLottoList().size()).isEqualTo(11);
    }
}
