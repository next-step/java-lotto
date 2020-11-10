package lotto.lib;

import lotto.asset.ExceptionConst;
import lotto.exception.NanException;
import lotto.exception.NegativeMoneyException;
import lotto.exception.NpeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MoneyValidatorTest {

    @ParameterizedTest
    @DisplayName("금액이 0보다 작으면, Exception 이 발생한다.")
    @CsvSource(value = {"-1$true", "1$false"}, delimiter = '$')
    public void intValidateMoney(int money, boolean negative) {
        if (negative) {
            assertThatExceptionOfType(NegativeMoneyException.class)
                    .isThrownBy(() -> MoneyValidator.validateMoney(money))
                    .withMessage(ExceptionConst.NEGATIVE_MONEY_MSG);
            return;
        }
        Assertions.assertDoesNotThrow(() -> MoneyValidator.validateMoney(money));
    }

    @ParameterizedTest
    @DisplayName("0보다 작은 문자이면, Exception 이 발생한다.")
    @CsvSource(value = {"-1$true", "1$false"}, delimiter = '$')
    public void strValidateMoney(String money, boolean negative) {
        if (negative) {
            assertThatExceptionOfType(NegativeMoneyException.class)
                    .isThrownBy(() -> MoneyValidator.validateMoney(money))
                    .withMessage(ExceptionConst.NEGATIVE_MONEY_MSG);
            return;
        }
        Assertions.assertDoesNotThrow(() -> MoneyValidator.validateMoney(money));
    }

    @Test
    @DisplayName("숫자가 아닌 money 이면, Exception 이 발생한다.")
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
