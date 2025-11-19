package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {

    @Test
    void 로또_번호와_보너스_번호로_생성한다() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(7);

        WinningNumbers winningNumbers = new WinningNumbers(lotto, bonusNumber);

        assertThat(winningNumbers.getLotto()).isEqualTo(lotto);
        assertThat(winningNumbers.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복이면_예외를_발생시킨다() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(6);

        assertThatThrownBy(() -> new WinningNumbers(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    void 특정_번호가_당첨_번호에_포함되는지_확인() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningNumbers winningNumbers = new WinningNumbers(lotto, bonusNumber);

        assertThat(winningNumbers.containsInLotto(new LottoNumber(1))).isTrue();
        assertThat(winningNumbers.containsInLotto(new LottoNumber(10))).isFalse();
    }

    @Test
    void 특정_번호가_보너스_번호와_일치하는지_확인() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningNumbers winningNumbers = new WinningNumbers(lotto, bonusNumber);

        assertThat(winningNumbers.matchBonus(new LottoNumber(7))).isTrue();
        assertThat(winningNumbers.matchBonus(new LottoNumber(1))).isFalse();
    }
}
