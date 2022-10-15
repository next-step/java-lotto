package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class ManualLottosTest {

    @DisplayName("수동 로또를 생성한다.")
    @Test
    void create_manual_lottos() {

        final List<String> inputManualLottos = List.of("1, 2, 3, 4, 5, 6"
                , "7, 8, 9, 10, 11, 12"
                , "13, 14, 15, 16, 17, 18"
        );
        final ManualLottos manualLottos = ManualLottos.of(3, inputManualLottos);

        final List<Lotto> lottos = manualLottos.getManualLottos().getLottos();
        assertAll(
                () -> assertThat(lottos).hasSize(3),
                () -> assertThat(lottos.get(0)).isEqualTo(LottoFactory.from("1, 2, 3, 4, 5, 6")),
                () -> assertThat(lottos.get(1)).isEqualTo(LottoFactory.from("7, 8, 9, 10, 11, 12")),
                () -> assertThat(lottos.get(2)).isEqualTo(LottoFactory.from("13, 14, 15, 16, 17, 18"))
        );
    }

    @DisplayName("수동 로또 구매 장수와 입력값의 수보다 크다.")
    @Test
    void error_create_manual_lottos() {

        final List<String> inputManualLottos = List.of("1, 2, 3, 4, 5, 6"
                , "7, 8, 9, 10, 11, 12"
                , "13, 14, 15, 16, 17, 18"
        );
        assertThatThrownBy(() -> ManualLottos.of(4, inputManualLottos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수동 구매한 로또수와 수동 로또 입력값이 맞지 않습니다.");
    }

    @DisplayName("수동 로또 구매 장수와 입력값의 수보다 작다.")
    @Test
    void error_create_manual_lottos2() {

        final List<String> inputManualLottos = List.of("1, 2, 3, 4, 5, 6"
                , "7, 8, 9, 10, 11, 12"
                , "13, 14, 15, 16, 17, 18"
        );
        assertThatThrownBy(() -> ManualLottos.of(2, inputManualLottos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("지불한 금액보다 수동으로 구입하려는 로또가 더 많습니다.");
    }
}
