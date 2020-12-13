package step1.domain.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.InputString;

class StringAddCalculatorTest {

    StringCalculator calculator;
    InputString inputString;

    @BeforeEach
    void setUp() {
        calculator = new StringAddCalculator();
    }

    @Test
    @DisplayName("input이 빈문자인 경우 테스트")
    void input_empty() {
        inputString = new InputString(" ");
        Assertions.assertEquals(calculator.apply(inputString), 0);
    }

    @Test
    @DisplayName("input이 null인 경우 테스트")
    void input_null() {
        inputString = new InputString(null);
        Assertions.assertEquals(calculator.apply(inputString), 0);
    }

    @Test
    @DisplayName("input이 숫자 하나인 경우 기능 테스트")
    void input_only_one_number() {
        inputString = new InputString("5");
        Assertions.assertEquals(calculator.apply(inputString), 5);
    }

    @Test
    @DisplayName("input에 쉼표 구분자가 있을 때 기능 테스트")
    void input_comma() {
        inputString = new InputString("5,2");
        Assertions.assertEquals(calculator.apply(inputString), 7);
    }

    @Test
    @DisplayName("input에 쉼표와 콜론 구분자가 있을 때 기능 테스트")
    void input_comma_and_colon() {
        inputString = new InputString("5,2:7");
        Assertions.assertEquals(calculator.apply(inputString), 14);
    }

    @Test
    @DisplayName("input에 커스텀 구분자가 있을 경우 테스트")
    void input_custom() {
        inputString = new InputString("//;\\n1;2;3");
        Assertions.assertEquals(calculator.apply(inputString), 6);
    }

    @Test
    @DisplayName("음수 런타임 익셉션 발생 테스트")
    void minus_runtimeException() {
        inputString = new InputString("-1,2,3");
        Assertions.assertThrows(RuntimeException.class,
                () -> calculator.apply(inputString));
    }
}