package step2.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class AdditionTest {

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",
        "5, 6, 11",
        "-3, 4, 1",
        "0, 0, 0"
    })
    @DisplayName("덧셈 테스트")
    void testAddition(int number1, int number2, int expected) {
        Addition addition = new Addition();
        int result = addition.calculate(number1, number2);

        assertThat(result).isEqualTo(expected);
    }
}
