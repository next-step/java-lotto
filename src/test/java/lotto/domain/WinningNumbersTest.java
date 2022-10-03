package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WinningNumbersTest {

    @Test
    @DisplayName("로또가 보너스 번호를 갖고 있으면 true")
    void lotto_contain_bonus() {
        //given
        String[] winningNumber = {"10", "23", "44", "1", "3", "19"};
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber, 7);
        //when
        String[] lottoNumbers = {"10", "23", "44", "1", "3", "7"};
        Lotto lotto = new Lotto(lottoNumbers);
        //then
        assertThat(winningNumbers.matchBonus(lotto)).isTrue();
    }

    @Test
    @DisplayName("로또가 보너스 번호를 갖고 있지 않으면 false")
    void lotto_not_contain_bonus() {
        //given
        String[] winningNumber = {"10", "23", "44", "1", "3", "19"};
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber, 33);
        //when
        String[] lottoNumbers = {"10", "23", "44", "1", "3", "7"};
        Lotto lotto = new Lotto(lottoNumbers);
        //then
        assertThat(winningNumbers.matchBonus(lotto)).isFalse();
    }

    @Test
    @DisplayName("당첨번호와 로또 번호가 중복되면 에러")
    void winningNumber_duplicate_bonus() {
        //given
        String[] winningNumber = {"1", "2", "3", "4", "5", "6"};
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumbers(winningNumber, 6));
    }
    @Test
    @DisplayName("당첨번호와 로또 번호가 중복되지 않으면 정상")
    void winningNumber_not_duplicate_bonus() {
        //given
        String[] winningNumber = {"1", "2", "3", "4", "5", "6"};
        //then
        assertThatNoException().isThrownBy(() -> new WinningNumbers(winningNumber, 7));
    }
}