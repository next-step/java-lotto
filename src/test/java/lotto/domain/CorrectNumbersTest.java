package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CorrectNumbersTest {

    @DisplayName("생성 테스트")
    @Test
    void 생성자() {
        // given
        BonusNumber bonusNumber = new BonusNumber("7");
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");

        // when
        CorrectNumbers correctNumbers = new CorrectNumbers(winningNumbers, bonusNumber);

        // then
        assertThat(correctNumbers.getWinningNumbers()).isEqualTo(winningNumbers);
        assertThat(correctNumbers.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("중복 테스트")
    @Test
    void Duplicate() {
        // given
        BonusNumber bonusNumber = new BonusNumber("6");
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");

        // then
        assertThrows(IllegalArgumentException.class,
            () -> new CorrectNumbers(winningNumbers, bonusNumber));
    }
}
