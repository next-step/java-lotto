package stringCalculator;

import org.assertj.core.api.Assertions;
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
    void seperatorTest(){
        String inputString = "1,2;3;";
        String[] stringArray = StringUtil.seperator(inputString);
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
        assertThatThrownBy(()-> stringCalculator.checkNegativeNumber(negativeNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }


}
