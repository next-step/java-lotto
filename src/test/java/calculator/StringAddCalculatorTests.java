package calculator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTests {

    @DisplayName("null 이나 빈 문자열 시 0 반환 테스트")
    @ParameterizedTest
    @EmptySource
    void blankOrNullTest(String input){
        StringAddCalculator stringAddCalculator = new StringAddCalculator();

        int result = stringAddCalculator.calculate(input);

        assertThat(result).isEqualTo(0);
    }
}
