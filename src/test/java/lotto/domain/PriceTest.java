package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PriceTest {

    @DisplayName("0 혹은 자연수로 Price 생성하는데 성공")
    @ParameterizedTest
    @MethodSource("source_create_positiveNumber_shouldSucceed")
    public void create_positiveNumber_shouldSucceed(String input, Price expected) {
        Price result = Price.of(input);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> source_create_positiveNumber_shouldSucceed() {
        return Stream.of(
                Arguments.of("0", Price.of("0")),
                Arguments.of("1000", Price.of("1000")),
                Arguments.of("2000", Price.of("2000")),
                Arguments.of("10000", Price.of("10000")));
    }

    @DisplayName("숫자 이외의 값 또는 음수를 전달하는 경우 throw NumberFormatException")
    @ParameterizedTest
    @MethodSource("source_create_invalidParameters_shouldFail")
    public void create_invalidParameters_shouldFail(String input) {
        assertThatThrownBy(() -> {
            Price.of(input);
        }).isInstanceOf(NumberFormatException.class);
    }

    private static Stream<Arguments> source_create_invalidParameters_shouldFail() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("-1000"),
                Arguments.of("-20000"));
    }

    @DisplayName("Null을 전달하는 경우 throw NumberFormatException")
    @ParameterizedTest
    @NullSource
    public void create_nullParameters_shouldFail(String input) {
        assertThatThrownBy(() -> {
            Price.of(input);
        }).isInstanceOf(NumberFormatException.class);
    }
}
