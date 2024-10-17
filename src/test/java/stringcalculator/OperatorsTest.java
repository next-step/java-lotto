package stringcalculator;

import stringcalculator.domain.Operators;
import stringcalculator.domain.calculation.Addition;
import stringcalculator.domain.calculation.Division;
import stringcalculator.domain.calculation.Multiplication;
import stringcalculator.domain.calculation.Subtraction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorsTest {
    @Test
    @DisplayName("덧셈 연산자를 입력하면 덧셈 연산을 수행한다.")
    void find_plusOperator() {
        assertThat(Operators.find("+")).isInstanceOf(Addition.class);
    }

    @Test
    @DisplayName("뺄셈 연산자를 입력하면 뺄셈 연산을 수행한다.")
    void find_minusOperator() {
        assertThat(Operators.find("-")).isInstanceOf(Subtraction.class);
    }

    @Test
    @DisplayName("곱셈 연산자를 입력하면 곱셈 연산을 수행한다.")
    void find_multipleOperator() {
        assertThat(Operators.find("*")).isInstanceOf(Multiplication.class);
    }

    @Test
    @DisplayName("나눗셈 연산자를 입력하면 나눗셈 연산을 수행한다.")
    void find_divisionOperator() {
        assertThat(Operators.find("/")).isInstanceOf(Division.class);
    }
}
