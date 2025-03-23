package step2.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractionTest {

    @ParameterizedTest
    @CsvSource({
        "5, 3, 2",
        "10, 5, 5",
        "-3, 4, -7",
        "0, 0, 0",
        "10, 0, 10",
        "0, 10, -10"
    })
    @DisplayName("뺄셈 테스트")
    void testSubtraction(int number1, int number2, int expected) {
        Subtraction subtraction = new Subtraction();
        int result = subtraction.calculate(number1, number2);

        assertThat(result).isEqualTo(expected);
    }
}
