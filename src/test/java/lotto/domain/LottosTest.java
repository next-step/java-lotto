package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {
    @Test
    @DisplayName("로또 열개 생성")
    void generateLottos() {
        Lottos lottos = new Lottos();
        List<Lotto> generateLottos = lottos.generateLottos(10);
        assertThat(generateLottos.size()).isEqualTo(10);
    }
}
