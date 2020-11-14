package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    @DisplayName("입력 개수만큼 다수의 로또 생성")
    void createLottos() {
        int lottoNum = 3;

        Lottos lottos = new Lottos(lottoNum, new NumberSelectionStrategyImpl());

        assertThat(lottos.getLottos()).hasSize(lottoNum);
    }
}
