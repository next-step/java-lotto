package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 입력값이_null이거나_공백문자일경우_IllegalArgumentException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Calculator(input))
                .withMessage("null 이거나 빈 값입니다");
    }

    @ParameterizedTest(name = "expression")
    @CsvSource(value = {"4 + 2 + "})
    void 연산식이_올바르지_않을경우(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Calculator(input))
                .withMessage("식이 올바르지 않습니다");
    }
}