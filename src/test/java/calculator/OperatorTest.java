package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

    @DisplayName("Operator는 + - * / 연산을 지원한다")
    @ParameterizedTest
    @CsvSource(value = {"+:PLUS", "-:MINUS", "*:MULTIPLY", "/:DIVIDE"}, delimiter = ':')
    void test1(String symbol, String value){
        Operator.find(symbol)
                .equals(Operator.valueOf(value));
    }

    @DisplayName("Operator는 + - * / 연산만 지원한다")
    @ParameterizedTest
    @ValueSource(strings = {"&", "%", "^"})
    void test2(String symbol){
        Assertions.assertThatThrownBy(() -> Operator.find(symbol)).isInstanceOf(IllegalArgumentException.class);
    }

}