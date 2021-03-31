package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class InputNumbersTest {

    static Stream<Arguments> parameters() {
        return Stream.of(
                arguments(null, "0"),
                arguments("", "0"),
                arguments(" ", "0")
        );
    }

    @ParameterizedTest
    @DisplayName("기본 구분자 확인")
    @ValueSource(strings = {"1,2,3", "1:2:3"})
    void splitDefault(String input) {
        assertThat(new InputNumbers(input).numbers()).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 구분자 확인")
    void splitCustom() {
        assertAll(
                () -> assertThat(new InputNumbers("//;\n1;2;3").numbers()).containsExactly("1", "2", "3"),
                () -> assertThat(new InputNumbers("// \n1 2 3").numbers()).containsExactly("1", "2", "3")
        );
    }

    @ParameterizedTest
    @DisplayName("생성자 테스트")
    @MethodSource("parameters")
    void create(String input, String expected) {
        assertThat(new InputNumbers(input)).isEqualTo(new InputNumbers(expected));
    }
}
