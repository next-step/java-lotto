package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @DisplayName("빈 문자열 또는 null 을 입력한 경우 0을 반환한다")
    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String input){
        // given
        StringAddCalculator calculator = new StringAddCalculator();

        // when
        int result = calculator.plus(input);

        // then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "3,3", "4,4"})
    public void splitAndSum_숫자하나(String input, int expected){
        // given
        StringAddCalculator calculator = new StringAddCalculator();

        // when
        int result = calculator.plus(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
