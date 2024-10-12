package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

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
    void 로또_번호에_주어진_숫자가_있는지_확인해서_개수를_반환한다() {
        LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);

        int count = lottoNumbers.calculateMatchCount(new LottoNumbers(2, 1, 6, 11, 12, 13));

        assertThat(count).isEqualTo(3);
    }

    @Test
    void LottoNumbers에서_번호를_뽑는다() {
        LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);

        LottoNumbers result = lottoNumbers.pickNumbers();

        assertThat(result).isEqualTo(new LottoNumbers(1, 2, 3, 4, 5, 6));
    }
}
