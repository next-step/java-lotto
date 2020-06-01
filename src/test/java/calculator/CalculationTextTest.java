package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculationTextTest {


    CalculationText calculationText = new CalculationText();

    static Stream<String> blankStrings() {
        return Stream.of("", " ", null);
    }

    @ParameterizedTest
    @MethodSource("blankStrings")
    void null_또는_빈문자(final String testValue) {
        String[] test = {"0"};
        assertThat(calculationText.divide(testValue)).contains(test).hasSize(1);
    }


    @ParameterizedTest
    @CsvSource(value = {"1^0",
                    "1,2^1",
                    "1,2:3^2"},
                    delimiter = '^')
    void 숫자테스트(String text, int num) throws Exception {
        String[][] test = {{"1"}, {"1", "2"}, {"1","2","3"}};
        assertThat(calculationText.divide(text)).contains(test[num]);
    }

    @Test
    void 커스텀_숫자테스트() throws Exception {
        String[] test = {"1", "2", "3"};
        assertThat(calculationText.divide("//;\n1;2;3")).contains(test);
    }


}
