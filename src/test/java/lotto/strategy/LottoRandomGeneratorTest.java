package lotto.strategy;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRandomGeneratorTest {

    @Test
    void generateTest() {
        LottoGenerator lottoGenerator = new LottoRandomGenerator();
        Lotto lotto = lottoGenerator.generate();
        assertThat(lotto.numbers().size()).isEqualTo(6);
    }

}
