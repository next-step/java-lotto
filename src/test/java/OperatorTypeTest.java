import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTypeTest {

    @ParameterizedTest
    @CsvSource(value = {"+=10", "-=6", "*=16", "/=4"}, delimiter = '=')
    @DisplayName("주어진 연산이 제대로 동작하는지에 대한 테스트")
    void calculate(String operator, int excepted) {

        int firstNumber = 8;
        int lastNumber = 2;

        int result = OperatorType.calculate(operator, firstNumber, lastNumber);

        assertEquals(result, excepted);
    }
}
