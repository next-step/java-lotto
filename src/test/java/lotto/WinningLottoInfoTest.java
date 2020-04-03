package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoInfoTest {

    @DisplayName("당첨번호와 보너스볼이 중복되면 익셉션을 발생시킨다.")
    @Test
    void validateBonusBall() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningLottoInfo(1, "1,2,3,4,5,6");
        });
    }
}
