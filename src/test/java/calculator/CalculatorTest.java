package calculator;

import calculator.domain.Calculator;
import calculator.domain.InputNumber;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
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

}
