package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    private Lotto lotto;
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoGenerator = new LottoGenerator();
    }


    @Test
    @DisplayName("횟수를 입력해 수동 로또들을 구매할 수 있다.")
    void generateManualLottos() {
        Lottos lottos = lottoGenerator.generateManualLottos(1, List.of(lotto));

        assertThat(lottos).containsExactly(lotto);
    }
}