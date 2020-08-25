package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.WinningLotto;
import static org.assertj.core.api.Assertions.*;

public class WinningLottoTest {

    @DisplayName("당첨번호 입력 오류")
    @Test
    void winningNumber_input_test() {
        assertThatThrownBy(() -> new WinningLotto("10, 20"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLotto(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
