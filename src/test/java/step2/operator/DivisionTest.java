package step2.operator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DivisionTest {
    @ParameterizedTest
    @CsvSource({
        "10, 2, 5",
        "10, 5, 2",
        "-10, 2, -5",
        "-10, -2, 5",
        "0, 10, 0"
    })
    @DisplayName("나눗셈 테스트")
    void testDivision(int number1, int number2, int expected) {
        Division division = new Division();
        int result = division.calculate(number1, number2);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("0으로 나누는 경우 예외 발생")
    void testDivisionByZero() {
        Division division = new Division();

        Assertions.assertThatThrownBy(() -> division.calculate(10, 0))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
