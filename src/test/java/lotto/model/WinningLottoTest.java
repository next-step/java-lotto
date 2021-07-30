package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinningLottoTest {
    @Test
    @DisplayName("지난 주 당첨 번호가 6자리 입력 됐다면 참을 반환한다")
    void isSizeValidTrue() {
        WinningLotto winningLotto = WinningLotto.from("1, 2, 3, 4, 5, 6");
        Assertions.assertThat(winningLotto.isSizeValid()).isTrue();
    }

    @Test
    @DisplayName("지난 주 당첨 번호가 6자리가 아니라면 거짓을 반환한다")
    void isSizeValidFalse() {
        WinningLotto winningLotto = WinningLotto.from("1, 2, 3, 4, 5, 6, 7");
        Assertions.assertThat(winningLotto.isSizeValid()).isFalse();
    }
}
