package calculator.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static calculator.domain.Operator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorsTest {

    @DisplayName("각 연산자 문자들로 생성할 수 있다.")
    @Test
    void of() {
        Operators expected = new Operators(List.of(ADD, SUBTRACT, MULTIPLY, DIVIDE));

        Operators actual = Operators.from(List.of("+", "-", "*", "/"));

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("Operators를 생성할때 길이가 0이면 예외가 발생한다.")
    @Test
    void min_size() {
        ThrowingCallable actual = () -> new Operators(new ArrayList<>());

        assertThatThrownBy(actual)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("적어도 1개의 연산자가 입력되어야 합니다.");
    }

    @DisplayName("Operators의 크기를 반환한다.")
    @Test
    void size() {
        int actual = new Operators(List.of(ADD, SUBTRACT, MULTIPLY, DIVIDE)).size();

        assertThat(actual).isEqualTo(4);
    }
}
