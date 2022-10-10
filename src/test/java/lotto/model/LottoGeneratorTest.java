package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    LottoGenerator lottoGenerator = new LottoGenerator();

    @DisplayName("로또 구입 금액에 따라 로또가 여러장 생성된다.")
    @Test
    void generateLottos() {
        Lottos lottos = lottoGenerator.generateLottos(new Money(3000));
        Assertions.assertThat(lottos.getLottos()).hasSize(3);
    }
}
