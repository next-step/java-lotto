import calculator.Calculator;
import calculator.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @DisplayName("단순 사칙연산 테스트")
    @Test
    void calculateTest(){
        assertThat(Operator.PLUS.calculate(4, 2)).isEqualTo(6);
        assertThat(Operator.MINUS.calculate(4, 2)).isEqualTo(2);
        assertThat(Operator.MULTIPLE.calculate(4, 2)).isEqualTo(8);
        assertThat(Operator.DIVIDE.calculate(4, 2)).isEqualTo(2);
    }

    @DisplayName("나눗셈 결과 정수 여부 테스트")
    @Test
    void divideResultIntegerTest(){
        assertThat(Operator.DIVIDE.calculate(5, 2)).isEqualTo(2);
    }

    @DisplayName("빈 문자 혹은 공백 입력 테스트")
    @Test
    void emptyOrNullInputTest(){
        assertThatThrownBy(() -> Calculator.calculate(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Calculator.calculate(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Calculator.calculate("     "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 사칙연산 테스트")
    @Test
    void formulaTest(){
        String formula = "2 + 3 * 4 / 2";
        assertThat(Calculator.calculate(formula)).isEqualTo(10);
    }
}
