package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @DisplayName("구입한 수만큼 로또를 발행한다")
    @Test
    void generateLottos() {
        List<Lotto> lottos = LottoGenerator.generateLottos(10);
        assertThat(lottos).hasSize(10);
    }
}
