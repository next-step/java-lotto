package calculator;

import calculator.domain.Operator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {

    @Test
    void Operator_생성() {
        String operator = new Operator("*").value();
        assertThat(operator).isEqualTo("*");
    }

    @Test
    void 사칙연산_아닌경우_예외처리() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Operator("1"))
                .withMessageContaining("사칙연산 기호가 아닙니다.");
    }

    @Test
    void null_예외처리() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Operator(null))
                .withMessageContaining("입력값이 없습니다.");
    }

    @Test
    void 공백_예외처리() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Operator(""))
                .withMessageContaining("입력값이 없습니다.");
    }
}
