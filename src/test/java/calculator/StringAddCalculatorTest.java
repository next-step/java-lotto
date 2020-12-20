package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    @DisplayName("문자열 또는 NULL 값을 입력할 경우 0반환")
    @ParameterizedTest
    @NullAndEmptySource
    void validNullOrEmpty(String input) {
        final int expected = 0;
        int actual = StringAddCalculator.splitAndSum(input);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    @Test
    void parseNum() {
        int result = StringAddCalculator.splitAndSum("10");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringAddCalculator.splitAndSum("10#");
        })
                .withMessageContaining("숫자가 아닙니다.");

    }

    @ParameterizedTest
    @DisplayName("숫자 컴마(,) 구분자로 입력할 경우 숫자의 합을 반환")
    @CsvSource(value = {"1,2:3","3,4,5,6,7:25", "1,2,5:8"}, delimiter = ':')
    void splitAndSumByComma(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("숫자 컴마(,),콜론(:),수직선(|) 구분자 입력할 경우 숫자의 합을 반환")
    @CsvSource(value = {"1,2:3#6","3,4:5,6|7:2#27", "1:2,5|8#16"}, delimiter = '#')
    void splitAndSumByMulti(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("음수 예외 처리")
    @Test
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }
}
