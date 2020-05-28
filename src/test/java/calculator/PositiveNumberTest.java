package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveNumberTest {

    @DisplayName("0 혹은 자연수로 PositiveNumber를 생성하는데 성공")
    @ParameterizedTest
    @MethodSource("source_create_positiveNumber_shouldSucceed")
    public void create_positiveNumber_shouldSucceed(String input, String expected) {
        PositiveNumber result = PositiveNumber.of(input);
        assertThat(result).isEqualTo(PositiveNumber.of(expected));
    }

    private static Stream<Arguments> source_create_positiveNumber_shouldSucceed() {
        return Stream.of(
                Arguments.of("0", "0"),
                Arguments.of("1", "1"),
                Arguments.of("100", "100"),
                Arguments.of("123", "123"));
    }

    @DisplayName("숫자 이외의 값 또는 음수를 전달하는 경우 throw NumberFormatException")
    @ParameterizedTest
    @MethodSource("source_create_invalidNumber_shouldFail")
    public void create_invalidNumber_shouldFail(String input) {
        assertThatThrownBy(() -> {
            PositiveNumber.of(input);
        }).isInstanceOf(NumberFormatException.class);
    }

    private static Stream<Arguments> source_create_invalidNumber_shouldFail() {
        return Stream.of(
                Arguments.of("-1"),
                Arguments.of("~"),
                Arguments.of("a"),
                Arguments.of("b"));
    }

}
