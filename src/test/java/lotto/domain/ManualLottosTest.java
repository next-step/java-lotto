package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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
        assertAll(
                () -> assertThat(lottos).hasSize(3),
                () -> assertThat(lottos.get(0)).isEqualTo(Lotto.from("1, 2, 3, 4, 5, 6")),
                () -> assertThat(lottos.get(1)).isEqualTo(Lotto.from("7, 8, 9, 10, 11, 12")),
                () -> assertThat(lottos.get(2)).isEqualTo(Lotto.from("13, 14, 15, 16, 17, 18"))
        );
    }
}
