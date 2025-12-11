package lottogame.model.lotto.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AutoLottoGeneratorTest {


    @Test
    void 사용자의금액만큼_자동로또를_발행할_수_있다() {
        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator(15);

        assertThat(
                autoLottoGenerator.generateLottos().size()
        ).isEqualTo(15);
    }
}