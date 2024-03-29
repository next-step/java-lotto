package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    private static final int LOTTO_SIZE = 6;
    @Test
    void 리스트_셔플() {
        assertThat(LottoGenerator.shuffleLotto()).hasSize(6);
    }

    @Test
    void createLotto() {
        List<Integer> shuffledLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(LottoGenerator.createLotto(shuffledLotto)).isEqualTo(new Lotto(shuffledLotto));
    }

    @Test
    void createLottos() {
        assertThat(LottoGenerator.createLottos(2)).isNotNull();
    }

}
