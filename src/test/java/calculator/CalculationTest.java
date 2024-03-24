package calculator;

import calculator.model.Calculation;
import calculator.model.NumberSentence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculationTest {

    @ParameterizedTest
    @DisplayName("계산 Test")
    @CsvSource(value = {"1:+:2:3", "2:+:4:6", "1:-:2:-1", "2:-:4:-2", "1:*:2:2", "2:*:4:8", "4:/:2:2", "32:/:4:8"}, delimiter = ':')
    void plus(String firstInput, String operator, String secondInput, int resultInput){
        // given
        NumberSentence numberSentence = new NumberSentence(new String[]{firstInput, operator, secondInput});
        // when
        int result = Calculation.calculate(numberSentence);
        // then
        assertThat(result).isEqualTo(resultInput);
    }
}
