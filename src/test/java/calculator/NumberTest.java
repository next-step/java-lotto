package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class NumberTest {

    @Test
    @DisplayName("생성자 테스트")
    void create() {
        Number number1 = new Number(1);
        Number number2 = new Number(1);
        Number number3 = new Number(5);

        assertEquals(number1, number2);
        assertNotEquals(number1, number3);
    }

    @Test
    @DisplayName("add 테스트")
    void add() {
        Number source = new Number(3);
        Number operand = new Number(1);
        Number expectedResult = new Number(4);

        Number result = source.add(operand);

        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @DisplayName("isNegative 테스트: 양수인경우 false, 음수인경우 true를 리턴한다.")
    @CsvSource(value = {"1:false", "-5:true", "0:false"}, delimiter = ':')
    void isNegative(Number number, boolean expectedResult) {
        boolean result = number.isNegative();

        assertEquals(expectedResult, result);
    }

}
