package lotto.model;

import lotto.exception.DuplicateLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WinningLottoTest {

    @DisplayName("당첨 번호를 생성합니다.")
    @Test
    void generateWinningLotto() {
        String numbers = "1,2,3,4,5,6";
        int bonus = 7;

        WinningLotto winningLotto = WinningLotto.generate(numbers, bonus);
        assertThat(winningLotto).isNotNull();
    }

    @DisplayName("보너스 번호가 중복일 시 에러")
    @Test
    void generateDuplicateBonusNumberThenFail() {
        String numbers = "1,2,3,4,5,6";
        int bonus = 6;
        assertThatExceptionOfType(DuplicateLottoNumberException.class)
                .isThrownBy(() -> WinningLotto.generate(numbers, bonus));
    }
}
