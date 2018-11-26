import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringCalculatorTest {

    @Test
    public void 숫자하나덧셈() {
        int result = StringCalculator.calculator("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 공백이면_0을반환(){
        int result = StringCalculator.calculator("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 쉼표구분자덧셈(){
        int result = StringCalculator.calculator("1,5");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 콜론구분자덧셈(){
        int result = StringCalculator.calculator("1:5");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 커스텀구분자덧셈(){
        int result = StringCalculator.calculator("//;\n1;5");
        assertThat(result).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void 음수면_예외던짐(){
        int result = StringCalculator.calculator("5:-1:3");
    }
}