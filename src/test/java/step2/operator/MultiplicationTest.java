package step2.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplicationTest {
    @ParameterizedTest
    @CsvSource({
        "5, 3, 15",
        "10, 5, 50",
        "-3, 4, -12",
        "-3, -4, 12",
        "0, 10, 0",
        "10, 0, 0",
        "0, 0, 0"
    })
    @DisplayName("곱셈 테스트")
    void testMultiplication(int number1, int number2, int expected) {
        Multiplication multiplication = new Multiplication();
        int result = multiplication.calculate(number1, number2);

        assertThat(result).isEqualTo(expected);
    }

}
