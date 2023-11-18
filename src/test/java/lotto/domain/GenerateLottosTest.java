package lotto.domain;

import lotto.strategy.NumberStrategy;
import lotto.strategy.RandomNumberStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GenerateLottosTest {

    @Test
    void 수량만큼_자동로또를_생성한다() {
        // given
        int autoCount = 1;
        NumberStrategy numberStrategy = new RandomNumberStrategy();
        // when
        List<Lotto> autoLotto = GenerateLottos.autoGenerateLottos(autoCount, numberStrategy);
        // then
        assertThat(autoLotto.size()).isEqualTo(autoCount);
    }
}
