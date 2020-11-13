package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    StringCalculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2=3","1,2,3=6", "1,2:3=6"}, delimiterString = "=")
    void sum(String expression, int expected){
        assertThat(calculator.sum(expression)).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void sumNullAndEmpty(String expression){
        assertThat(calculator.sum(expression)).isEqualTo(0);
    }
}
