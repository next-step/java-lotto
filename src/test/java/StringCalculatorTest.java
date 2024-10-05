import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCalculatorTest {
    @Test
    @DisplayName("덧셈 테스트")
    void addTest(){
        //given
        final int num1 = 1;
        final int num2 = 2;

        //when
        int result = StringCalculator.add(num1, num2);

        //then
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subtractionTest(){
        //given
        final int num1 = 1;
        final int num2 = 2;

        //when
        int result = StringCalculator.minus(num1, num2);

        //then
        Assertions.assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiplyTest(){
        //given
        final int num1 = 2;
        final int num2 = 2;

        //when
        int result = StringCalculator.multiply(num1, num2);

        //then
        Assertions.assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divisionTest(){
        //given
        final int num1 = 2;
        final int num2 = 2;

        //when
        int result = StringCalculator.divide(num1, num2);

        //then
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("계산기 테스트")
    void calculatorTest(){
        //given
        final int num1 = 2;
        final int num2 = 2;
        final String operator = "+";

        //when
        int result = StringCalculator.calculate(num1, num2, operator);

        //then
        Assertions.assertThat(result).isEqualTo(4);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10","2 + 3 + 4 + 2:11","2 + 3 + 4 / 2:4"}, delimiterString = ":")
    @DisplayName("문자열 계산 테스트")
    void stringCalculatorTest(String input, Integer expected){
        //given
        String[] split = InputView.splitByEmptyString(input);

        //when
        int result = StringCalculator.calculateWithSplit(split);

        //then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
