package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("문자열 덧셈 계산기 테스트")
public class CalculatorTest {

    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열의 숫자 합을 계산할 수 있다.")
    @Test
    public void addNumbersTest() {
        // given
        String input = "1,2:3";

        // when, then
        assertEquals(Calculator.calculateAddition(input), 6);
    }

    @DisplayName("커스텀 구분자로 가지는 문자열의 숫자 합을 계산할 수 있다.")
    @Test
    public void addNumbersOfCustomDelimiterInputTest() {
        // given
        String input = "//;\n1;2;3";

        // when, then
        assertEquals(Calculator.calculateAddition(input), 6);
    }
}
