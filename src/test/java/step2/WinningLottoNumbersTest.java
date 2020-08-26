package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.WinningLottoNumbers;

import static org.assertj.core.api.Assertions.*;

public class WinningLottoNumbersTest {

    @DisplayName("당첨번호 입력 오류 체크")
    @Test
    void winningNumber_input_test() {
        assertThatThrownBy(() -> new WinningLottoNumbers("10, 20"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLottoNumbers(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLottoNumbers(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
