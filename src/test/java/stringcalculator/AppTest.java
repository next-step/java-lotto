package stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppTest {

    @ParameterizedTest
    @CsvSource(value = {"'2 + 3 * 4 / 2', 10", "'4 * 1' , 4"})
    void 계산_문자열을_입력하면_계산한다(String source, int expected) {
        assertThat(App.calculate(source)).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 널값이나_빈문자열을_입력하면_예외를_던진다(String source) {
        assertThrows(IllegalArgumentException.class, () -> App.calculate(source));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 +", "1", "+ 1", "1 + +", "1 2"})
    void 잘못된_입력값은_예외를_던진다(String source) {
        assertThrows(IllegalArgumentException.class, () -> App.calculate(source));
    }

}
