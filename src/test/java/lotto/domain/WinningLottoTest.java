package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @DisplayName("당첨 로또 번호 예외 확인")
    @Test
    void shouldExceptionWinningLotto() {
        assertThatThrownBy(() -> WinningLotto.of(Arrays.asList(1,2,3,4,5,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번 예외 확인")
    @Test
    void shouldExceptionWithMessageWinningLotto() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Lotto.of(Arrays.asList(1,2,3,4,5,5)))
                .withMessage("로또 개수는 6개 입니다.");
    }
}
