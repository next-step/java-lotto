package lotto.lib;

import lotto.asset.ExceptionConst;
import lotto.exception.NanException;
import lotto.exception.NpeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GeneralValidatorTest {

    @ParameterizedTest
    @DisplayName("숫자가 아닌 String 이면 true 이다.")
    @CsvSource(value = {"0$false", "1$false", "NaN$true", "hello$true"}, delimiter = '$')
    void checkNan(String input, boolean expected) {
        assertThat(GeneralValidator.checkNan(input))
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자가 아니면, Exception 이 발생한다.")
    public void validateStrNum() {
        Assertions.assertAll(
                () -> assertThatExceptionOfType(NpeException.class)
                        .isThrownBy(() -> GeneralValidator.validateStrNum(null))
                        .withMessage(ExceptionConst.NPE_MSG),
                () -> assertThatExceptionOfType(NanException.class)
                        .isThrownBy(() -> GeneralValidator.validateStrNum("NAN"))
                        .withMessage(ExceptionConst.NAN_MSG)
        );
    }
}
