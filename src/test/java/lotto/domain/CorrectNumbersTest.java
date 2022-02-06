package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CorrectNumbersTest {

    @DisplayName("당첨 번호와 보너스 번호를 받아 객체를 생성한다.")
    @Test
    void Given_당첨번호_보너스_번호_When_객체_생성_Then_당첨번호와_보너스_번호를_가짐() {
        // given
        final BonusNumber bonusNumber = new BonusNumber("7");
        final WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");

        // when
        final CorrectNumbers correctNumbers = new CorrectNumbers(winningNumbers, bonusNumber);

        // then
        assertThat(correctNumbers.getWinningNumbers()).isEqualTo(winningNumbers);
        assertThat(correctNumbers.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("당첨 번호들과 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void 당첨번호_보너스_번호_When_객체_생성_Then_예외_발생() {
        // given
        final BonusNumber bonusNumber = new BonusNumber("6");
        final WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");

        // then
        assertThrows(IllegalArgumentException.class,
                () -> new CorrectNumbers(winningNumbers, bonusNumber));
    }
}
