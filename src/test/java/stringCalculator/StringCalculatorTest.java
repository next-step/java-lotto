package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    @DisplayName("빈 문자열 또는 null 확인")
    void isEmptyOrNullTest(){
        String emptyString = "";
        String nullString = null;
        boolean emptyResult = stringCalculator.isEmptyOrNull(emptyString);
        boolean nullResult = stringCalculator.isEmptyOrNull(nullString);

        assertThat(emptyResult).isTrue();
        assertThat(nullResult).isTrue();
    }

    @Test
    @DisplayName("덧셈")
    void plusCalculateTest(){
        String[] numbers = {"1","2","3"};
        int result = stringCalculator.plusCalculate(numbers);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 확인")
    void negativeNumberExceptionTest(){
        String negativeNumber = "-1";
        assertThatThrownBy(()-> stringCalculator.checkNegativeNumberOrNotNumber(negativeNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 외의 값 확인")
    void notNumberExceptionTest() {
        String notNumberString = "a";
        assertThatThrownBy(() -> stringCalculator.checkNegativeNumberOrNotNumber(notNumberString))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("문자열 덧셈 계산기")
    void stringPlusCalculate(){
        String inputString = "//a\n1a2,3;4";
        int result = stringCalculator.calculate(inputString);
        assertThat(result).isEqualTo(10);
    }

}
