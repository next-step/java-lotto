package lotto.utils.validator;

import lotto.asset.ExceptionConst;
import lotto.exception.NanException;
import lotto.exception.BadMoneyException;
import lotto.exception.NpeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MoneyValidatorTest {

    @ParameterizedTest
    @DisplayName("0보다 작거나 같으면, Exception 이 발생한다.")
    @CsvSource(value = {"-1$true", "0$true", "1$false"}, delimiter = '$')
    public void intValidateMoney(int money, boolean negative) {
        if (negative) {
            assertThatExceptionOfType(BadMoneyException.class)
                    .isThrownBy(() -> MoneyValidator.validateMoney(money))
                    .withMessage(ExceptionConst.BAD_MONEY_MSG);
            return;
        }
        Assertions.assertDoesNotThrow(() -> MoneyValidator.validateMoney(money));
    }

    @ParameterizedTest
    @DisplayName("0보다 작은 문자이면, Exception 이 발생한다.")
    @CsvSource(value = {"-1$true", "1$false"}, delimiter = '$')
    public void strValidateMoney(String money, boolean negative) {
        if (negative) {
            assertThatExceptionOfType(BadMoneyException.class)
                    .isThrownBy(() -> MoneyValidator.validateMoney(money))
                    .withMessage(ExceptionConst.BAD_MONEY_MSG);
            return;
        }
        Assertions.assertDoesNotThrow(() -> MoneyValidator.validateMoney(money));
    }

    @Test
    @DisplayName("숫자가 아니면, Exception 이 발생한다.")
    public void strValidateMoney() {
        Assertions.assertAll(
                () -> assertThatExceptionOfType(NpeException.class)
                        .isThrownBy(() -> MoneyValidator.validateMoney(null))
                        .withMessage(ExceptionConst.NPE_MSG),
                () -> assertThatExceptionOfType(NanException.class)
                        .isThrownBy(() -> MoneyValidator.validateMoney("NAN"))
                        .withMessage(ExceptionConst.NAN_MSG)
        );
    }
}
