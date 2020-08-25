package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.WinningLottoNumber;

import static org.assertj.core.api.Assertions.*;

public class WinningLottoNumberTest {

    @DisplayName("당첨번호 입력 오류 체크")
    @Test
    void winningNumber_input_test() {
        assertThatThrownBy(() -> new WinningLottoNumber("10, 20"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLottoNumber(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLottoNumber(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
