package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculationTextTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void null_빈문자_테스트(String emptyString) {
        String[] expected = {"0"};
        CalculationText calculationText = new CalculationText(emptyString);
        assertThat(calculationText.getDivideString()).contains(expected).hasSize(1);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void null_또는_빈문자(String emptyString) {
        String[] expected = {"0"};
        CalculationText calculationText = new CalculationText(emptyString);
        assertThat(calculationText.getDivideString()).contains(expected).hasSize(1);
    }


    @ParameterizedTest
    @CsvSource(value = {"1^0",
                    "1,2^1",
                    "1,2:3^2"},
                    delimiter = '^')
    void 숫자테스트(String text, int num) throws Exception {
        String[][] expected = {{"1"}, {"1", "2"}, {"1","2","3"}};
        CalculationText calculationText = new CalculationText(text);
        assertThat(calculationText.getDivideString()).contains(expected[num]);
    }

    @Test
    void 커스텀_숫자테스트() throws Exception {
        String[] expected = {"1", "2", "3"};
        CalculationText calculationText = new CalculationText("//;\n1;2;3");
        assertThat(calculationText.getDivideString()).contains(expected);
    }


}
