package lotto.domain;

import lotto.exception.InputError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("올바르지 않는 보너스 번호를 입력했을 때, throw exception")
    @Test
    void create_error() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningLotto(winningLotto, 3))
                .isInstanceOf(InputError.class);
        assertThatThrownBy(() -> new WinningLotto(winningLotto, 46))
                .isInstanceOf(InputError.class);
    }

}