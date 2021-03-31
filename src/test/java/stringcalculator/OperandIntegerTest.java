package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OperandIntegerTest {

    @Test
    @DisplayName("생성자 테스트")
    void create() {
        assertAll(
                () -> assertEquals(new OperandInteger(0).parseInputInteger(), 0),
                () -> assertEquals(new OperandInteger(1).parseInputInteger(), 1),
                () -> assertEquals(new OperandInteger("0").parseInputInteger(), 0),
                () -> assertEquals(new OperandInteger("1").parseInputInteger(), 1)
        );
    }

    @Test
    @DisplayName("생성자 예외 테스트")
    void validate() {
        assertAll(
                () -> assertThatThrownBy(() -> new OperandInteger(-1)).isInstanceOf(RuntimeException.class),
                () -> assertThatThrownBy(() -> new OperandInteger("-1")).isInstanceOf(RuntimeException.class),
                () -> assertThatThrownBy(() -> new OperandInteger("a")).isInstanceOf(RuntimeException.class)
        );
    }

    @Test
    @DisplayName("덧셈 테스트")
    void sumTest() {
        OperandInteger expected = new OperandInteger();
        assertThat(expected.sum(new OperandInteger(1)).parseInputInteger()).isEqualTo(1);
    }
}
