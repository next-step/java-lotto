package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    void 자동_로또_구매() {
        List<Lotto> lottos = LottoGenerator.autoGenerateLottos(10);
        assertThat(lottos).hasSize(10);
    }

    @Test
    void 수동_로또_구매() {
        String manualLotto1 = "1, 2, 3, 4, 5, 6";
        String manualLotto2 = "2, 3, 4, 5, 6, 7";
        List<Lotto> manualLottos = LottoGenerator.manualGenerateLottos(List.of(manualLotto1, manualLotto2));
        assertThat(manualLottos).hasSize(2);
    }
}
