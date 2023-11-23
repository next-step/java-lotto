package lotto;

import lotto.domain.LottoNo;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class LottoNoTest {

    @Test
    void 숫자_범위_예외() {
        int numberOver = 46;
        int numberUnder = 0;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNo(numberOver));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNo(numberUnder));
    }
}