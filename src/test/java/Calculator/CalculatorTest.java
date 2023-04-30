package Calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    @DisplayName("계산기 전체테스트")
    void allTest() {
        //given
        Calculator calculator = new Calculator("2 + 3 * 4 / 2");
        calculator.calculate();
        //when
        int actual = calculator.getResult();

        //then
        int expected = 10;
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "\"{0}\" 입력 시 IllegalArgumentException throw")
    @NullAndEmptySource
    void inputIsNulloreEmpty(String inputString) {
        //given //when
        Exception actual = assertThrows(IllegalArgumentException.class, () -> {
            Calculator calculator = new Calculator(inputString);
        });

        //then
        assertEquals("입력 값이 null이거나 빈 공백 문자입니다.", actual.getMessage());
    }

}
