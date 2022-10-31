import operator.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class OperatorTest {
    @Test
    @DisplayName("더하기 테스트")
    void plus() {
        int result = Operator.calculate(1, "+", 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("빼기 테스트")
    void minus() {
        int result = Operator.calculate(3, "-", 1);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("곱하기 테스트")
    void multiply() {
        int result = Operator.calculate(2, "*", 3);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("나누기 테스트")
    void divide() {
        int result = Operator.calculate(6, "/", 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("나눗셈 정수 결과 테스트")
    void divideIntegerCheck() {
        assertThatThrownBy(() -> {
            int result = Operator.calculate(3, "/", 2);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("나눗셈 0으로 나눌 때 테스트")
    void divideZeroCheck() {
        assertThatThrownBy(() -> {
            int result = Operator.calculate(3, "/", 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
