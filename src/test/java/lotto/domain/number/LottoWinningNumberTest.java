package lotto.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinningNumberTest {

    @DisplayName("당첨 번호와 보너스 번호가 중복 되는 것이 있으면 IllegalArgumentException throw")
    @Test
    void winningNumberDuplicateBonusNumberThrowException() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 5;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoWinningNumber(winningNumbers, bonusNumber))
                .withMessage("보너스 번호는 당첨 번호와 중복 될 수 없습니다. - " + bonusNumber);
    }

    @DisplayName("당첨 번호의 갯수가 6개가 아니면 IllegalArgumentException throw")
    @Test
    void lessOrMoreNumberThrowException() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int bonusNumber = 8;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoWinningNumber(winningNumbers, bonusNumber))
                .withMessage("로또 번호는 6개만 가능합니다. - " + winningNumbers);
    }

    @DisplayName("당첨 번호가 중복되는 값이 있다면 IllegalArgumentException throw")
    @Test
    void duplicatedWinningNumberThrowException() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 3, 4, 5);
        int bonusNumber = 8;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoWinningNumber(winningNumbers, bonusNumber))
                .withMessageContaining("로또 번호는 중복 될 수 없습니다.");
    }
}