package lotto.utils;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    void create_Lottos() {
        List<Lotto> lottos = LottoGenerator.generateLottos(4);
        assertThat(lottos).hasSize(4);
    }
}
