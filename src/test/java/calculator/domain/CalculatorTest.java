package calculator.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "0 + -0, 0",
            "1 + 2, 3",
            "3 - 4, -1",
            "-5 * 6, -30",
            "7 / -8, 0",
            "10 + 9 - 8 * 7 / 6, 12"
    })
    void 표현식을_계산한다(String input, int expected) {
        Integer actual = Calculator.calculate(new Expression(input));

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullSource
    void 표현식은_필수이다(Expression expression) {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate(expression))
                .withMessage("표현식을 확인해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1*1", "1 -", "-0 +- 3", "1 + 가 - 9"})
    void 유효하지_않은_표현식은_계산할_수_없다(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate(new Expression(input)))
                .withMessage("올바르지 않은 수식입니다.");
    }
}