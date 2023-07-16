package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class ManualLottoCountTest {

    @Test
    @DisplayName("수동으로 구매할 수 있는 로또 개수는 음수이면 안된다.")
    void 수동_개수_음수_X() {
        // given , when , then
        assertThatCode(() -> new ManualLottoCount(-2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수동으로 구매할 수 있는 개수는 양수여야합니다.");
    }

    @Test
    @DisplayName("수동으로 구매할 수 있는 로또 개수는 양수여야한다.")
    void 수동_개수_양수() {
        // given , when
        ManualLottoCount manualLottoCount = new ManualLottoCount(3);

        // then
        assertThat(manualLottoCount.getManualCount()).isEqualTo(3);
    }
}