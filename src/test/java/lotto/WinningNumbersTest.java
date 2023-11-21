package lotto;

import lotto.domain.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class WinningNumbersTest {

    @DisplayName("당첨 숫자 6개를 전달하면 winningNumbers 객체를 생성한다.")
    @Test
    void winningNumbersCreateTest() {
        WinningNumbers winningNumbers = new WinningNumbers(WinningNumbers.createList("1, 2, 3, 4, 5, 6"));

        assertThat(winningNumbers).isInstanceOf(WinningNumbers.class);
    }

    @DisplayName("생성된 winningNumbers의 리스트를 가져올 수 있다.")
    @Test
    void getWinningNumbersTest() {
        WinningNumbers winningNumbers = new WinningNumbers(WinningNumbers.createList("1, 3, 5, 7, 9, 11"));

        assertThat(winningNumbers.getList().size()).isEqualTo(6);
    }
}