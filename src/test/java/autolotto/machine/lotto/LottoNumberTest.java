package autolotto.machine.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoNumberTest {
    @Test
    void 숫자_1_과_45_사이의_값이_아닌_값으로_생성자_호출시_실패한다() {
        int invalidNumber = 47;

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(invalidNumber));
    }
}
