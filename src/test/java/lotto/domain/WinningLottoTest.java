package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {

    @Test
    @DisplayName("정상적인 입력을 할 경우 당첨번호가 정상 생성된다.")
    void createWinningLotto() {
        String inputString = "1,2,3,4,5,6";

        assertThat(WinningLotto.createWinningNumbers(inputString)).isEqualTo(WinningLotto.createWinningNumbers(inputString));
    }

    @Test
    @DisplayName("중복된 숫자를 입력할 경우 당첨번호 생성에 오류가 발생한다.")
    void createWinningLotto_중복() {
        String inputString = "1,2,3,4,6,6";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.createWinningNumbers(inputString))
                .withMessage("로또의 숫자는 중복없이 6개여야 합니다.");
    }

    @Test
    @DisplayName("6자리 미만의 숫자를 입력할 경우 당첨번호 생성에 오류가 발생한다.")
    void createLotto_6자리미만() {
        String inputString = "1,2,3,4,6";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.createWinningNumbers(inputString))
                .withMessage("로또의 숫자는 중복없이 6개여야 합니다.");
    }

    @Test
    @DisplayName("1 ~ 45 자리 외의 숫자로 당첨번호 생성시 오류가 발생한다.")
    void createLotto_범위초과() {
        String inputString = "1,2,3,4,5,99";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.createWinningNumbers(inputString))
                .withMessage("로또의 번호 범위를 벗어났습니다.");
    }
}