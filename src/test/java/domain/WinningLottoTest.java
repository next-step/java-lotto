package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @DisplayName("WinningLotto를 만든다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "6,5,4,3,2,1"})
    void of(String input) {
        WinningLotto winningLotto = WinningLotto.of(input, 7);

        assertThat(winningLotto).isEqualTo(WinningLotto.of("1,2,3,4,5,6", 7));
    }

    @DisplayName("유효하지 않은 번호로 WinningLotto를 만든면 Exception 발생")
    @ParameterizedTest
    @ValueSource(strings = {"test", "1,2", "-1,2,3,4,5,6", "0,1,2,3,4,5", "2,3,4,5,6,7", "46,47,48,49,50,51", "1,2,3,4,5,6,8"})
    void of_invalidNumbers(String input) {
        assertThatThrownBy(() -> WinningLotto.of(input, 7))
                .isInstanceOf(RuntimeException.class);
    }
}
