package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TextSumCalculatorTest {

    @MethodSource
    static Stream<String> blankStrings() {
        return Stream.of("", " ", null);
    }

    @MethodSource
    static Stream<Arguments> customStrings() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("//,\n4,2,3", 9),
                Arguments.of("//#\n11#2#3", 16),
                Arguments.of("///\n10/3", 13));
    }

    @ParameterizedTest
    @MethodSource(value = "blankStrings")
    @DisplayName("null 또는 빈 문자를 인자로 받을 경우 예외를 던진다")
    public void splitAndSum_null_또는_빈문자(String input) {
        int result = StringAddCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"3=3", "4=4", "1=1", "0=0"}, delimiter = '=')
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    public void splitAndSum_숫자하나(String input, int expected) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2 = 3", "3,10 = 13", "7,7 = 14", "10,2 = 12"}, delimiter = '=')
    @DisplayName("숫자 두개를 콤마 구분자로 입력할 경우 두 숫자의 합을 반환한다")
    public void splitAndSum_쉼표구분자(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3 = 6", "5:4,7:2 = 18", "3:4:5,1 = 13", "1:2,3,4 = 10"}, delimiter = '=')
    @DisplayName("여러개의 숫자를 쉼표 또는 콜론 구분자로 입력할 경우 입력한 숫자들의 합을 반환한다")
    public void splitAndSum_쉼표또는콜론_구분자(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("customStrings")
    @DisplayName("커스텀 구분자를 입력할 경우 해당 구분자로 나뉜 숫자들의 합을 반환한다")
    public void splitAndSum_custom_구분자(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "3,b", "2,-1,4", "a,-5,3"})
    @DisplayName("음수 혹은 숫자가 아닌 문자를 받을 경우 예외를 던진다")
    public void splitAndSum_negative(String input) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class);
    }
}

