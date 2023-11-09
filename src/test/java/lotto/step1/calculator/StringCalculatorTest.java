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
}
