package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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

    @DisplayName("숫자 두개를 (,) 구분자로 입력할 경우 두 숫자의 합을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,1:2", "2,2:4", "3,3:6", "4,4:8"}, delimiterString = ":")
    public void splitAndSum_쉼표구분자(String input, int expected){
        // given
        StringAddCalculator calculator = new StringAddCalculator();

        // when
        int result = calculator.plus(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("구분자를 (,) 이외 (:)을 사용할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"1,1:2;4", "2,2:4;8", "3,3:6;12", "4,4:8;16"}, delimiterString = ";")
    public void splitAndSum_쉼표_또는_콜론_구분자(String input, int expected){
        // given
        StringAddCalculator calculator = new StringAddCalculator();

        // when`
        int result = calculator.plus(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
