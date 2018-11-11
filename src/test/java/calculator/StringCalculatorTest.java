package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void 빈문자열_입력() {
        int result = StringCalculator.add("");

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void null입력() {
        int result = StringCalculator.add(null);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 숫자_하나_더하기() {
        int result1 = StringCalculator.add("1");
        int result2 = StringCalculator.add("2");

        assertThat(result1).isEqualTo(1);
        assertThat(result2).isEqualTo(2);
    }

    @Test
    public void 숫자_두개_더하기_쉼표_구분자() {
        int result = StringCalculator.add("3,4");
        assertThat(result).isEqualTo(7);
    }

    @Test
    public void 숫자_여러개_더하기_쉼표_구분자() {
        int result = StringCalculator.add("2,4,2,4");
        assertThat(result).isEqualTo(12);
    }

    @Test
    public void 숫자_여러개_더하기_콜론_구분자() {
        int result = StringCalculator.add("1:2:3:4");
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void 커스텀_구분자_더하기() {
        String customExpression = "//;\n1;2;3";

        int result = StringCalculator.add(customExpression);

        assertThat(result).isEqualTo(6);
    }


}
