package stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.SortedMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"'1 + 2' , 3", "'1 - 2' , -1", "'1 * 2' , 2", "'2 / 1' , 2"})
    void 연산자에_따라_계산한다(String source, int expected) {
        assertThat(new StringCalculator(source).calculate()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 # 2"})
    void 지원되는_연산자가_아니면_예외를_던진다(String source) {
        assertThrows(IllegalArgumentException.class, () -> new StringCalculator(source).calculate());
    }

}
