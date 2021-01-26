package stringadder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringAdderTest {
    @DisplayName("입력값이 null일 경우 0을 반환한다.")
    @Test
    void NullShouldReturnZero() {
        StringAdder adder = new StringAdder(null);

        assertThat(adder.add()).isEqualTo(0);
    }

    @DisplayName("입력값이 빈 문자열일 경우 0을 반환한다.")
    @Test
    void EmptyStringShouldReturnZero() {
        StringAdder adder = new StringAdder("");

        assertThat(adder.add()).isEqualTo(0);
    }

    @DisplayName("숫자값이 1개일 경우 해당 숫자를 반환한다.")
    @Test
    void SingleNumberShouldReturnSameNumber() {
        StringAdder adder = new StringAdder("1");

        assertThat(adder.add()).isEqualTo(1);
    }

    @DisplayName("숫자값이 2개 이상일 경우 여러 숫자의 합을 반환한다.")
    @ParameterizedTest
    @CsvSource({
        "'1,2', 3",
        "'1,2,3', 6"
    })
    void MultipleNumberShouldReturnAddOfNumbers(String input, int expected) {
        StringAdder adder = new StringAdder(input);

        assertThat(adder.add()).isEqualTo(expected);
    }

    @DisplayName("숫자가 아닌 값 또는 음수가 전달된 경우 예외를 던진다")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "notnumber"})
    void NotValidInputShouldThrowRuntimeException(String input) {
        StringAdder adder = new StringAdder(input);

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(
            () -> adder.add()
        );
    }
}