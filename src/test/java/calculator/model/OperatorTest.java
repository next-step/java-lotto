package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumSet;

import static org.assertj.core.api.Assertions.*;

class OperatorTest {

    @Test
    @DisplayName("사칙연산에 대한 정상적인 값 처리")
    public void constructorSuccessTest() {
        assertThat(Operator.getProperOperator("+")).isEqualTo(Operator.PLUS);
        assertThat(Operator.getProperOperator("-")).isEqualTo(Operator.MINUS);
        assertThat(Operator.getProperOperator("*")).isEqualTo(Operator.MULTIPLY);
        assertThat(Operator.getProperOperator("/")).isEqualTo(Operator.DIVIDE);
    }

    @ParameterizedTest
    @EnumSource(value = Operator.class, names = {"PLUS", "MINUS", "MULTIPLY", "DIVIDE"})
    @DisplayName("정상적으로 이름들이 있는지 확인")
    void constructorEnumTest(Operator operator) {
        assertThat(EnumSet.of(Operator.PLUS, Operator.MINUS, Operator.MULTIPLY, Operator.DIVIDE)).contains(operator);
    }

    @Test
    @DisplayName("사칙연산이 아닌 값에 대한 에러처리")
    public void constructorErrorTest() {
        assertThatThrownBy(() -> Operator.getProperOperator("1")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "PLUS,1,2,3",
            "MINUS,3,2,1",
            "MULTIPLY,1,2,2",
            "DIVIDE,2,1,2"
    })
    @DisplayName("연산을 해서 실제 값과 같은지 확인.")
    public void executeCalculator(Operator operator, String left, String right, String result) {
        assertThat(operator.operate(new Number(left), new Number(right))).isEqualTo(new Number(result));
    }
}