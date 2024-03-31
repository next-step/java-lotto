package calculator.total;

import calculator.StringCalculator;
import calculator.calc.Calculator;
import calculator.parse.ExpressionParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TotalTest {


    @Test
    @DisplayName("식을 입력하고 덧셈 결과를 반환한다.")
    public void addTest(){
        StringCalculator stringCalculator = new StringCalculator("1 + 2");
        int result = stringCalculator.calc();

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("식을 입력하고 덧셈, 곱셈 결과를 반환한다.")
    public void addAndMulTest(){
        StringCalculator stringCalculator = new StringCalculator("1 + 2 * 3");
        int result = stringCalculator.calc();

        assertThat(result).isEqualTo(9);
    }
    @Test
    @DisplayName("식을 입력하고 덧셈, 곱셈, 뺄셈 결과를 반환한다.")
    public void addAndMulAndMinTest(){
        StringCalculator stringCalculator = new StringCalculator("1 + 2 * 3 - 3");
        int result = stringCalculator.calc();

        assertThat(result).isEqualTo(6);
    }
    @Test
    @DisplayName("식을 입력하고 덧셈, 곱셈, 나눗셈 결과를 반환한다.")
    public void addAndMulAndDivTest(){
        StringCalculator stringCalculator = new StringCalculator("1 + 2 * 3 / 3");
        int result = stringCalculator.calc();

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("식에 올바르지 않은 기호가 들어오면 IllegalArgumentException이 발생한다.")
    public void illegalOperatorTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator stringCalculator = new StringCalculator("1 + 2 * 3 & 3");
            int result = stringCalculator.calc();
        });
    }

    @Test
    @DisplayName("식이 null이면 IllegalArgumentException이 발생한다.")
    public void nullExpresstionTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator stringCalculator = new StringCalculator(null);
            int result = stringCalculator.calc();
        });
    }
    @Test
    @DisplayName("식이 빈문자열이면 IllegalArgumentException이 발생한다.")
    public void emptyStringTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator stringCalculator = new StringCalculator("");
            int result = stringCalculator.calc();
        });
    }
}
