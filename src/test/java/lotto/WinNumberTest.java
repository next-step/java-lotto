package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
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
    void 당첨_번호_숫자에_주어진_숫자가_있는지_확인한다() {
        WinNumber winNumber = new WinNumber(1, 2, 3, 4, 5, 6);

        boolean result = winNumber.contains(new LottoNumber(2));

        assertThat(result).isTrue();
    }
}
