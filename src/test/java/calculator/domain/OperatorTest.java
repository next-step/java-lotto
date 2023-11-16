package calculator.domain;


import calculator.domain.operator.Operator;
import calculator.domain.operator.OperatorFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {

    @ParameterizedTest(name = "연산자생성/ `{0}` / 생성완료")
    @ValueSource(strings = {"+", "-", "*", "/"})
    void createOperator(String operator) {
        // when then
        assertThat(OperatorFactory.of(operator)).isInstanceOf(Operator.class);
    }

    @Test
    @DisplayName("연산자생성/연산기호가아닌것/IllegalArgumentException")
    void createOperatorFail() {
        // when then
        assertThatIllegalArgumentException().isThrownBy(() -> OperatorFactory.of("0"));
    }

    @ParameterizedTest(name = "연산 / {0}{1}{2} / 결과:  {3}")
    @CsvSource({
            "6, +, 2, 8",
            "6, -, 2, 4",
            "6, *, 2, 12",
            "6, /, 2, 3",
    })
    void operate(int num1, String inputOperator, int num2, int result) {
        // given
        Operator operator = OperatorFactory.of(inputOperator);

        // when then
        assertThat(operator.apply(num1, num2)).isEqualTo(result);
    }

    @Test
    @DisplayName("나눗셈/0으로 나누기/ArithmeticException")
    void divisionFail0() {
        // given
        Operator operator = OperatorFactory.of("/");

        // when then
        assertThatThrownBy(() -> operator.apply(4, 0)).isInstanceOf(ArithmeticException.class);
    }

    @Test
    @DisplayName("나눗셈/결과가 소수점/IllegalArgumentException")
    void divisionFailFloat() {
        // given
        Operator operator = OperatorFactory.of("/");

        // when then
        assertThatIllegalArgumentException().isThrownBy(() -> operator.apply(4, 3));
    }
}