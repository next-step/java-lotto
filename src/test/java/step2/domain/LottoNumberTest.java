package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step2.domain.LottoNumber.LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호는 1이상 45 이하의 숫자여야 한다.")
    void assertNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(46);
        }).withMessage(LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE);
    }
}
