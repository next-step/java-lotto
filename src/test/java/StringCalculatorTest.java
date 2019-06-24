import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    String input;

    @Test
    public void 숫자_하나_입력시_해당_숫자_반환() {
        input = "10";
        int output = StringCalculator.calculator(input);
        assertThat(output).isEqualTo(Integer.parseInt(input));
    }

    @Test
    public void 쉼표_구분자_숫자_두개_입력시_합계를_반환(){
        input = "2,3";
        int sum = StringCalculator.calculator(input);
        assertThat(sum).isEqualTo(5);
    }

    @Test
    public void 콜론_구분자_숫자_두개_입력시_합계를_반환(){
        input = "2:3";
        int sum = StringCalculator.calculator(input);
        assertThat(sum).isEqualTo(5);
    }

    @Test
    public void 쉼표_콜론_구분자_숫자_두개_입력시_합계를_반환(){
        input = "1:3,1";
        int sum = StringCalculator.calculator(input);
        assertThat(sum).isEqualTo(5);
    }

     @Test
    public void 빈_문자열_입력시_0_반환() {
        input = "";
        int output = StringCalculator.calculator(input);
        assertThat(output).isEqualTo(0);
    }

    @Test
    public void NULL_입력시_0_반환() {
        input = null;
        int output = StringCalculator.calculator(input);
        assertThat(output).isEqualTo(0);
    }

    @Test
    public void 음수_입력시_RuntimeException() {
        input = "-1";
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            StringCalculator.calculator(input);
        });
    }

    @Test
    public void 숫자_이외의_값_입력시_RuntimeException() {
        input = "a";
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            StringCalculator.calculator(input);
        });
    }

    @Test
    public void 입력_문자가_숫자_이다() {
        input = "2";
        assertThat(StringCalculator.isNumber(input)).isEqualTo(true);
    }

    @Test
    public void 입력_문자가_숫자가_아니다() {
        input = "a";
        assertThat(StringCalculator.isNumber(input)).isEqualTo(false);
    }

}
