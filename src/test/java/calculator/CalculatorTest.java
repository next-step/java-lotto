package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @DisplayName("빈 문자열 또는 null 을 입력한 경우 0을 반환한다")
    @ParameterizedTest
    @NullAndEmptySource
    public void emptyOrNullInputReturnZeroTest(String input){
        // given
        Calculator calculator = new Calculator();

        // when
        int result = calculator.plus(input);

        // then
        assertThat(result).isEqualTo(0);
    }
}
