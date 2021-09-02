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

    @DisplayName("당첨결과가 모두 일치하면 일등이다.")
    @Test
    void matchCountTest() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningNumbers.match(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)))).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("5개의 수와 보너스번호가 일치하면 2등이다.")
    @Test
    void bonusNumberCheckTest() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningNumbers.match(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7)))).isEqualTo(LottoRank.SECOND);
    }
}
