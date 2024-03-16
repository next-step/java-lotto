package calculator;

import calculator.domain.Operator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {
    @ParameterizedTest
    @CsvSource(value = {"+,PLUS", "-,MINUS", "*,MULTIPLY", "/,DIVIDE"})
    void 기호로_연산자_찾기(String symbol, String operatorName) {
        assertThat(Operator.of(symbol)).isEqualTo(Operator.valueOf(operatorName));
    }

    @ParameterizedTest
    @CsvSource(value = {"3,0", "3,2"})
    void 올바르지_않은_나눗셈(int operand1, int operand2) {
        assertThatThrownBy(() -> Operator.DIVIDE.calculate(operand1, operand2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
