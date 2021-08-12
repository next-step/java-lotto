package lotto;

import lotto.model.LottoNumber;
import lotto.model.LottoNumberPicker;
import lotto.model.LottoNumbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoNumberPickerTest {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    private static final int TEST_LOTTO_NUMBER = 12;


    @Test
    void 로또_숫자_1부터_45까지() {
        for (LottoNumber lottoNumber : LottoNumberPicker.pickNumber()) {
            assertThat(lottoNumber.getLottoNumber())
                    .isGreaterThanOrEqualTo(LOTTO_START_NUMBER)
                    .isLessThanOrEqualTo(LOTTO_END_NUMBER);
        }
    }

    @Test
    void 로또_숫자_객체_체크() {
        assertThat(LottoNumberPicker.pickNumber(TEST_LOTTO_NUMBER))
                .isEqualTo(LottoNumberPicker.pickNumber(TEST_LOTTO_NUMBER));
    }
}
