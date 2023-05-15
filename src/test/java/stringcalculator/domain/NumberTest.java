package stringcalculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @ParameterizedTest
    @CsvSource(value = {"1,+,1,2", "1,-,1,0", "2,*,3,6", "2,/,2,1"})
    void numberOpertaeTest(long existNumber, String inputOperator, long inputNumber, long expected) {
        Number number = new Number(existNumber);
        assertThat(number.operate(Operator.symbolOf(inputOperator), new Number(inputNumber)))
            .isEqualTo(new Number(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = {"d","a1"})
    void generateNumberErrorTest(String input) {
        assertThatThrownBy(() -> Number.of(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "-1,-1"})
    void generateNumberTest(String input, long expected) {
        Number number = Number.of(input);
        assertThat(number).isEqualTo(new Number(expected));
    }
}