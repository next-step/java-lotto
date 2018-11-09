package calculator;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @Test
    public void add_숫자하나(){
        calculator = new StringCalculator();
        int result = calculator.add("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void add_수시표구분자() {
        calculator = new StringCalculator();
        int result = calculator.add("1,2");
        assertThat(result).isEqualTo(3);

    }

    @Test
    public void add_쉼표_또는_콜론_구분자() {
        calculator = new StringCalculator();
        int result = calculator.add("1,2:3");
        assertThat(result).isEqualTo(6);

    }

    @Test
    public void add_구분자_정하기() {
        calculator = new StringCalculator();
        int result = calculator.add("//;\n1;2;3");
        assertThat(result).isEqualTo(6);

    }

    @Test(expected = RuntimeException.class)
    public void 숫자_아닌값_또는_음수값() {
        calculator = new StringCalculator();
        calculator.add("-1;2;3");
    }

}
