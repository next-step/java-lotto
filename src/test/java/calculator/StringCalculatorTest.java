package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @DisplayName("기본 구분자 합계 계산")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2:3"})
    void defaultDelimeterCalculateTest(String text) {
        StringCalculator calculator = new StringCalculator();
        int actual = calculator.calculate(text);
        assertThat(actual).isEqualTo(6);
    }
    
    @DisplayName("커스텀 구분자 합계 계산")
    @Test
    void customDelimiterCalculatorTest() {
        String text = "//;\n1;2;3;4";
        StringCalculator calculator = new StringCalculator();
        int actual = calculator.calculate(text);
        assertThat(actual).isEqualTo(10);
    }

}