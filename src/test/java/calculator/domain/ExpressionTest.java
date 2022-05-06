package calculator.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionTest {
    @ParameterizedTest
    @CsvSource(value = {
            "10,PLUS,10,20",
            "10,MINUS,10,0",
            "10,MULTIPLY,10,100",
            "10,DIVIDE,10,1"
    })
    void operation_피연산자_2개와_연산자_1개로_연산(int operand1, String operatorName, int operand2, int result) {
        assertThat(new Expression(
                new Operand(operand1),
                Operator.valueOf(operatorName),
                new Operand(operand2)).operation()).isEqualTo(result);
    }

    @Test
    void operation_표현식_요소가_null_인_경우() {
        assertThatThrownBy(() -> new Expression(new Operand(1), Operator.DIVIDE, null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}