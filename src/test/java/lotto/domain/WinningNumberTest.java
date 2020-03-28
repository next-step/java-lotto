package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberTest {

    @DisplayName("보너스 번호가 일치하면 true 반환한다")
    @Test
    public void bonusNumberMatchTrueTest() {
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 7));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        boolean isMatchBonusNumber = winningNumber.isMatchBonusNumber(lottoNumber);

        assertThat(isMatchBonusNumber).isTrue();
    }

    @DisplayName("보너스 번호가 일치하지 않으면 false 반환한다")
    @Test
    public void bonusNumberMatchFalseTest() {
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        boolean isMatchBonusNumber = winningNumber.isMatchBonusNumber(lottoNumber);

        assertThat(isMatchBonusNumber).isFalse();
    }

}
