package StringCalculator.View;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @Test
    public void nullTest() {
        assertThatThrownBy(() -> InputView.validate(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void emptyTest() {
        assertThatThrownBy(() -> InputView.validate(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputView.validate("  "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 _ 3", "a + b"})
    public void invalidCharacters(String inputString) {
        assertThatThrownBy(() -> InputView.validate(inputString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2"})
    public void validCharacters(String inputString) {
        assertThat(InputView.validate(inputString)).isEqualTo(inputString);
    }
}
