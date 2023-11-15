package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {

    @Test
    @DisplayName("정상적인 입력을 할 경우 당첨번호가 정상 생성된다.")
    void createWinningLotto() {
        String inputString = "1,2,3,4,5,6";
        int bonusNumber = 7;

        assertThat(WinningLotto.createWinningNumbers(inputString, bonusNumber)).isEqualTo(WinningLotto.createWinningNumbers(inputString, bonusNumber));
    }

    @Test
    @DisplayName("중복된 숫자를 입력할 경우 당첨번호 생성에 오류가 발생한다.")
    void createWinningLotto_중복() {
        String inputString = "1,2,3,4,6,6";
        int bonusNumber = 7;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.createWinningNumbers(inputString, bonusNumber))
                .withMessage("로또의 숫자는 중복없이 6개여야 합니다.");
    }

    @Test
    @DisplayName("6자리 미만의 숫자를 입력할 경우 당첨번호 생성에 오류가 발생한다.")
    void createLotto_6자리미만() {
        String inputString = "1,2,3,4,6";
        int bonusNumber = 7;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.createWinningNumbers(inputString, bonusNumber))
                .withMessage("로또의 숫자는 중복없이 6개여야 합니다.");
    }

    @Test
    @DisplayName("1 ~ 45 자리 외의 숫자로 당첨번호 생성시 오류가 발생한다.")
    void createLotto_범위초과() {
        String inputString = "1,2,3,4,5,99";
        int bonusNumber = 7;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.createWinningNumbers(inputString, bonusNumber))
                .withMessage("로또의 번호 범위를 벗어났습니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨번호에 중복될 경우 오류가 발생한다.")
    void createLotto_당첨번호_보너스번호_중복() {
        String inputString = "1,2,3,4,5,6";
        int bonusNumber = 6;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.createWinningNumbers(inputString, bonusNumber))
                .withMessage("기존 당첨번호와 중복된 번호는 입력할 수 없습니다.");
    }

    @ParameterizedTest(name = "범위(1~45)를 벗어난 로또번호{0} 생성시 오류가 발생한다.")
    @ValueSource(ints = {0, 46})
    @DisplayName("보너스 번호가 로또번호(1~45) 범위를 벗어날 경우 오류가 발생한다.")
    void createLotto_당첨번호_보너스번호_범위오류(int wrongNumber) {
        String inputString = "1,2,3,4,5,6";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.createWinningNumbers(inputString, wrongNumber))
                .withMessage("로또의 번호 범위를 벗어났습니다.");
    }
}