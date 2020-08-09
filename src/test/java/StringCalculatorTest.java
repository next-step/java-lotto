import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3;6", "2,3,4;9"}, delimiter = ';')
    @DisplayName("쉼표가 구분자일 때 덧셈 결과 값을 반환한다.")
    void plusTest1(String input, int expected) {
        int result = calculator.calculate(input, ",");

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3;6", "2:3:4;9"}, delimiter = ';')
    @DisplayName("콜론이 구분자일 때 덧셈 결과 값을 반환한다.")
    void plusTest2(String input, int expected) {
        int result = calculator.calculate(input, ":");

        assertThat(result).isEqualTo(expected);
    }

}