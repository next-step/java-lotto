package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {

    @Test
    void Operator_생성() {
        String operator = new Operator("*").value();
        assertThat(operator).isEqualTo("*");
    }

    @Test
    void 사칙연산_아닌경우_예외처리() {
        assertThatThrownBy(() -> {
            new Operator("1").value();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙연산 기호가 아닙니다.");
    }

    @Test
    void null_예외처리() {
        assertThatThrownBy(() -> {
            new Operator(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 없습니다.");
    }

    @Test
    void 공백_예외처리() {
        assertThatThrownBy(() -> {
            new Operator("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 없습니다.");
    }
}
