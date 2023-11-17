package step1;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void init () {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({
            "1 + 1, 2",
            "3 + 2, 5",
            "4 + 2, 6"
    })
    void 더하기_테스트(String formula, int answer) {
        calculator.init(formula);
        Assertions.assertThat(calculator.compute()).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource({
            "1 - 1, 0",
            "3 - 2, 1",
            "4 - 2, 2"
    })
    void 뺴기_테스트(String formula, int answer) {
        calculator.init(formula);
        Assertions.assertThat(calculator.compute()).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource({
            "1 * 1, 1",
            "3 * 2, 6",
            "4 * 2, 8"
    })
    void 곱하기_테스트(String formula, int answer) {
        calculator.init(formula);
        Assertions.assertThat(calculator.compute()).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource({
            "1 / 1, 1",
            "3 / 2, 1",
            "4 / 2, 2"
    })
    void 나누기_테스트(String formula, int answer) {
        calculator.init(formula);
        Assertions.assertThat(calculator.compute()).isEqualTo(answer);

    }

    @ParameterizedTest
    @CsvSource({"!","@","#","$","%","^","&",")","("})
    void 사칙_연산_기호가_맞는지_확인_하는_테스트(String input) {
        assertThatThrownBy(() -> Operator.getOperator(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 입력_값이_null_이거나_빈_공백_문자일_경우_에러를_반환_하는_테스트(String input) {
        assertThatThrownBy(() -> calculator.validateInput(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
