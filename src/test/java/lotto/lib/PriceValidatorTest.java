package lotto.lib;

import lotto.asset.ExceptionConst;
import lotto.exception.NanException;
import lotto.exception.BadPriceException;
import lotto.exception.NpeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PriceValidatorTest {

    @ParameterizedTest
    @DisplayName("0보다 작거나 같으면, Exception 이 발생한다.")
    @CsvSource(value = {"-1$true", "0$true", "1$false"}, delimiter = '$')
    public void intValidatePrice(int price, boolean negative) {
        if (negative) {
            assertThatExceptionOfType(BadPriceException.class)
                    .isThrownBy(() -> PriceValidator.validatePrice(price))
                    .withMessage(ExceptionConst.BAD_PRICE_MSG);
            return;
        }
        Assertions.assertDoesNotThrow(() -> PriceValidator.validatePrice(price));
    }

    @ParameterizedTest
    @DisplayName("0보다 작은 문자이면, Exception 이 발생한다.")
    @CsvSource(value = {"-1$true", "1$false"}, delimiter = '$')
    public void strValidatePrice(String price, boolean negative) {
        if (negative) {
            assertThatExceptionOfType(BadPriceException.class)
                    .isThrownBy(() -> PriceValidator.validatePrice(price))
                    .withMessage(ExceptionConst.BAD_PRICE_MSG);
            return;
        }
        Assertions.assertDoesNotThrow(() -> PriceValidator.validatePrice(price));
    }

    @Test
    @DisplayName("숫자가 아니면, Exception 이 발생한다.")
    public void strValidatePrice() {
        Assertions.assertAll(
                () -> assertThatExceptionOfType(NpeException.class)
                        .isThrownBy(() -> PriceValidator.validatePrice(null))
                        .withMessage(ExceptionConst.NPE_MSG),
                () -> assertThatExceptionOfType(NanException.class)
                        .isThrownBy(() -> PriceValidator.validatePrice("NAN"))
                        .withMessage(ExceptionConst.NAN_MSG)
        );
    }
}
