package calculate.domain;

import calculate.exception.NotPositiveIntegerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperandTest {

    @DisplayName("객체 생성 및 비교")
    @Test
    public void operand() throws Exception {
        //given
        Operand operand1 = new Operand(2);
        Operand operand2 = new Operand(2);

        //then
        assertThat(operand1.equals(operand2)).isTrue();
    }

    @DisplayName("피연산자가 양의 정수인지 - fail: 음수 입력")
    @ParameterizedTest
    @ValueSource(ints = {-100, -1})
    public void validateInteger_음수(int num) throws Exception {
        assertThatThrownBy(
                () -> new Operand(num)
        ).isInstanceOf(NotPositiveIntegerException.class);
    }
}
