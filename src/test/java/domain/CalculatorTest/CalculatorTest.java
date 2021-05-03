package domain.CalculatorTest;

import domain.Calculator.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @DisplayName("문자열을 입력을 안할시 0을 반환한다.")
    @Test
    public void invalidatedNumber(){
        Calculator calculator = new Calculator();
        Assertions.assertThat(calculator.invalidatedNumber("")).isEqualTo(0);
    }

    @DisplayName("쉼표(,) 을 구분자로 가지는 문자열을 전달하는 경우 합을 반환한다.")
    @Test
    public void gubun1sum(){
        Calculator calculator = new Calculator();
        Assertions.assertThat(calculator.invalidatedNumber("9,9,9")).isEqualTo(27);
    }
    @DisplayName("콜론(:) 을 구분자로 가지는 문자열을 전달하는 경우 합을 반환한다.")
    @Test
    public void gubun2sum(){
        Calculator calculator = new Calculator();
        Assertions.assertThat(calculator.invalidatedNumber("9:9:9")).isEqualTo(27);
    }
    @DisplayName("쉼표(,) 또는 콜론(:) 을 구분자로 가지는 문자열을 전달하는 경우 합을 반환한다.")
    @Test
    public void gubun3sum(){
        Calculator calculator = new Calculator();
        Assertions.assertThat(calculator.invalidatedNumber("9:9,9")).isEqualTo(27);
    }
}
