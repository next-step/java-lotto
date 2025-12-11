package lottogame.model.lotto.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ManualLottosGeneratorTest {

    @Test
    void 입력받은_수동로또번호로_수동로또목록을_발행할_수_있다() {
        List<String> lottos = List.of("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7");

        ManualLottosGenerator generator = new ManualLottosGenerator(lottos);

        assertThat(
                generator.generateLottos().size()
        ).isEqualTo(2);
    }
}