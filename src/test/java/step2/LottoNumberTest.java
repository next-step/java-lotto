package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {
    @Test
    @DisplayName("로또 번호가 1-45사이가 아닐 경우 Exception을 발생한다.")
    void validateLottoNumber() {
        int lottoNumber = 0;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(lottoNumber);
        }).withMessage(LottoNumber.LOTTO_NUMBER_RANGE_ERROR);
    }
}
