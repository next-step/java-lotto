package StringCalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperandTest {
    @DisplayName("피연산자 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        // given
        String str = "3";

        // when
        Operand sut = new Operand(str);

        // then
        assertThat(sut).isNotNull();
    }

    @DisplayName("Operand의 value를 가져올 수 있다.")
    @Test
    void getValueTest() {
        Operand operand = new Operand("3");

        assertThat(operand.getValue()).isEqualTo(3);
    }
}
