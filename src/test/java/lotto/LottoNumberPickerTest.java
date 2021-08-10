package lotto;

import lotto.model.LottoNumberPicker;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoNumberPickerTest {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;


    @Test
    void 로또_숫자_1부터_45까지() {
        assertThat(LottoNumberPicker.getNumber())
                .isGreaterThanOrEqualTo(LOTTO_START_NUMBER)
                .isLessThanOrEqualTo(LOTTO_END_NUMBER);
    }

}
