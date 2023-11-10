package lotto.step1.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    @ParameterizedTest
    @CsvSource(value = {"1 + 2,3", "2 + 4,6", "15 + 30,45", "100 + 99,199", "1000 + 4,1004"}, delimiter = ',')
    @DisplayName("입력 중 사칙연산 기호가 '+'인 경우, 두 숫자의 덧셈을 구한다.")
    void calculateSum(String input, String expectedResult) {
        //given
        UserInput userInput = new UserInput(input);

        //when
        String result = StringCalculator.calculate(userInput.getInputs());

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"10 - 2,8", "2 - 4,-2", "15 - 30,-15", "100 - 99,1", "1000 - 4,996"}, delimiter = ',')
    @DisplayName("입력 중 사칙연산 기호가 '-'인 경우, 두 숫자의 뺄셈을 구한다.")
    void calculateSub(String input, String expectedResult) {
        //given
        UserInput userInput = new UserInput(input);

        //when
        String result = StringCalculator.calculate(userInput.getInputs());

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"10 * 2,20", "2 * 4,8", "15 * 30,450", "100 * 99,9900", "1000 * 4,4000"}, delimiter = ',')
    @DisplayName("입력 중 사칙연산 기호가 '*'인 경우, 두 숫자의 곱셈을 구한다.")
    void calculateMulti(String input, String expectedResult) {
        //given
        UserInput userInput = new UserInput(input);

        //when
        String result = StringCalculator.calculate(userInput.getInputs());

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"10 / 3,3", "2 / 4,0", "45 / 15,3", "100 / 99,1", "1000 / 4,250"}, delimiter = ',')
    @DisplayName("입력 중 사칙연산 기호가 '/'인 경우, 두 숫자의 나눗셈을 구한다.")
    void calculateDiv(String input, String expectedResult) {
        //given
        UserInput userInput = new UserInput(input);

        //when
        String result = StringCalculator.calculate(userInput.getInputs());

        //then
        assertThat(result).isEqualTo(expectedResult);
    }
}
