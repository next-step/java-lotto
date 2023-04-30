package Calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("계산기 전체테스트")
    void allTest() {
        //given
        Calculator calculator = new Calculator("2 + 3 * 4 / 2");

        //when
        int actual = calculator.calculate();

        //then
        int expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("덧셈")
    void plus() {
        //given //when
        Calculator calculator = new Calculator();
        int actual = calculator.add(3, 5);

        //then
        int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("뺄셈")
    void minus() {
        //given //when
        Calculator calculator = new Calculator();
        int actual = calculator.minus(3, 5);

        //then
        int expected = -2;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("곱셈")
    void multiply() {
        //given //when
        Calculator calculator = new Calculator();
        int actual = calculator.multiply(3, 5);

        //then
        int expected = 15;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("나눗셈")
    void divide() {
        //given //when
        Calculator calculator = new Calculator();
        int actual = calculator.divide(4, 2);

        //then
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw")
    void inputIsNulloreEmpty() {
        //given
        String inputString = "";

        //when
        Exception actual = assertThrows(IllegalArgumentException.class, () -> {
            Calculator calculator = new Calculator(inputString);
        });

        //then
        assertEquals("입력 값이 null이거나 빈 공백 문자입니다.", actual.getMessage());
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    void notOperator() {
        //given
        String operator = "$";
        Calculator calculator = new Calculator();
        
        //when
        Exception actual = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateProcess(3, 5, operator);
        });

        //then
        assertEquals(operator + "는 사칙연산 기호가 아닙니다: ", actual.getMessage());
    }
}