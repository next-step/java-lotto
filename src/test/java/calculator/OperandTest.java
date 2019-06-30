package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperandTest {
    @Test
    @DisplayName("Operand 객체를 생성할 수 있다.")
    void create_Operand() {
        Operand operand = Operand.of(1);
        assertThat(operand).isInstanceOf(Operand.class);
    }

    @Test
    @DisplayName("Operand 객체를 문자열로 생성할 수 있다.")
    void create_OperandWithString() {
        Operand operand = Operand.of("1");
        assertThat(operand).isInstanceOf(Operand.class);
    }

    @Test
    @DisplayName("Operand 객체는 동등성을 보장한다.")
    void equals_HasSameValue() {
        Operand operand1 = Operand.of(1);
        Operand operand2 = Operand.of(1);
        assertThat(operand1).isEqualTo(operand2);
    }

    @Test
    @DisplayName("Operand 객체는 동일성을 보장한다.")
    void identify_HasSameValue() {
        Operand operand1 = Operand.of(1);
        Operand operand2 = Operand.of(1);
        assertThat(operand1).isSameAs(operand2);
    }

    @Test
    @DisplayName("Operand 객체를 숫자로 변환한다.")
    void convert_ToInt() {
        Operand operand = Operand.of(1);
        assertThat(operand.getValue()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"b", "!", "^", "X"})
    @DisplayName("숫자 이외의 값이 전달되면 예외를 발생시킨다.")
    void check_NotNumberParam_ExceptionThrown(String input) {
        assertThatThrownBy(() -> Operand.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Operand.MESSAGE_OF_NOT_NUMBER_EXCEPTION);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-20"})
    @DisplayName("음수 값이 전달되면 예외를 발생시킨다.")
    void check_NegativeNumberParam_ExceptionThrown(String input) {
        assertThatThrownBy(() -> Operand.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Operand.MESSAGE_OF_NEGATIVE_NUMBER_EXCEPTION);
    }

    @Test
    @DisplayName("Operand는 객체끼리 더할 수 있다.")
    void add_Operand() {
        Operand operand1 = Operand.of(10);
        Operand operand2 = Operand.of(20);
        assertThat(operand1.add(operand2)).isEqualTo(Operand.of(10 + 20));
    }
}
