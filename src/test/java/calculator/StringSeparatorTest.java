package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringSeparatorTest {

    @CsvSource(value = {"1:2:3=3", "1=1", "1,2=2"}, delimiter = '=')
    @ParameterizedTest
    @DisplayName("기본 구분자(, :) 를 갖는 문자열을 구분하고 크기를 검증한다.")
    void 기본_구분자_테스트(String input, int expected) {
        assertThat(StringSeparator.split(input)).hasSize(expected);
    }

    @ValueSource(strings = {"1:2-3", "1!2:3", "3*4,7", "3','+4,7"})
    @ParameterizedTest
    @DisplayName("기본 구분자(, :) 이외 구분자를 포함하는 문자를 구분하면 예외가 발생한다.")
    void 다른_구분자_예외_테스트(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringSeparator.split(input));
    }

    @NullAndEmptySource
    @ParameterizedTest
    @DisplayName("비어있는 값을 구분하면 0을 반환한다.")
    void null_empty_테스트(String input) {
        String[] result = StringSeparator.split(input);
        assertThat(result).hasSize(1);
        assertThat(result).contains("0");
    }

    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    @ParameterizedTest
    @DisplayName("숫자 하나를 포함한 문자열을 구분하면 해당 숫자를 반환한다.")
    void 숫자_하나_구분_테스트(String input) {
        String[] result = StringSeparator.split(input);
        assertThat(result).hasSize(1);
        assertThat(Integer.parseInt(result[0])).isEqualTo(Integer.parseInt(input));
    }

    @ValueSource(strings = {"-1", "-1:2", "2:1,-3"})
    @ParameterizedTest
    @DisplayName("음수값을 포함하는 문자열을 구분하면 예외가 발생한다.")
    void 음수값_구분_테스트(String input) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> StringSeparator.split(input));
    }

    @MethodSource("generateCustomInputArgument")
    @ParameterizedTest
    @DisplayName("커스텀 구분자를 포함한 문자열을 구분하고 크기를 검증한다.")
    void 커스텀_구분_테스트(String input, int expected) {
        assertThat(StringSeparator.split(input)).hasSize(expected);
    }

    @ValueSource(strings = {"//;\n1;2,3", "//,\n1,2!3", "//;\n1=1"})
    @ParameterizedTest
    @DisplayName("커스텀 구분자에 포함하지 않은 구분자가 있으면 예외가 발생한다.")
    void 커스텀_구분_예외_테스트(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringSeparator.split(input));
    }

    private static Stream<Arguments> generateCustomInputArgument(){
        return Stream.of(
                Arguments.of("//;\n1;2;3", 3),
                Arguments.of("//,\n1,2,3", 3),
                Arguments.of("//=\n1=3", 2)
        );
    }
}
