package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import lotto.domain.lottogenerator.LottoGenerator;
import lotto.domain.lottogenerator.RandomLottoGenerator;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @Test
    void 총_6개의_중복되지_않은_난수를_만든다() {
        LottoGenerator lottoGenerator = new RandomLottoGenerator();
        Set<Integer> lotto = lottoGenerator.generateLotto();
        int count = (int) lotto.stream()
            .filter(this::inRange)
            .count();
        assertThat(lotto.size()).isEqualTo(6);
        assertThat(count).isEqualTo(6);
    }

    private boolean inRange(Integer i) {
        return 1 <= i && i <= 45;
    }
}
