package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"//[\\n1[2[3=6", "//*\\n1*2*8=11"}, delimiter = '=')
    void calculateTest(String str, String sum) {
        assertThat(Calculator.plus(str) == Integer.parseInt(sum)).isTrue();
    }


}
