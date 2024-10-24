package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoGeneratorStrategyTest {

    private static final String LOTTONUMBERS_1 = "1, 2, 3, 4, 5, 6";
    private static final String LOTTONUMBERS_2 = "4, 5, 6, 7, 8, 9";

    private LottoGeneratorStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new ManualLottoGeneratorStrategy(Arrays.asList(LOTTONUMBERS_1, LOTTONUMBERS_2));
    }

    @Test
    void 수동생성_테스트() {
        List<Lotto> lottos = strategy.generateLottos();
        assertThat(lottos).containsOnly(new Lotto(LOTTONUMBERS_1), new Lotto(LOTTONUMBERS_2));
    }
}
