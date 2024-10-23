package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class AutoLottoGeneratorStrategyTest {

    private LottoGeneratorStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new AutoLottoGeneratorStrategy(5);
    }

    @Test
    void 자동로또_생성() {
        List<Lotto> lottos = strategy.generateLottos();
        Assertions.assertThat(lottos).hasSize(5);
    }
}
