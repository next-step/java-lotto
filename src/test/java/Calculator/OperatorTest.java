package Calculator;

import Calculator.Operator.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OperatorTest {
    @Test
    @DisplayName("덧셈")
    void plus() {
        //given //when
        Operator add = new Add();
        int actual = add.operate(3, 5);

        //then
        int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("뺄셈")
    void minus() {
        //given //when
        Operator minus = new Minus();
        int actual = minus.operate(3, 5);

        //then
        int expected = -2;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("곱셈")
    void multiply() {
        //given //when
        Operator multiply = new Multiply();
        int actual = multiply.operate(3, 5);

        //then
        int expected = 15;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("나눗셈")
    void divide() {
        //given //when
        Operator divide = new Divide();
        int actual = divide.operate(4, 2);

        //then
        int expected = 2;
        assertEquals(expected, actual);
    }
}

