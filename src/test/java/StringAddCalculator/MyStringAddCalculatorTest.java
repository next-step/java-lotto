package StringAddCalculator;

import org.junit.jupiter.api.Test;

import static StringAddCalculator.utils.Constants.ERROR_NEGATIVE_NUMBER;
import static StringAddCalculator.utils.Constants.ERROR_NOT_A_NUMBER;
import static StringAddCalculator.utils.Validations.CheckCustomDelimiter.returnCustomDelimiter;
import static org.assertj.core.api.Assertions.assertThat;

public class MyStringAddCalculatorTest {
    //RuntimeException error Check how?
/*
    @Test
    public void splitAndSum_negative2() throws NegativeNumberException, NotANumberException {
        assertThat(StringAddCalculator.splitAndSum("1,2,-3"))
                .isEqualTo(ERROR_NEGATIVE_NUMBER);
    }

    @Test
    public void splitAndSum_notANumber1() throws NotANumberException, NegativeNumberException {
        assertThat(StringAddCalculator.splitAndSum(" ,2,3"))
                .isEqualTo(ERROR_NOT_A_NUMBER);
    }

    @Test
    public void splitAndSum_notANumber2() throws NotANumberException, NegativeNumberException {
        assertThat(StringAddCalculator.splitAndSum("1,::3"))
                .isEqualTo(ERROR_NOT_A_NUMBER);

    }
*/
    @Test
    public void matcherTest() throws Exception {
        assertThat(returnCustomDelimiter("//;\n1;2;3")).isEqualTo(";");
        assertThat(returnCustomDelimiter("//:\n1:2:3")).isEqualTo(":");
        // //와\n사이가 아닐 경우 ERROR
        assertThat(returnCustomDelimiter("/;\n1;2;3")).isEqualTo(null);
        assertThat(returnCustomDelimiter("//;1;2;3")).isEqualTo(null);
        // 원래 구분자, 커스텀 구분자 병행 가능함???
//        assertThat(returnCustomDelimiter("//;\n1;2,3;4")).isEqualTo(";");
//        assertThat(returnCustomDelimiter("//;\n1,2,3,4")).isEqualTo(";");
//        assertThat(returnCustomDelimiter("//;\n1,2:3;4")).isEqualTo(";");
//        assertThat(returnCustomDelimiter("/;\n1,2,3,4")).isEqualTo(null);

        /*
        assertThatThrownBy(() ->
                StringCalculator.calculate(expression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.INPUT_VALUE_IS_EMPTY);
         */
    }
}
