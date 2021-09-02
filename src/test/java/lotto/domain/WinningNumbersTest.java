package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @DisplayName("보너스 숫자는 당첨 숫자와 동일하면 안된다.")
    @Test
    void bonusNumberDuplicationTest() {
        Assertions.assertThatThrownBy(() -> new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 6))
                  .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("3개가 동일한 숫자일때 3을 리턴한다.")
    @Test
    void matchCountTest() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningNumbers.checkMatchCount(new LottoNumbers(Arrays.asList(1, 2, 3, 7, 8, 9))))
            .isEqualTo(3);
    }

    @DisplayName("보너스 값이 일치하면 true를 리턴한다.")
    @Test
    void bonusNumberCheckTest() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        assertThat(
            winningNumbers.checkBonusNumber(
                new LottoNumbers(Arrays.asList(1, 2, 3, 7, 8, 9)))).isEqualTo(true);
    }
}
