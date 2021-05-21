package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperandTest {

    @DisplayName("숫자가 아닌 값으로 생성하려는 경우, IllegalArgumentExcpetion을 던진다")
    @Test
    void throw_exception_non_numbers_input() {
        //Given + When + Then
        assertThatThrownBy(() -> {
            Operand operand = new Operand("a");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음수로 생성하려는 경우, IllegalArgumentExcpetion을 던진다")
    @Test
    void throw_exception_negative_number_input() {
        //Given + When + Then
        assertThatThrownBy(() -> {
            Operand operand = new Operand("-1");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("number 변수값이 동일한 경우, equals()==true이다")
    @Test
    void equals_is_true_when_number_value_is_same() {
        //Given
        Operand first = new Operand("1");
        Operand second = new Operand("1");

        assertThat(first.equals(second)).isTrue();
    }

    @DisplayName("number 변수값이 다른 경우, equals()==false이다")
    @Test
    void equals_is_false_when_number_value_is_different() {
        //Given
        Operand first = new Operand("1");
        Operand second = new Operand("2");

        assertThat(first.equals(second)).isFalse();
    }
}
