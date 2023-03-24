import letterCalculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class calculatorTest {

    Calculator calculator;

    @Test
    @DisplayName("계산기 테스트 ")
    void CalculatorTest() {
        final Calculator calulator = new Calculator("//;\n1;2;3");
        assertThat( calculator.calculator()).isEqualTo(6);
    }

    @DisplayName(" 문자 사이에 커스텀 구분자를 지정할 수 있다, 쉼표(,)나 콜론(:)을 구분자로 사용한다.")
    @Test
    void splitTest(){
        final Calculator calulator =  new Calculator("1,2:3");
        String[] Text = calculator.separatorFuntion();
    }

    @DisplayName("빈 문자열 또는 null을 입력할 경우 0을 반환한다.")
    @Test
    void returnNull_or_0() {
        final Calculator calulator = new Calculator("");
        int result = calculator.returnZero();
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("음수는 사용할수 없다. ")
    void negativeNumberCheckTest() {
        final String[] numbers = {"1","2","-3"};
        calculator.negativeInputNumberCheck(numbers);
    }
    @DisplayName("구분자 외의 문자열은 숫자만 허용한다 ")
    @Test
    void actualValidate() {
        final String numbers = "@";
        calculator.actualValidate(numbers);
    }


}
