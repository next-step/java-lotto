package calculator;

import calculator.to.StringSumCalculatorInput;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputParserTest {
    @Test
    void testParse(){

        StringSumCalculatorInput stringSumCalculatorInput = InputParser.parse("1,2");
        assertThat(stringSumCalculatorInput).isNotNull();
        assertThat(stringSumCalculatorInput.getDelimiter()).isNullOrEmpty();
        assertThat(stringSumCalculatorInput.getParameters()).isEqualTo("1,2");
    }

    @Test
    void testParseWithEmptyString(){
        StringSumCalculatorInput stringSumCalculatorInput = InputParser.parse("");
        assertThat(stringSumCalculatorInput).isNotNull();
        assertThat(stringSumCalculatorInput.getDelimiter()).isNullOrEmpty();
        assertThat(stringSumCalculatorInput.getParameters()).isNullOrEmpty();
    }

    @Test
    void testParseWithDelimiter(){
        StringSumCalculatorInput stringSumCalculatorInput = InputParser.parse("//-\n1-2");
        assertThat(stringSumCalculatorInput).isNotNull();
        assertThat(stringSumCalculatorInput.getDelimiter()).isEqualTo("-");
        assertThat(stringSumCalculatorInput.getParameters()).isEqualTo("1-2");
    }
}
