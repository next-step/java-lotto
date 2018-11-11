package stringcalculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void add_숫자하나() throws Exception {
        int result = StringCalculator.add("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void add_숫자_null인_경우() throws Exception {
        int result = StringCalculator.add("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void add_숫자_공백인_경우() throws Exception {
        int result = StringCalculator.add(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void add_숫자하나_이상인_경우() throws Exception {
        int result = StringCalculator.add("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void add_커스텀_문자열인_경우() throws Exception {
        int result = StringCalculator.add("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test(expected = Exception.class)
    public void exceptionTest() throws Exception {
        int result = StringCalculator.add("-1,d,-2");
    }
}