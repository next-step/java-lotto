package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static lotto.domain.LottoNumber.convertToLottoNumber;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    public void 생성된_로또에_대해_조작연산을_진행하면_예외_발생() {
        Lotto lotto = Lotto.of(convertToLottoNumber(List.of(1, 2, 3, 4, 5, 6)));
        Set<LottoNumber> lottoNumbers = lotto.getLottoNumbers();

        assertThatThrownBy(() -> lottoNumbers.add(new LottoNumber(7)))
                .isInstanceOf(UnsupportedOperationException.class);

        assertThatThrownBy(() -> lottoNumbers.remove(new LottoNumber(1)))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
