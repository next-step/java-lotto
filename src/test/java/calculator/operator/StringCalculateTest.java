package calculator.operator;

import calculator.cal.StringCalculate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculateTest {

    @ParameterizedTest
    @CsvSource({
            "2, '+', 3, 5",
            "5, '-', 3, 2",
            "2, '*', 3, 6",
            "6, '/', 3, 2"
    })
    void 더하기__빼기_곱하기_나누기_테스트(int num1, String operator, int num2, int expectedResult) {
        assertThat(StringCalculate.calculate(num1, operator, num2)).isEqualTo(expectedResult);
    }

}
