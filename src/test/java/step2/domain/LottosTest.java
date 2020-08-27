package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("로또 대량 생성")
    public void generateLottos() {
        Lottos lottos = new Lottos(5);

        assertThat(lottos.getLottoSize()).isEqualTo(5);
    }
}
