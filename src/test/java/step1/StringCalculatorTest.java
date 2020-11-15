package step1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;


public class StringCalculatorTest {

    @DisplayName("쉼표 덧셈 테스트 ")
    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "1,2,3=6", "3,6,7,8=24"}, delimiter = '=')
    public void restExpressionTest(String stringInput, int expected) {

        //Given & When
        int sum = StringPlusCalculator.stringSplitToSum(stringInput);

        //Then
        assertThat(sum).isEqualTo(expected);
    }


    @DisplayName("콜론 덧셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2=3", "1:2:3=6", "3:6:7:8=24"}, delimiter = '=')
    public void colonExpressionTest(String stringInput, int expected) {

        //Given & When
        int sum = StringPlusCalculator.stringSplitToSum(stringInput);

        //Then
        assertThat(sum).isEqualTo(expected);

    }

    @DisplayName("쉼표와 콜론 혼합되어 있을 때 덧셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2,3=6", "1,2:3=6", "3:6,7:8=24"}, delimiter = '=')
    public void mixColonAndRestExpressionTest(String stringInput, int expected) {
        //Given & When
        int sum = StringPlusCalculator.stringSplitToSum(stringInput);

        //Then
        assertThat(sum).isEqualTo(expected);
    }


    @DisplayName("커스텀 구분자 덧셈 테스트")
    @Test
    public void customExpressionTest() {
        //Given & When
        int expected = 6;
        int sum = StringPlusCalculator.stringSplitToSum("//;\n1;2;3");

        assertThat(sum).isEqualTo(expected);
    }

    @DisplayName("숫자 하나만 전달할 경우 덧셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1=1", "2=2", "10=10", "1000=1000"}, delimiter = '=')
    public void noMoreThanOneNumber(String stringInput, int expected){
        //Given & When
        int sum = StringPlusCalculator.stringSplitToSum(stringInput);

        //That
        assertThat(sum).isEqualTo(expected);
    }

    @DisplayName("빈문자열 혹은 null값 테스트")
    @Test
    public void emptyAndNull(){
        //Given & When
        int empty = StringPlusCalculator.stringSplitToSum("");
        int nullString = StringPlusCalculator.stringSplitToSum(null);

        //Then
        assertThat(empty).isEqualTo(0);
        assertThat(nullString).isEqualTo(0);
    }


    @DisplayName("음수값 전달할 경우 예외처리")
    @ParameterizedTest
    @CsvSource(value = {"1:-2,3=6", "1,2:-3=6", "3:-6,7:8=24"}, delimiter = '=')
    public void notValidNumberException(String stringInput) {
        assertThatExceptionOfType(NotValidNumberException.class)
                .isThrownBy(() -> {
                    StringPlusCalculator.stringSplitToSum(stringInput);
                }).withMessage("올바른 숫자형식이 아닙니다.");
    }
}
