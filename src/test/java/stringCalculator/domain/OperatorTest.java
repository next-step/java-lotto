package stringCalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {

    Operators operator = new Operators();

    @Test
    @DisplayName(value = "사칙연산 기호가 들어가야할 자리에 제대로 입력되지 않았을 경우 IllegalArgumentException 발생 하는지 테스트")
    void test1() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            operator.validOperator("4");
        });
    }
}