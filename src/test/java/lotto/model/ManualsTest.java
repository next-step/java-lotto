package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ManualsTest {

    @Test
    @DisplayName("수동으로 구매할 번호가 입력으로 주어지면 수동 로또 정보를 구성한다.")
    void 수동_로또_정보() {
        // given
        ManualLottoCount manualLottoCount = new ManualLottoCount(3);
        List<List<Integer>> manualLottoNumbers = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );

        // when
        Manuals manuals = new Manuals(manualLottoNumbers, new LottoMoney(manualLottoCount));

        // then
        Assertions.assertThat(manuals.getManualCount()).isEqualTo(3);
    }

}