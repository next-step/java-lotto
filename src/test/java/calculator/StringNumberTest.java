package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringNumberTest {

    @DisplayName("입력값이 공백 혹은 null 일 경우 0 반환")
    @ParameterizedTest
    @MethodSource("emptyOrNullProvider")
    void emptyOrNullCheck(String empty) {
        int result = new StringNumber(empty).getValue();
        assertThat(result).isEqualTo(0);
    }

    static Stream<String> emptyOrNullProvider() {
        return Stream.of("", null);
    }

    @DisplayName("입력값이 음수이거나 숫자가 아닐 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "a"})
    void validateMinus(String input) {
        assertThatThrownBy(() -> new StringNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}