package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperandTest {
    @Test
    @DisplayName("피연산자 null 체크")
    void 피연산자_null_체크() {
        String oper = null;

        assertThatThrownBy(() -> {
            new Operand(oper);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("피연산자는 null이 될 수 없습니다");

    }

    @Test
    @DisplayName("잘못된 사칙연산 기호 체크")
    void 피연산자_잘못된_사칙연산_기호_체크() {
        String oper = "/";

        assertThatThrownBy(() -> new Operand(oper))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("피연산자가 숫자가 아닌 값이 입력되었습니다");
    }

    @Test
    @DisplayName("피연산자 생성자 생성 성공")
    void 피연산자_생성_성공() {
        String oper = "12";

        Operand operand = new Operand(oper);

        assertThat(operand).isEqualTo(new Operand(12));
    }
}