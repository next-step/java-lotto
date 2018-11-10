package calculator;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringStringCalculatorTest {

    @Test
    public void 덧셈_빈문자열() {
        int result = StringCalculator.add("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 덧셈_숫자하나() {
        int result = StringCalculator.add("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 덧셈_쉼표가_포함된_숫자둘() {
        int result = StringCalculator.add("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 덧셈_쉼표와_세미콜론이_포함된_숫자둘() {
        int result = StringCalculator.add("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 덧셈_커스텀_구분자가_포함된_숫자둘() {
        int result = StringCalculator.add("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void 덧셈_허용하지않는_음수값() {
        int result = StringCalculator.add("-1:2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void 덧셈_허용지않는_숫자이외의값() {
        int result = StringCalculator.add("K:1:3");
        assertThat(result).isEqualTo(6);
    }
}
