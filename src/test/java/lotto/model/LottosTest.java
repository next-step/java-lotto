package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @Test
    void getLottosResult() {
        Lottos lottos = new Lottos(
                Arrays.asList(
                        new Lotto(1, 2, 3, 4, 5, 6),
                        new Lotto(2, 3, 4, 5, 6, 7),
                        new Lotto(3, 4, 5, 6, 7, 8)
                )
        );
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        assertThat(lottos.calculateResults(winningLotto))
                .isEqualTo(new LottoResults(Map.of(4, 1, 5, 1, 6, 1)));
    }

}