package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "'1,2,3', 6",
            "'1,2:4', 7",
    })
    void sumByDefaultExpression(String inputOfString, int expectedResult) {
        int result =  StringCalculator.calculator(inputOfString);
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void sumByInputIsEmpty(String inputOfEmpty) {
        int result =  StringCalculator.calculator(inputOfEmpty);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({
            "'//;\n1;2;3', 6",
            "'//a\n1a2a3', 6"
    })
    void sumByInputWithCustomDelimiter(String inputOfEmpty, int expectedResult) {
        int result =  StringCalculator.calculator(inputOfEmpty);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void sumByWrongInputThenFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculator("-1,2,3"));
    }
}
