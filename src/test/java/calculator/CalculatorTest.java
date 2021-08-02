package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("문자열 덧셈 계산기 테스트")
public class CalculatorTest {

    @DisplayName("null을 입력하면 0을 반환해야 한다.")
    @Test
    public void nullInputTest() {
        // given
        String input = null;

        // when, then
        assertEquals(Calculator.splitAndSum(input), 0);
    }

    @DisplayName("빈 문자열을 입력하면 0을 반환해야 한다.")
    @Test
    public void emptyInputTest() {
        // given
        String input = "";

        // when, then
        assertEquals(Calculator.splitAndSum(input), 0);
    }

    @DisplayName("숫자를 하나 입력하면, 해당 숫자를 반환해야 한다.")
    @Test
    public void singleNumberInputTest() {
        // given
        String input = "1";

        // when, then
        assertEquals(Calculator.splitAndSum(input), 1);
    }

    @DisplayName("쉼표(,)를 구분자로 가지는 문자열의 숫자 합을 계산할 수 있다.")
    @Test
    public void addNumbersOfCommaDelimiterInputTest() {
        // given
        String input = "1,2";

        // when, then
        assertEquals(Calculator.splitAndSum(input), 3);
    }

    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열의 숫자 합을 계산할 수 있다.")
    @Test
    public void addNumbersOfCommaOrColonDelimiterInputTest() {
        // given
        String input = "1,2:3";

        // when, then
        assertEquals(Calculator.splitAndSum(input), 6);
    }

    @DisplayName("커스텀 구분자로 가지는 문자열의 숫자 합을 계산할 수 있다.")
    @Test
    public void addNumbersOfCustomDelimiterInputTest() {
        // given
        String input = "//;\n1;2;3";

        // when, then
        assertEquals(Calculator.splitAndSum(input), 6);
    }

    @DisplayName("숫자 이외의 값 또는 음수를 입력하면, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"(,5,)", "-1,2,3"})
    public void nonNumericOrNegativeNumberInputExceptionTest(String input) {
        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calculator.splitAndSum(input))
                .withMessage("숫자는 0 또는 양수이어야 합니다.");
    }
}
