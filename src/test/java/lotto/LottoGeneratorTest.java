package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @Test
    @DisplayName("로또 생성 테스트")
    public void generateLotto() {
        assertThat(new LottoGenerator().generateLotto(0).size()).isEqualTo(0);

        assertThat(new LottoGenerator().generateLotto(1).size()).isEqualTo(1);

        assertThat(new LottoGenerator().generateLotto(-1).size()).isEqualTo(0);
    }
}