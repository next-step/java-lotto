package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperatorsTest {

    @DisplayName("들어온 데이터가 연산자 아니라면 IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionWhenInputIsNotOperator() {
        // then
        assertThrows(IllegalArgumentException.class, () -> new Operators(List.of("?", "+")));
    }

    @DisplayName("들어온 데이터가 비어있다면 IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionWhenInputIsEmpty() {
        // then
        assertThrows(IllegalArgumentException.class, () -> new Operators(List.of()));
    }

    @DisplayName("순차적으로 연산자를 읽을 수 있다.")
    @Test
    void canReadSequenceOperators() {
        // given
        Operators operators = new Operators(List.of("+", "/"));

        // then
        assertAll(
                () -> assertThat(operators.nextOperation()).isEqualTo(Operator.PLUS),
                () -> assertThat(operators.nextOperation()).isEqualTo(Operator.DIVIDE)
        );
    }
}