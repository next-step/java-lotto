package lottogame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoNumberTest {
    private WinningLottoNumber winningLottoNumber;
    private int bonusNum = 6;
    private String winningNum = "1,2,3,4,5,6";

    @Test
    void 당첨번호_유효성_체크() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    winningLottoNumber = new WinningLottoNumber("1,2,3,4,5,6,7", bonusNum);
                });
    }

    @Test
    void 보너스번호_유효성_체크() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    winningLottoNumber = new WinningLottoNumber(winningNum, -7);
                });
    }

    @Test
    void 당첨번호_보너스번호_중복_체크() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    winningLottoNumber = new WinningLottoNumber(winningNum, bonusNum);
                });
    }
}