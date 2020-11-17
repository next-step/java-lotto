package lotto;

import lotto.domain.Amount;
import lotto.exception.IllegalInputAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AmountTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100})
    @DisplayName("amount의 0이하가 입력된 경우 throw IllegalInputAmountException")
    void negativeAmountInputTest(int inputAmount) {
        assertThatExceptionOfType(IllegalInputAmountException.class)
                .isThrownBy(() -> Amount.valueOf(inputAmount))
                .withMessage(Amount.INVALID_AMOUNT_ERR_MSG);
    }
}
