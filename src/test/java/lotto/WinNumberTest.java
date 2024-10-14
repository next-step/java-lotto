package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Rank;
import lotto.domain.WinNumber;

class WinNumberTest {

    @Test
    void 생성() {
        WinNumber winNumber = new WinNumber(new LottoNumbers(1, 2, 3, 4, 5, 6));

        assertThat(winNumber).isEqualTo(new WinNumber(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 당첨_번호는_6자리이다() {
        assertThatThrownBy(() -> new WinNumber(1, 2, 3, 4, 5, 6, 7))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_숫자는_중복될_수_없다() {
        assertThatThrownBy(() -> new WinNumber(1, 2, 3, 4, 5, 5))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_숫자는_1부터_45사이의_숫자다() {
        assertThatThrownBy(() -> new WinNumber(1, 2, 3, 47, 5, 6))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new WinNumber(0, 2, 3, 4, 5, 6))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_숫자에_주어진_숫자가_몇등인지_확인한다() {
        WinNumber winNumber = new WinNumber(new LottoNumbers(1, 2, 3, 4, 5, 6), new BonusNumber(8));

        Set<LottoNumber> numberSet = Set.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(7),
            new LottoNumber(8)
        );

        Rank calculatedRank = winNumber.calculateRank(new TreeSet<>(numberSet));

        assertThat(calculatedRank).isEqualTo(Rank.SECOND);
    }

    @Test
    void 보너스_번호를_당첨_로또에_추가한다() {
        WinNumber winNumber = new WinNumber(1, 2, 3, 4, 5, 6);

        winNumber.addBonus(new BonusNumber(10));

        assertThat(winNumber).isEqualTo(new WinNumber(new LottoNumbers(1, 2, 3, 4, 5, 6), new BonusNumber(10)));
    }

    @Test
    void 보너스_번호는_로또_번호와_중복될_수_없다() {
        WinNumber winNumber = new WinNumber(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> winNumber.addBonus(new BonusNumber(6)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
