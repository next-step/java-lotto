package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MathOperatorTest {

    MathOperator mathOperator;

    @ParameterizedTest()
    @CsvSource(value = {"2,2,+,4", "2,2,-,0", "3,2,*,6", "6,2,/,3"})
    void apply사칙연산_테스트(int firstNumber, int secondNumber, String operator, int resultNumber) {
        mathOperator = MathOperator.selectOperator(operator);
        assertThat(mathOperator.apply(firstNumber, secondNumber)).isEqualTo(resultNumber);
    }
}