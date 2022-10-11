package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    @Test
    public void split_null() {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.split(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    public void split_빈공백문자(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.split(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "1 3:2", "-1 + 1:3", "2 + 3 * 4 / 2:7"}, delimiter = ':')
    public void split(String text, int expectedSize) {
        List<String> resultList = StringCalculator.split(text);
        assertThat(resultList.isEmpty()).isFalse();

        assertThat(resultList).hasSize(expectedSize);
    }


}
