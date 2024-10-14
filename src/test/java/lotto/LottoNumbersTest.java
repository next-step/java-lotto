package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Rank;
import lotto.domain.WinNumber;

class LottoNumbersTest {

    @Test
    void 생성() {
        List<LottoNumber> numbers = List.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
        );

        LottoNumbers lottoNumbers = new LottoNumbers(numbers);

        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 로또_번호는_중복될_수_없다() {
        assertThatThrownBy(() -> new LottoNumbers(1, 2, 2, 3, 4, 5))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또는_6자리여야_한다() {
        assertThatThrownBy(() -> new LottoNumbers(1, 2, 2))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoNumbers(1, 2, 3, 4, 5, 6, 7))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_주어진_숫자가_있는지_확인해서_Rank를_반환한다() {
        LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
        WinNumber winNumber = new WinNumber(1, 2, 3, 7, 8, 9);
        winNumber.addBonus(new BonusNumber(45));

        Rank matchedRank = lottoNumbers.calculateRank(winNumber);

        assertThat(matchedRank).isEqualTo(Rank.THREE);
    }

    @Test
    void 로또_번호에_주어진_숫자가_있는지_확인한다() {
        LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);

        boolean result = lottoNumbers.contains(new LottoNumber(2));

        assertThat(result).isTrue();
    }

    @Test
    void LottoNumbers에서_번호를_뽑는다() {
        LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);

        LottoNumbers result = lottoNumbers.pickNumbers();

        assertThat(result).isEqualTo(new LottoNumbers(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 번호4개와_보너스_번호가_맞다면_2등이다() {
        LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
        WinNumber winNumber = new WinNumber(new LottoNumbers(1, 2, 3, 4, 7, 8), new BonusNumber(6));

        Rank matchedRank = lottoNumbers.calculateRank(winNumber);

        assertThat(matchedRank).isEqualTo(Rank.SECOND);
    }
}
