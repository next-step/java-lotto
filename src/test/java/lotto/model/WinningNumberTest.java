package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinningNumberTest {
    @Test
    @DisplayName("지난 주 당첨 번호가 6자리 입력 됐다면 참을 반환한다")
    void isSizeValidTrue() {
        WinningNumber winningNumber = WinningNumber.from("1, 2, 3, 4, 5, 6");
        Assertions.assertThat(winningNumber.isSizeValid()).isTrue();
    }

    @Test
    @DisplayName("지난 주 당첨 번호가 6자리가 아니라면 거짓을 반환한다")
    void isSizeValidFalse() {
        WinningNumber winningNumber = WinningNumber.from("1, 2, 3, 4, 5, 6, 7");
        Assertions.assertThat(winningNumber.isSizeValid()).isFalse();
    }

    @Test
    @DisplayName("읽기 전용 컬렉션을 반환한다")
    void read() {
        WinningNumber winningNumber = WinningNumber.from("1, 2, 3, 4, 5, 6");
        List<Integer> read = winningNumber.read();
        Assertions.assertThat(read.size()).isEqualTo(6);
        Assertions.assertThat(read).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
