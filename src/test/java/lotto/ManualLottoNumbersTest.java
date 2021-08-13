package lotto;


import lotto.model.LottoNumberPicker;
import lotto.model.ManualLottoNumbers;
import lotto.util.LottoNumberUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ManualLottoNumbersTest {

    private static final String MANUAL_LOTTO_NUMBER = "1,2,3,4,5,6";

    @Test
    void 수동_생성_숫자_체크() {
        ManualLottoNumbers manualLottoNumbers = new ManualLottoNumbers();
        manualLottoNumbers.setManualLottoNumbers(Arrays.asList(MANUAL_LOTTO_NUMBER));
        for (String number : MANUAL_LOTTO_NUMBER.split(",")) {
            assertThatThrownBy(() -> {
                LottoNumberUtil.containsNumber(
                        manualLottoNumbers.getManualLottoNumbers()
                                .get(0)
                                .selectedNumber(),
                        LottoNumberPicker.pickNumber(Integer.parseInt(number)));
            }).isInstanceOf(IllegalArgumentException.class);
        }
    }

}
