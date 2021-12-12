package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @DisplayName("calculate 테스트: input이 null이거나 empty string인경우 0을 리턴한다.")
    @NullAndEmptySource
    void cacluate_null_또는_빈문자(String input) {
        Number expectedResult = new Number(0);
        Number result = StringAddCalculator.calculate(input);

        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @DisplayName("calculate 테스트: input이 숫자 하나인 경우 해당 숫자를 리턴한다.")
    @CsvSource(value = {"1:1", "3:3", "5:5"}, delimiter = ':')
    void cacluate_숫자하나(String input, Number expectedResult) {
        Number result = StringAddCalculator.calculate(input);

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("calculate 테스트: input이 쉼표 구분자로 된 경우 테스트")
    void cacluate_쉼표구분자() {
        String input = "1,2";
        Number expectedResult = new Number(3);
        Number result = StringAddCalculator.calculate(input);

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("calculate 테스트: input이 쉼표 또는 콜로 구분자로 된 경우 테스트")
    void cacluate_쉼표_또는_콜론_구분자() {
        String input = "1,2:3";
        Number expectedResult = new Number(6);
        Number result = StringAddCalculator.calculate(input);

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("calculate 테스트: input이 custom 구분자로 된 경우 테스트")
    void cacluate_custom_구분자() {
        String input = "//;\n1;2;3";
        Number expectedResult = new Number(6);
        Number result = StringAddCalculator.calculate(input);

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("calculate 테스트: input에 음수가 포함된 경우 RuntimeException이 발생한다.")
    void cacluate_음수() {
        String input = "1;-2;3";

        assertThatThrownBy(() -> StringAddCalculator.calculate(input))
                .isInstanceOf(RuntimeException.class);
    }

}
