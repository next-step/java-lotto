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
                () -> assertEquals(OperandInteger.of("0").parseInteger(), 0),
                () -> assertEquals(OperandInteger.of("1").parseInteger(), 1)
        );
    }

    @Test
    @DisplayName("생성자 예외 테스트")
    void validate() {
        assertAll(
                () -> assertThatThrownBy(() -> OperandInteger.of("-1")).isInstanceOf(RuntimeException.class),
                () -> assertThatThrownBy(() -> OperandInteger.of("a")).isInstanceOf(RuntimeException.class)
        );
    }

    @Test
    @DisplayName("덧셈 테스트")
    void sumTest() {
        OperandInteger expected = new OperandInteger();
        assertThat(expected.sum(OperandInteger.of("1")).parseInteger()).isEqualTo(1);
    }
}
