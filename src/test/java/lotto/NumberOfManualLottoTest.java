package lotto;

import lotto.dto.Amount;
import lotto.dto.NumberOfManualLotto;
import lotto.exception.OverAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NumberOfManualLottoTest {
    @ParameterizedTest
    @CsvSource(value = {"1000,2", "2000,3", "500,1"})
    @DisplayName("입력된 amount로 구입할 수 있는 로또 갯수보다 수동 로또 갯수를 많이 입력한 경우 throw exception")
    void numberOfManualLottoInputTest(int inputAmount, int inputNumberOfManualLotto) {
        Amount amount = Amount.valueOf(inputAmount);
        NumberOfManualLotto numberOfManualLotto = NumberOfManualLotto.valueOf(inputNumberOfManualLotto);

        assertThatExceptionOfType(OverAmountException.class)
                .isThrownBy(() -> numberOfManualLotto.validateSize(amount))
                .withMessage(NumberOfManualLotto.INVALID_SIZE_ERR_MSG);
    }
}
