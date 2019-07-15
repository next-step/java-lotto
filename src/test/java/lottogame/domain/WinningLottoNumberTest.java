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
                }).withMessage("로또 번호의 입력이 잘못되었습니다. 다시 프로그램을 실행해주세요.");
    }

    @Test
    void 보너스번호_유효성_체크() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    winningLottoNumber = new WinningLottoNumber(winningNum, -7);
                }).withMessage("보너스볼 번호가 잘못입력되었습니다. 다시 실행 후 올바른 숫자를 입력해주세요.");
    }

    @Test
    void WinningNumberAndbonusDuplicate_check() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    winningLottoNumber = new WinningLottoNumber(winningNum, bonusNum);
                });
    }
}