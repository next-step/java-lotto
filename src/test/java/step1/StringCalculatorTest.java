package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void beforeEach() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("(+) 계산한다")
    @Test
    public void plus() {
        //given
        String input = "1 + 2";
        int answer = 3;
        //when
        int result = stringCalculator.calculate(input);
        //then
        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("(-) 계산한다")
    @Test
    public void minus() {
        //given
        String input = "25 - 3";
        int answer = 22;
        //when
        int result = stringCalculator.calculate(input);
        //then
        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("(*) 계산한다")
    @Test
    public void multiply() {
        //given
        String input = "7 * 14";
        int answer = 98;
        //when
        int result = stringCalculator.calculate(input);
        //then
        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("(/) 계산한다")
    @Test
    public void divide() {
        //given
        String input = "100 / 25";
        int answer = 4;
        //when
        int result = stringCalculator.calculate(input);
        //then
        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("입력 값이 공백 문자일 경우 IllegalArgumentException throw 한다")
    @Test
    public void blankInput() {
        //given
        String input = "";
        //when
        //then
        assertThatThrownBy(() -> {
            stringCalculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("입력 값이 null 일 경우 IllegalArgumentException throw 한다")
    @Test
    public void nullInput() {
        //given
        String input = null;
        //when
        //then
        assertThatThrownBy(() -> {
            stringCalculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    @Test
    public void invalidOperator() {
        //given
        String input = "100 / 25 + 4 x 3";
        int answer = 4;
        //when
        int result = stringCalculator.calculate(input);
        //then
        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("문자열을 \"2 + 3 * 4 / 2\" 입력시 10을 반환한다")
    @Test
    public void calculate() {
        //given
        String input = "2 + 3 * 4 / 2";
        int answer = 10;
        //when
        int result = stringCalculator.calculate(input);
        //then
        assertThat(result).isEqualTo(answer);
    }
}