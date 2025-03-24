package calculator;

import calculator.domain.Operand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperandTest {

    @Test
    @DisplayName("피연산자 입력값으로 정수가 아닌 문자가 들어오는 경우 IllegalArgumentException 이 발생")
    public void enter_notInteger_throwsIllegalArgumentException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Operand("string"));
    }

    @Test
    @DisplayName("피연산자 입력값으로 정수 들어오는 경우 정상적으로 파싱 후 객체 생성")
    public void enter_integer_generateNormal() {
        Operand operand = new Operand("13");
        int actual = operand.getValue();

        int expected = 13;
        assertThat(actual).isEqualTo(expected);
    }

}