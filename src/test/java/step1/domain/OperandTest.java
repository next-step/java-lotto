package step1.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OperandTest {

    @Test
    void 피연산자는_정수값을_가진다() {
        Operand operand = new Operand(1);
        assertThat(operand.getValue()).isEqualTo(1);
    }

    @Test
    void 숫자가_아닌_문자열로_초기화는_에러() {
        assertThatThrownBy(() -> new Operand("one"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("피연산자는 숫자여야합니다.");
    }
}
