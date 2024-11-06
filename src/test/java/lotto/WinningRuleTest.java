package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.WinningRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningRuleTest {

    @Test
    @DisplayName("보너스 번호와 함께 로또 당첨 결과를 확인한다. 보너스 번호 당첨")
    void testWinningNumbersCountWithBonus() {
        LottoNumbers winningNumbers = new LottoNumbers("1, 2, 3, 4, 5, 6");
        LottoNumbers orderNumbers = new LottoNumbers("1, 2, 3, 4, 5, 7");
        LottoNumber bonusNumber = new LottoNumber(7);

        WinningRule result = WinningRule.match(winningNumbers, orderNumbers, bonusNumber);
        assertThat(result).isEqualTo(WinningRule.FIVE_BONUS);
    }

    @Test
    @DisplayName("보너스 번호와 함께 로또 당첨 결과를 확인한다. 보너스 번호 미당첨")
    void testWinningNumbersCount() {
        LottoNumbers winningNumbers = new LottoNumbers("1, 2, 3, 4, 5, 6");
        LottoNumbers orderNumbers = new LottoNumbers("1, 2, 3, 4, 5, 7");
        LottoNumber bonusNumber = new LottoNumber(8);

        WinningRule result = WinningRule.match(winningNumbers, orderNumbers, bonusNumber);
        assertThat(result).isEqualTo(WinningRule.FIVE);
    }
}
