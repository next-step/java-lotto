package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.WinningRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningRuleTest {

    @Test
    @DisplayName("로또 당첨 결과를 확인한다.")
    void testWinningNumbersCount() {
        LottoNumbers winningNumbers = new LottoNumbers("1, 2, 3, 4, 5, 6");
        LottoNumbers orderNumbers = new LottoNumbers("1, 2, 3, 4, 5, 7");
        WinningRule result = WinningRule.match(winningNumbers, orderNumbers);
        assertThat(result).isEqualTo(WinningRule.FIVE);
    }
}
