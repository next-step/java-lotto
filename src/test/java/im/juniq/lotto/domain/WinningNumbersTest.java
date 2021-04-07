package im.juniq.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Test
    @DisplayName("당첨번호에 포함되는 숫자인지 확인")
    void existWinningNumber() {
        assertThat(new WinningNumbers(numbers, 7).matchedCount(new LottoNumbers(numbers))).isEqualTo(6);
    }

    @Test
    @DisplayName("보너스번호와 일치하는 숫자인지 확인")
    void matchedBonusNumber() {
        assertThat(new WinningNumbers(numbers, 7).matchedBonusNumber(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7))))
            .isEqualTo(true);
        assertThat(new WinningNumbers(numbers, 7).matchedBonusNumber(new LottoNumbers(numbers))).isEqualTo(false);
    }

    @Test
    @DisplayName("로또 숫자는 중복 될 수 없다.")
    void checkDuplicate() {
        assertThatThrownBy(() -> new WinningNumbers(numbers, 6)).isInstanceOf(IllegalArgumentException.class);
    }
}
