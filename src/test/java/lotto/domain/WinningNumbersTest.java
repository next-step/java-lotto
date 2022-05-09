package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumbersTest {

    @Test
    @DisplayName("당첨 번호 중 해당 번호가 포함되어 있는 지 확인")
    void checkNumber() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(3, 4, 10, 14, 35, 45), 2);
        assertThat(winningNumbers.checkNumber(3)).isEqualTo(1);
        assertThat(winningNumbers.checkNumber(33)).isEqualTo(0);
    }

    @Test
    @DisplayName("보너스 번호 당첨 여부 확인")
    void checkBonus() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(3, 4, 10, 14, 35, 45), 2);
        assertThat(winningNumbers.checkBonus(2)).isTrue();
    }

}