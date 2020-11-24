package calculator;

import calculator.to.StringSumCalculatorInput;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorInputParserTest {
    @Test
    void testParse(){

        StringSumCalculatorInput stringSumCalculatorInput = StringCalculatorInputParser.parse("1,2");
        assertThat(stringSumCalculatorInput).isNotNull();
        assertThat(stringSumCalculatorInput.getDelimiter()).isNullOrEmpty();
        assertThat(stringSumCalculatorInput.getParameters()).isEqualTo("1,2");
    }

    @Test
    void testParseWithEmptyString(){
        StringSumCalculatorInput stringSumCalculatorInput = StringCalculatorInputParser.parse("");
        assertThat(stringSumCalculatorInput).isNotNull();
        assertThat(stringSumCalculatorInput.getDelimiter()).isNullOrEmpty();
        assertThat(stringSumCalculatorInput.getParameters()).isNullOrEmpty();
    }

    @Test
    void testParseWithDelimiter(){
        StringSumCalculatorInput stringSumCalculatorInput = StringCalculatorInputParser.parse("//-\n1-2");
        assertThat(stringSumCalculatorInput).isNotNull();
        assertThat(stringSumCalculatorInput.getDelimiter()).isEqualTo("-");
        assertThat(stringSumCalculatorInput.getParameters()).isEqualTo("1-2");
    }
}
