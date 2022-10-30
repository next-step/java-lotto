import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class OperatorTest {
    Operator operator = null;

    @BeforeEach
    void setUp() {
        operator = new Operator();
    }

    @Test
    @DisplayName("더하기 테스트")
    void plus() {
        operator.init(1, "+", 2);
        int result = operator.operate();
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("빼기 테스트")
    void minus() {
        operator.init(3, "-", 1);
        int result = operator.operate();
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("곱하기 테스트")
    void multiply() {
        operator.init(2, "*", 3);
        int result = operator.operate();
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("나누기 테스트")
    void divide() {
        operator.init(6, "/", 2);
        int result = operator.operate();
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("나눗셈 정수 결과 테스트")
    void divideIntegerCheck() {
        assertThatThrownBy(() -> {
            operator.init(3, "/", 2);
            int result = operator.operate();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("나눗셈 0으로 나눌 때 테스트")
    void divideZeroCheck() {
        assertThatThrownBy(() -> {
            operator.init(3, "/", 0);
            int result = operator.operate();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
