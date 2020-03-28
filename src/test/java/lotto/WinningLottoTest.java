package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨 로또번호 생성 테스트")
    void createWinningLotooTest() {
        assertThat(
                new WinningLotto("1, 2, 3, 4, 5, 6")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6, 7", "1, 2, 3, 4, 5"})
    @DisplayName("당첨 로또번호 생성 실패(6자리) 테스트")
    void validateSixNumberWinningLottoTest(String input) {
        assertThatThrownBy(
                () -> new WinningLotto(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, a, d, 5, 6", "1, 2, 3, 4, 5, r"})
    @DisplayName("당첨 로또번호 생성 실패(숫자) 테스트")
    void validateNumberWinningLottoTest(String input) {
        assertThatThrownBy(
                () -> new WinningLotto(input)
        ).isInstanceOf(RuntimeException.class);
    }
}
