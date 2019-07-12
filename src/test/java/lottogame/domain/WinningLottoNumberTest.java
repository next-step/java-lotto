package lottogame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoNumberTest {
    private WinningLottoNumber winningLottoNumber;
    private int bonusNum = 6;
    private String winningNum = "1,2,3,4,5,6";

    @Test
    void WinningNumber_check() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    winningLottoNumber = new WinningLottoNumber("1,2,3,4,5,6,7", bonusNum);
                });
    }

    @Test
    void BonussNumber_check() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    winningLottoNumber = new WinningLottoNumber(winningNum, -7);
                });
    }

    @Test
    void WinningNumberAndbonusDuplicate_check() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    winningLottoNumber = new WinningLottoNumber(winningNum, bonusNum);
                });
    }
}