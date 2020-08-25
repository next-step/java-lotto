package step2;

import com.sun.istack.internal.localization.NullLocalizable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.WinningLotto;

import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class WinningLottoTest {

    @DisplayName("당첨번호 입력 오류 체크")
    @Test
    void winningNumber_input_test() {
        assertThatThrownBy(() -> new WinningLotto("10, 20"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLotto(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLotto(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
