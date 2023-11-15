import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("두 숫자를 입력하면 덧셈 연산을 수행한다.")
    void 덧셈연산(){
        assertThat(Calculator.sum(2, 3)).isEqualTo(5);
    }

    @Test
    @DisplayName("두 숫자를 입력하면 뺄셈 연산을 수행한다.")
    void 뺄셈연산(){
        assertThat(Calculator.subtraction(7, 3)).isEqualTo(4);
    }

    @Test
    @DisplayName("두 숫자를 입력하면 곱셈 연산을 수행한다.")
    void 곱셈연산(){
        assertThat(Calculator.multiplication(2, 3)).isEqualTo(6);
    }

    @Test
    @DisplayName("두 숫자를 입력하면 나눗셈 연산을 수행한다.")
    void 나눗셈연산(){
        assertThat(Calculator.division(7, 3)).isEqualTo(2);
    }
}
