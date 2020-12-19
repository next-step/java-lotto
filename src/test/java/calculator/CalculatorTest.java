package calculator;

import calculator.domain.Calculator;
import calculator.domain.InputNumber;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorTest {

    static Stream<String> blankStrings() {
        return Stream.of("", "   ", null);
    }

    @ParameterizedTest
    @MethodSource("blankStrings")
    void empty_and_null_return_zero(String input) throws Exception {
        //Given
        InputNumber inputNumber = new InputNumber(input);
        Calculator calculator = new Calculator(inputNumber);

        //When
        int results = calculator.calculate();

        //Then
        Assertions.assertThat(0).isEqualTo(results);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,3", "4,4"})
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환하는 기능")
    void one_char_input_return_number(String input, int actual) throws Exception {
        //Given
        InputNumber inputNumber = new InputNumber(input);
        Calculator calculator = new Calculator(inputNumber);

        //When
        int results = calculator.calculate();

        //Then
        Assertions.assertThat(actual).isEqualTo(results);
    }

}
