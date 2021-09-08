package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @Test
    @DisplayName("로또 생성 테스트")
    public void generateLotto() {
        Lottos lottos = new LottoGenerator().generateLotto(0);
        assertThat(lottos.toStringLottos().size()).isEqualTo(0);

        lottos = new LottoGenerator().generateLotto(1);
        assertThat(lottos.toStringLottos().size()).isEqualTo(1);

        lottos = new LottoGenerator().generateLotto(-1);
        assertThat(lottos.toStringLottos().size()).isEqualTo(0);
    }
}