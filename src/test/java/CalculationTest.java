import model.Calculation;
import model.NumberSentence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculationTest {

    @ParameterizedTest
    @DisplayName("더하기 계산 Test")
    @CsvSource(value = {"1:+:2:3", "2:+:4:6"}, delimiter = ':')
    void plus(String firstInput, String operator, String secondInput, int resultInput){
        // given
        NumberSentence numberSentence = new NumberSentence(new String[]{firstInput, operator, secondInput});
        // when
        int result = Calculation.calculate(numberSentence);
        // then
        assertThat(result).isEqualTo(resultInput);
    }

    @ParameterizedTest
    @DisplayName("빼기 계산 Test")
    @CsvSource(value = {"1:-:2:-1", "2:-:4:-2"}, delimiter = ':')
    void minus(String firstInput, String operator, String secondInput, int resultInput) {
        // given
        NumberSentence numberSentence = new NumberSentence(new String[]{firstInput, operator, secondInput});
        // when
        int result = Calculation.calculate(numberSentence);
        // then
        assertThat(result).isEqualTo(resultInput);
    }

    @ParameterizedTest
    @DisplayName("곱하기 계산 Test")
    @CsvSource(value = {"1:*:2:2", "2:*:4:8"}, delimiter = ':')
    void multiple(String firstInput, String operator, String secondInput, int resultInput) {
        // given
        NumberSentence numberSentence = new NumberSentence(new String[]{firstInput, operator, secondInput});
        // when
        int result = Calculation.calculate(numberSentence);
        // then
        assertThat(result).isEqualTo(resultInput);
    }

    @ParameterizedTest
    @DisplayName("나누기 계산 Test")
    @CsvSource(value = {"4:/:2:2", "32:/:4:8"}, delimiter = ':')
    void divide(String firstInput, String operator, String secondInput, int resultInput) {
        // given
        NumberSentence numberSentence = new NumberSentence(new String[]{firstInput, operator, secondInput});
        // when
        int result = Calculation.calculate(numberSentence);
        // then
        assertThat(result).isEqualTo(resultInput);
    }

}
