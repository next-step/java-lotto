package lotto.domain;

import lotto.domain.lottoStrategy.LottoGenerateStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    private Lotto lotto;
    private LottoGenerator lottoGenerator;
    private LottoCount lottoCount;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoGenerator = new LottoGenerator();
        lottoCount = new LottoCount(1);
    }


    @Test
    @DisplayName("횟수를 입력해 로또들을 구매할 수 있다.(수동, 자동 모두 가능)")
    void buy() {
        Lottos lottos = lottoGenerator.generateLottos(lottoCount, new TestLottoStrategy(lotto));

        assertThat(lottos).containsExactly(lotto);
    }

    static class TestLottoStrategy implements LottoGenerateStrategy {
        private final Lotto lotto;

        TestLottoStrategy(Lotto lotto) {
            this.lotto = lotto;
        }


        @Override
        public Lotto generateLotto(int count) {
            return this.lotto;
        }
    }
}