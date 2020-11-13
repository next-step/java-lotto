package lotto.utils.validator;

import lotto.asset.ExceptionConst;
import lotto.exception.BadDividerException;
import lotto.exception.NanException;
import lotto.exception.NpeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class DividerValidatorTest {

    @ParameterizedTest
    @DisplayName("0보다 작거나 같으면, Exception 이 발생한다.")
    @CsvSource(value = {"-1$true", "0$true", "1$false"}, delimiter = '$')
    public void intValidateDivider(int divider, boolean negative) {
        if (negative) {
            assertThatExceptionOfType(BadDividerException.class)
                    .isThrownBy(() -> DividerValidator.validateDivider(divider))
                    .withMessage(ExceptionConst.BAD_DIVIDER_MSG);
            return;
        }
        Assertions.assertDoesNotThrow(() -> DividerValidator.validateDivider(divider));
    }

    @ParameterizedTest
    @DisplayName("0보다 작은 문자이면, Exception 이 발생한다.")
    @CsvSource(value = {"-1$true", "1$false"}, delimiter = '$')
    public void strValidateDivider(String divider, boolean negative) {
        if (negative) {
            assertThatExceptionOfType(BadDividerException.class)
                    .isThrownBy(() -> DividerValidator.validateDivider(divider))
                    .withMessage(ExceptionConst.BAD_DIVIDER_MSG);
            return;
        }
        Assertions.assertDoesNotThrow(() -> DividerValidator.validateDivider(divider));
    }

    @Test
    @DisplayName("숫자가 아니면, Exception 이 발생한다.")
    public void strValidateDivider() {
        Assertions.assertAll(
                () -> assertThatExceptionOfType(NpeException.class)
                        .isThrownBy(() -> DividerValidator.validateDivider(null))
                        .withMessage(ExceptionConst.NPE_MSG),
                () -> assertThatExceptionOfType(NanException.class)
                        .isThrownBy(() -> DividerValidator.validateDivider("NAN"))
                        .withMessage(ExceptionConst.NAN_MSG)
        );
    }
}
