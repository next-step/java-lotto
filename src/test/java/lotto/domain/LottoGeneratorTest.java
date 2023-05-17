package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    void 로또_구매() {
        List<Lotto> lottos = LottoGenerator.generateLottos(10);
        assertThat(lottos).hasSize(10);
    }
}
