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
        boolean emptyResult = stringCalculator.isCorrectString(emptyString);
        boolean nullResult = stringCalculator.isCorrectString(nullString);

        assertThat(emptyResult).isFalse();
        assertThat(nullResult).isFalse();
    }

    @Test
    @DisplayName("문자열 구분자")
    void separatorTest(){
        String inputString = "1,2;3;";
        String[] stringArray = StringUtil.complicatedSeparator(inputString);
        assertThat(stringArray).contains("1","2","3");
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
    @DisplayName("커스텀 구분자")
    void customSeparatorTest(){
        String customSeparatorContainString = "//a\n1a2a3";
        String[] strings = StringUtil.complicatedSeparator(customSeparatorContainString);
        assertThat(strings).contains("1","2","3");
    }


    @Test
    @DisplayName("커스텀 구분자와 쉼표, 콜론 혼합")
    void complicatedStringTest(){
        String complicatedString = "//a\n1a2,3;4";
        String[] strings = StringUtil.complicatedSeparator(complicatedString);
        assertThat(strings).contains("1","2","3","4");
    }

}
