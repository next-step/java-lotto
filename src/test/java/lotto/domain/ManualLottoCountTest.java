package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ManualLottoCountTest {

    @Test
    @DisplayName("1 이상의 숫자를 주입하여 수동 로또 개수를 생성한다.")
    void createManualLottoCountTest() {
        // given
        String input = "1";

        // when
        ManualLottoCount manualLottoCount = new ManualLottoCount(input);

        // then
        assertThat(manualLottoCount).isEqualTo(new ManualLottoCount("1"));
    }

    @Test
    @DisplayName("0 이하의 숫자를 입력하는 경우 예외가 발생한다.")
    void underOneExceptionTest() {
        // given
        String input = "0";

        // when & then
        assertThatThrownBy(() -> new ManualLottoCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수동으로 구매할 로또 수는 0보다 작을 수 없습니다.");
    }

    @Test
    @DisplayName("숫자를 입력하지 않을 경우 예외가 발생한다.")
    void notNumberExceptionTest() {
        // given
        String input = "a";

        // when & then
        assertThatThrownBy(() -> new ManualLottoCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수동으로 구매할 로또 수는 숫자여야 합니다.");
    }
}
