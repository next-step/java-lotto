package calculator;

import calculator.domain.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {


    @DisplayName("덧셈 결과 반환 테스트")
    @Test
    void plusTest() {
        final Operator operator = Operator.PLUS;
//        final int result = operator.operate(1, 2);
        final int result = operator.operate(1, 2);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("뺄셈 결과 반환 테스트")
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

    @DisplayName("입력받는 값이 null 이면, IllegalArgumentException 을 반환한다")
    @Test
    void notNullTest() {
        Integer nullValue = null;
        final Operator operator = Operator.PLUS;

        assertThatIllegalArgumentException().isThrownBy(() -> operator.operate(nullValue, 1));
    }

    @DisplayName("지원하지 않는 연산자를 입력 받으면, IllegalArgumentException 을 반환한다")
    @Test
    void throw_Exception_when_not_support_operator() {
        String sign = "%";

        assertThatIllegalArgumentException().isThrownBy(() -> Operator.findBySign(sign));
    }

    @DisplayName("어느 연산자인지 판별한다")
    @Test
    void checkOperator() {
        String  s = "+";
        Operator operator = Operator.findBySign(s);

        assertThat(operator).isEqualTo(Operator.PLUS);
    }
}
