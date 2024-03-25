package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import step1.config.ErrorMessage;
import step1.controller.StringCalculator;
import step1.domain.Operators;


import static org.assertj.core.api.Assertions.*;
import static step1.config.ErrorMessage.NULL_OR_EMPTY_VALIDATION;

public class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void 입력값_빈값_NULL_검증(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {StringCalculator.calculate(input);
                })
                .withMessageMatching(NULL_OR_EMPTY_VALIDATION.message());
    }


    @ParameterizedTest
    @CsvSource( {"2 ^ 3 * 4 / 2,^"})
    void 기티_연산자_검증(final String input, final String result) {
        assertThatIllegalStateException()
                .isThrownBy(() -> {
                    StringCalculator.calculate(input);
                })
                .withMessage(ErrorMessage.OPERATOR_VALIDATION.message(result));
    }

}
