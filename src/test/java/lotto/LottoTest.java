package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.generator.LottoGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    public void 생성된_로또_번호에_대해_조작연산을_진행하면_예외_발생() {
        List<LottoNumber> numbers = LottoGenerator.generateLotto().getLottoNumbers();
        assertThatThrownBy(() -> numbers.add(new LottoNumber(1)))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
