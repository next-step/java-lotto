package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import calculator.domain.Operator;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {


    @DisplayName("덧셈 결과 반환 테스트")
    @Test
    void plusTest() {
        final Operator operator = Operator.PLUS;
//        final int result = operator.operate(1, 2);
        final int result = operator.operate(1, 2);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("빼기 결과 반환 테스트")
    @Test
    void minusTest() {
        final Operator operator = Operator.MINUS;
        final int result = operator.operate(3, 2);

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("곱셈 결과 반환 테스트")
    @Test
    void multiplyTest() {
        final Operator operator = Operator.MULTIPLY;
        final int result = operator.operate(2, 3);

        assertThat(result).isEqualTo(6);
    }

    @DisplayName("나눗셈 결과 반환 테스트")
    @Test
    void divideTest() {
        final Operator operator = Operator.DIVIDE;
        final int result = operator.operate(4, 3);

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("입력받는 값이 null 이면 안된다")
    @Test
    void notNullTest() {
        final Operator operator = Operator.PLUS;
        assertThatIllegalArgumentException().isThrownBy(() -> operator.operate(null, 1));
    }
}
