package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ManualLottosTest {

    @Test
    void merge_auto_lottos_with_manual_lottos() {
        AutoLottos autoLottos = new AutoLottos(List.of(
                new Lotto(Set.of(1, 3, 5, 6, 7, 8))
        ));
        ManualLottos manualLottos = new ManualLottos(new ArrayList<>(
                List.of(
                        new Lotto(Set.of(2, 4, 6, 8, 10, 12))
                )
        ));

        LottoGame lottoGame = autoLottos.merge(manualLottos);
        assertThat(lottoGame).isEqualTo(new LottoGame(List.of(
                new Lotto(Set.of(2, 4, 6, 8, 10, 12)),
                new Lotto(Set.of(1, 3, 5, 6, 7, 8))
        )));
    }
}