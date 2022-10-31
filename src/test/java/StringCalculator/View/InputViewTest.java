package StringCalculator.View;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @Test
    @DisplayName("null은 입력 불가")
    public void nullTest() {
        assertThatThrownBy(() -> InputView.validate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("null은 입력 불가");
    }

    @Test
    @DisplayName("공백은 입력 불가")
    public void emptyTest() {
        assertThatThrownBy(() -> InputView.validate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백은 입력 불가");
        assertThatThrownBy(() -> InputView.validate("  "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백은 입력 불가");
    }

    @ParameterizedTest
    @CsvSource(value = {"1 _ 3", "a + b"})
    @DisplayName("숫자와 연산자 (+, -, /, *) 외 입력 불가")
    public void invalidCharacters(final String inputString) {
        assertThatThrownBy(() -> InputView.validate(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자와 연산자 (+, -, /, *) 외 입력 불가");
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2"})
    @DisplayName("통과 테스트")
    public void validCharacters(final String inputString) {
        assertThat(InputView.validate(inputString)).isEqualTo(inputString);
    }
}
