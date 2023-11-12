package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step1.domain.calculator.Calculator;
import step1.domain.operator.AddOperator;
import step1.domain.operator.DivideOperator;
import step1.domain.operator.MultiplyOperator;
import step1.domain.operator.SubtractOperator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"6,11", "3,8", "2,7"})
    void 덧셈_테스트(int input, int expected) {
        calculator.updateOperator("+");
        assertThat(calculator.operator()).isInstanceOf(AddOperator.class);
        assertThat(calculator.calculate(5, input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"6,-1", "5,0", "2,3"})
    void 뺄셈_테스트(int input, int expected) {
        calculator.updateOperator("-");
        assertThat(calculator.operator()).isInstanceOf(SubtractOperator.class);
        assertThat(calculator.calculate(5, input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"6,30", "5,25", "2,10"})
    void 곱셈_테스트(int input, int expected) {
        calculator.updateOperator("*");
        assertThat(calculator.operator()).isInstanceOf(MultiplyOperator.class);
        assertThat(calculator.calculate(5, input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,15", "6,5", "3,10"})
    void 나눗셈_테스트(int input, int expected) {
        calculator.updateOperator("/");
        assertThat(calculator.operator()).isInstanceOf(DivideOperator.class);
        assertThat(calculator.calculate(30, input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"31", "7", "9", "0"})
    void 나눗셈_테스트_오류(int input) {
        calculator.updateOperator("/");
        assertThat(calculator.operator()).isInstanceOf(DivideOperator.class);
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(30, input));
    }
}