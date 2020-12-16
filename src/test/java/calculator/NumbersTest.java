package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    @DisplayName("덧셈 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3=6", "6,6,6=18"}, delimiter = '=')
    void sumTest(String source, int total) {
        Numbers numbers = Numbers.of(source);

        assertThat(numbers.sum()).isEqualTo(total);
    }
}
