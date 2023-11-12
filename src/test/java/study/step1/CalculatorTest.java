package study.step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step1.domain.Calculator;
import study.step1.domain.exception.CalculatorException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static study.step1.view.InputParser.parse;

public class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {
        "1 + 6",
        "1 + 2 + 4"
    })
    void 더하기(String string) {
        Calculator calculator = new Calculator(parse(string));
        int calculate = calculator.calculate();
        assertThat(calculate).isEqualTo(7);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "10 - 3",
        "10 - 2 - 1"
    })
    void 빼기(String string) {
        Calculator calculator = new Calculator(parse(string));
        assertThat(calculator.calculate()).isEqualTo(7);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "1 * 7",
        "1 * 1 * 7"
    })
    void 곱하기(String string) {
        Calculator calculator = new Calculator(parse(string));
        int result = calculator.calculate();
        assertThat(result).isEqualTo(7);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "49 / 7",
        "50 / 7"
    })
    void 나누기(String string) {
        Calculator calculator = new Calculator(parse(string));
        assertThat(calculator.calculate()).isEqualTo(7);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "2 + 3 / 0 * 4 / 2",
        "50 / 0 * 2 / 2",
        "50 / 0 * 2 / 0",
    })
    void 나누기오류(String string) {
        Calculator calculator = new Calculator(parse(string));
        assertThatExceptionOfType(CalculatorException.class)
            .isThrownBy(calculator::calculate)
            .withMessage("DivideError: 0으로는 나눌 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "2 + 3 * 4 / 2",
        "50 / 5 * 2 / 2",
        "1 / 1 * 100 / 10"
    })
    void 혼합(String string) {
        Calculator calculator = new Calculator(parse(string));
        assertThat(calculator.calculate()).isEqualTo(10);
    }
}
