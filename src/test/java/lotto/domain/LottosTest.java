package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("금액에 따른 개수에 따라 로또 발급 테스트")
    @Test
    void createLottos() {
        Lottos lottos = Lottos.of(3, new LottoNumberRandomGenerator());

        assertThat(lottos.size()).isEqualTo(3);
    }
}
