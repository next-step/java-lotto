package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    public void add_null_또는_빈문자() {
        assertThat(StringCalculator.add(null)).isEqualTo(0);
        assertThat(StringCalculator.add("")).isEqualTo(0);
    }

    @Test
    public void add_숫자하나() {
        int result = StringCalculator.add("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void add_숫자둘_쉼표() {
        int result = StringCalculator.add("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void add_숫자셋_콜론() {
        int result = StringCalculator.add("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void add_숫자_커스텀구분자() {
        int result = StringCalculator.add("//!\n1!2!3!4");
        assertThat(result).isEqualTo(10);
    }

    @Test(expected = RuntimeException.class)
    public void add_음수() {
        int result = StringCalculator.add("-1,2,3");
    }
}
