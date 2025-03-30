package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static lotto.util.LottoNumberConverter.toLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    public void 생성된_로또에_대해_조작연산을_진행하면_예외_발생() {
        Lotto lotto = Lotto.of(toLottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
        Set<LottoNumber> lottoNumbers = lotto.getLottoNumbers();

        assertThatThrownBy(() -> lottoNumbers.add(LottoNumber.of(7)))
                .isInstanceOf(UnsupportedOperationException.class);

        assertThatThrownBy(() -> lottoNumbers.remove(LottoNumber.of(1)))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    public void 로또번호를_비교하여_일치하는_번호의_개수를_반환한다() {
        Lotto lotto1 = Lotto.of(toLottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
        Lotto lotto2 = Lotto.of(toLottoNumbers(List.of(4, 5, 6, 7, 8, 9)));

        assertThat(lotto1.countNumberMatchCount(lotto2.getLottoNumbers())).isEqualTo(3);
    }

    @Test
    public void 로또가_특정_번호를_갖고있는지_여부를_반환한다() {
        Lotto lotto = Lotto.of(toLottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.isNumberMatched(LottoNumber.of(3))).isTrue();
    }
}
