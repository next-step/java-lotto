package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    @DisplayName("금액만큼의 로또를 생성한다")
    void generate_lottos() {
        Assertions.assertThat(new LottoGenerator(14000).getLottos()).hasSize(14);
    }
}