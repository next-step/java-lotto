package Calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OperatorTest {
    @Test
    @DisplayName("덧셈")
    void plus() {
        //given //when
        Operator operator = new Operator("+");
        int actual = operator.add(3, 5);

        //then
        int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("뺄셈")
    void minus() {
        //given //when
        Operator operator = new Operator("-");
        int actual = operator.minus(3, 5);

        //then
        int expected = -2;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("곱셈")
    void multiply() {
        //given //when
        Operator operator = new Operator("*");
        int actual = operator.multiply(3, 5);

        //then
        int expected = 15;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("나눗셈")
    void divide() {
        //given //when
        Operator operator = new Operator("/");
        int actual = operator.divide(4, 2);

        //then
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    void notOperator() {
        //given
        Operator operator = new Operator("$");

        //when
        Exception actual = assertThrows(IllegalArgumentException.class, () -> {
            operator.calculateProcess(3, 5);
        });

        //then
        assertEquals(operator.getOperator() + "는 사칙연산 기호가 아닙니다: ", actual.getMessage());
    }
}

