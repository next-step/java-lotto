package step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.operator.*;
import step1.domain.operator.impl.Add;
import step1.domain.operator.impl.Divide;
import step1.domain.operator.impl.Multiply;
import step1.domain.operator.impl.Subtract;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {


    private Operator add = new Add();
    private Operator multiply = new Multiply();
    private Operator subtract = new Subtract();
    private Operator divide = new Divide();

    @Test
    @DisplayName("덧셈")
    void add() {
        assertThat(add.operate(1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("곱셈")
    void multiply() {
        assertThat(multiply.operate(2, 3)).isEqualTo(6);
    }

    @Test
    @DisplayName("뺄셈")
    void subtract() {
        assertThat(subtract.operate(2, 1)).isEqualTo(1);
    }

    @Test
    @DisplayName("나눗셈")
    void divide() {
        assertThat(divide.operate(4, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("덧셈 지원 여부")
    void supports() {
        assertThat(add.supports("+")).isTrue();
    }

    @Test
    @DisplayName("곱셈 지원 여부")
    void supports2() {
        assertThat(multiply.supports("*")).isTrue();
    }

    @Test
    @DisplayName("뺄셈 지원 여부")
    void supports3() {
        assertThat(subtract.supports("-")).isTrue();
    }

    @Test
    @DisplayName("나눗셈 지원 여부")
    void supports4() {
        assertThat(divide.supports("/")).isTrue();
    }


}
