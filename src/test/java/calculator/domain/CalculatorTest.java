package calculator.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2,10", "1 + 1,2", "1 - 1,0", "0 - 1,-1", "1 * 1, 1", "1 / 1, 1", "0 + 0, 0"})
    void 순서대로_계산이_되어야한다(String input, int expected) {
        assertThat(Calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10 / 3", "10 / 4"})
    void 나눗셈은_정수로_떨어지는_값으로_한정한다(String input) {
        assertThatExceptionOfType(InvalidParameterException.class)
                .isThrownBy(() -> {
                    Calculator.calculate(input);
                });
    }

    @ParameterizedTest
    @ValueSource(strings = {"10 / 0"})
    void 나눗셈은_0으로_나눠지면_안된다(String input) {
        assertThatExceptionOfType(InvalidParameterException.class)
                .isThrownBy(() -> {
                    Calculator.calculate(input);
                });
    }

    @ParameterizedTest
    @ValueSource(strings = {"a / 0", "가 / 0", "2+3 * 4/2"})
    void 숫자가_아닌_값이_들어오면_안된다(String input) {
        assertThatExceptionOfType(InvalidParameterException.class)
                .isThrownBy(() -> {
                    Calculator.calculate(input);
                });
    }

    @Test
    void 공백이_들어오면_안된다() {
        assertThatExceptionOfType(InvalidParameterException.class)
                .isThrownBy(() -> {
                    Calculator.calculate("");
                });
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:2,3,4,2", "1 + 1:1,1"}, delimiter = ':')
    void 수식에서_숫자만_뽑아낸다(String input, String expected) {
        List<Integer> expectedList = new ArrayList<>();
        for (String expectValue : Arrays.asList(expected.split(","))) {
            expectedList.add(Integer.parseInt(expectValue));
        }
        assertThat(Calculator.getNumbers(input.split(" "))).containsSequence(expectedList);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:+,*,/", "1 + 1:+"}, delimiter = ':')
    void 수식에서_연산자만_뽑아낸다(String input, String expected) {
        assertThat(Calculator.getOperations(input.split(" "))).containsSequence(Arrays.asList(expected.split(",")));
    }
}
