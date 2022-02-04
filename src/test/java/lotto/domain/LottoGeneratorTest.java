package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    void 총_6개의_중복되지_않은_난수를_만든다() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> lotto = lottoGenerator.generateLotto();
        int count = (int) lotto.stream()
            .filter(this::inRange)
            .count();
        Set<Integer> removeDuplicated = new HashSet<>(lotto);
        assertThat(lotto.size()).isEqualTo(6);
        assertThat(count).isEqualTo(6);
        assertThat(removeDuplicated.size()).isEqualTo(6);
    }

    private boolean inRange(Integer i) {
        return 1 <= i && i <= 45;
    }
}
