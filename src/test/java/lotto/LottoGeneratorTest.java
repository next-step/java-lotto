package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @Test
    @DisplayName("로또 생성 테스트")
    public void generateLotto() {
        assertThat(new LottoGenerator().generateLotto(14000).size()).isEqualTo(14);

        assertThat(new LottoGenerator().generateLotto(900).size()).isEqualTo(0);

        assertThat(new LottoGenerator().generateLotto(1100).size()).isEqualTo(1);
    }
}