package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottosTest {

    @DisplayName("수동 로또를 생성한다.")
    @Test
    void create_manual_lottos() {

        final List<String> inputManualLottos = List.of("1, 2, 3, 4, 5, 6"
                , "7, 8, 9, 10, 11, 12"
                , "13, 14, 15, 16, 17, 18"
        );
        final ManualLottos manualLottos = ManualLottos.from(inputManualLottos);

        final List<Lotto> lottos = manualLottos.getManualLottos().getLottos();

        assertThat(lottos).hasSize(3);
    }
}
