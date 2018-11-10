package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @Before
    public void setUp(){
        calculator = new StringCalculator();
    }

    @Test
    public void add_숫자하나(){
        assertThat(calculator.add("1")).isEqualTo(1);
    }

    @Test
    public void add_수시표구분자() {
        assertThat(calculator.add("1,2")).isEqualTo(3);

    }

    @Test
    public void add_쉼표_또는_콜론_구분자() {
        assertThat(calculator.add("1,2:3")).isEqualTo(6);

    }

    @Test
    public void add_구분자_정하기() {
        assertThat(calculator.add("//;\n1;2;3")).isEqualTo(6);

    }

    @Test(expected = RuntimeException.class)
    public void 숫자_아닌값_또는_음수값() {
        calculator.add("-1;2;3");
    }

}
