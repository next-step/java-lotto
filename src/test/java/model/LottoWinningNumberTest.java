package model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;

import org.junit.jupiter.api.Test;

class LottoWinningNumberTest {

    @Test
    void 당첨_번호에_보너스_번호가_포함되면_예외가_발생한다() {
        final WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        final BonusNumber bonusNumber = new BonusNumber(1);

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoWinningNumber(winningNumbers, bonusNumber));
    }
}
