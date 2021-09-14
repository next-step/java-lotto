package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAdditionCalculatorTest {
    StringAdditionCalculator stringAdditionCalculator;

    @BeforeEach
    void setUp() {
        stringAdditionCalculator = new StringAdditionCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환")
    void emptyStringReturnZero(String input) {
        int result = stringAdditionCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    void splitSingleStringAndAdd() {
        int result = stringAdditionCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3", "1:2,3"})
    @DisplayName("숫자를 컴마(,) 또는 콜론(:) 구분자로 입력할 경우 두 숫자의 합을 반환")
    void splitStringAndAddition(String input) {
        int result = stringAdditionCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("//”와 “\\n” 문자 사이에 커스텀 구분자를 지정")
    void splitCustomStringAndAdd() {
        int result = stringAdditionCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest()
    @ValueSource(strings = {"-1,2,3", "x:2:3"})
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생")
    void splitInvalidOtherNumber(String input) {
        assertThatThrownBy(() -> stringAdditionCalculator.splitAndSum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
