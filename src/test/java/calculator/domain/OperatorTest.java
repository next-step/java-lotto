package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class OperatorTest {

    @DisplayName("일치하는 연산자를 반환하는 기능 테스트")
    @CsvSource(value = {"+:PLUS", "-:MINUS", "*:MULTIPLY", "/:DIVIDE"}, delimiter = ':')
    @ParameterizedTest
    void isEqualOperatorTest(String symbol, Operator operator) {
        assertThat(Operator.findOperatorFromSymbol(symbol)).isEqualTo(operator);
    }

    @DisplayName("일치하는 연산자를 반환하는 기능 테스트 - 실패 케이스")
    @ValueSource(strings = {"!", "#", "1", "4", "e"})
    @ParameterizedTest
    void isEqualOperatorTestFail(String symbol) {
        assertThatThrownBy(() -> Operator.findOperatorFromSymbol(symbol))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("연산자로 계산하는 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10:2:+:12", "10:2:-:8", "10:2:*:20", "10:2:/:5", "10:3:/:3"}, delimiter = ':')
    void calculateTest(int number1, int number2, String symbol, int result) {
        Operator operator = Operator.findOperatorFromSymbol(symbol);
        assertThat(operator.calculate(number1, number2)).isEqualTo(result);
    }

    @DisplayName("연산자로 계산하는 기능 테스트 - 0으로 나눈 경우")
    @Test
    void calculateTestFail() {
        assertThatThrownBy(() -> Operator.DIVIDE.calculate(10, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
