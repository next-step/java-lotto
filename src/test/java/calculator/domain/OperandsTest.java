package calculator.domain;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class OperandsTest {
    @DisplayName("피연산자들을 생성한다.")
    @Test
    void create() {
        OperandNumber number8 = new OperandNumber(8);
        OperandNumber number2 = new OperandNumber(2);
        Operands operands = new Operands(List.of(number8, number2));

        assertThat(operands).extracting("operands", as(InstanceOfAssertFactories.LIST))
                .contains(number8, number2);
    }

    @DisplayName("유효하지 않은 인덱스로 접근 시 IndexOutOfBoundsException을 발생시킨다.")
    @Test
    void throw_IndexOutOfBoundsException_when_argument_is_out_of_index_of_value() {
        OperandNumber number8 = new OperandNumber(8);
        OperandNumber number2 = new OperandNumber(2);
        Operands operands = new Operands(List.of(number8, number2));

        assertThatThrownBy(() -> operands.valueAt(2))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("유효하지 않은 인덱스입니다. (operands 길이: 2, 요청 인덱스: 2");
    }

    @DisplayName("인자로 전달하는 인덱스에 위치하는 값을 반환한다.")
    @Test
    void return_value_located_at_index() {
        OperandNumber number8 = new OperandNumber(8);
        OperandNumber number2 = new OperandNumber(2);
        Operands operands = new Operands(List.of(number8, number2));

        assertThat(operands.valueAt(1)).isEqualTo(number2);
    }
}
