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
                .withMessage("보너스 번호는 당첨 번호와 중복 될 수 없습니다.");
    }
}