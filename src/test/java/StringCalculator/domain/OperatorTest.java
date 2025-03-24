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

}
