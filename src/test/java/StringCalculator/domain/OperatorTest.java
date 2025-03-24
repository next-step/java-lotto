package StringCalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperatorTest {
    @DisplayName("연산자 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        Operator operator = Operator.from("+");

        assertThat(operator).isNotNull();
    }

    @DisplayName("사칙연산 기호 (+, -, *, /)가 아닌 경우 IllegalArgumentException을 발생시킨다.")
    @Test
    void createInvalidTest() {
        String invalidStr = "%";

        assertThatIllegalArgumentException().isThrownBy(() -> Operator.from(invalidStr))
                .withMessage("not admit operator : " + invalidStr);
    }

    @DisplayName("더하기를 할 수 있다.")
    @Test
    void calculatePlusTest() {
        // given
        Operator operator = Operator.from("+");

        // when
        int sut = operator.calculate(1, 2);

        // then
        assertThat(sut).isEqualTo(3);
    }

    @DisplayName("빼기를 할 수 있다.")
    @Test
    void calculateMinusTest() {
        // given
        Operator operator = Operator.from("-");

        // when
        int sut = operator.calculate(1, 2);

        // then
        assertThat(sut).isEqualTo(-1);
    }

    @DisplayName("곱하기를 할 수 있다.")
    @Test
    void calculateMultiplyTest() {
        // given
        Operator operator = Operator.from("*");

        // when
        int sut = operator.calculate(1, 2);

        // then
        assertThat(sut).isEqualTo(2);
    }

    @DisplayName("나누기를 할 수 있다. 값은 정수로 한정된다.")
    @Test
    void calculateDivideTest() {
        // given
        Operator operator = Operator.from("/");

        // when
        int sut = operator.calculate(6, 2);

        // then
        assertThat(sut).isEqualTo(3);
    }
}
