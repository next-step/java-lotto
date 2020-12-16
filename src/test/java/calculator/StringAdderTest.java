package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringAdderTest {

    @DisplayName("null 또는 빈 문자열 계산 시 0으로 계산되는지 확인한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNullTest(String source) {
        int sum = StringAdder.splitAndSum(source);

        assertThat(sum).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 전달 시 해당 숫자로 반환하는지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void oneNumberTest(String source) {
        int sum = StringAdder.splitAndSum(source);

        assertThat(sum).isEqualTo(Integer.parseInt(source));
    }

    @DisplayName("두 개이상 숫자가 있는 문자열로 전달 시 숫자의 합을 반환하는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "2:3=5", "1,2,3=6", "1:2:3=6"}, delimiter = '=')
    void twoNumberTest(String source, int total) {
        int sum = StringAdder.splitAndSum(source);

        assertThat(sum).isEqualTo(total);
    }

    @DisplayName("두 개의 구분자가 있는 문자열로 전달 시 숫자의 합을 반환하는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2:5=8", "2:3,1=6"}, delimiter = '=')
    void twoDelimiterTest(String source, int total) {
        int sum = StringAdder.splitAndSum(source);

        assertThat(sum).isEqualTo(total);
    }

    @DisplayName("커스텀 구분자가 있는 문자열로 전달 시 숫자의 합을 반환하는지 확인한다.")
    @ParameterizedTest
    @MethodSource("provideCustomDelimiterString")
    void customDelimiterTest(String source, int total) {
        int sum = StringAdder.splitAndSum(source);

        assertThat(sum).isEqualTo(total);
    }

    private static Stream<Arguments> provideCustomDelimiterString() {
        return Stream.of(
                Arguments.of("//,\n1,2,3", 6),
                Arguments.of("//!\n1!2!3", 6)
        );
    }

    @DisplayName("음수가 있는 문자열로 전달 시 숫자의 합을 반환하는지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "1,-2"})
    void minusNumberTest(String source) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringAdder.splitAndSum(source));
    }
}
