package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class CalculatorInputTest {

    @DisplayName("빈 문자열 또는 null 값을 체크한다")
    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String input) {
        CalculatorInput calculatorInput = new CalculatorInput(input);
        Assertions.assertTrue(calculatorInput.isUnusable());
    }
}
