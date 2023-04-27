package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @ParameterizedTest(name = "[{index}] 연산기호 : {0} -> {1}")
    @CsvSource(value = {"+:PLUS","-:MINUS","*:MULTIPLY","/:DIVIDE"}, delimiter = ':')
    void 사칙연산찾기(String symbol, String operationName) {
        Operation expected = Operation.valueOf(operationName);
        assertThat(Operation.find(symbol)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "[{index}] 6 {0} 4 = {1}")
    @CsvSource(value = {"+:10","-:2","*:24","/:1.5"}, delimiter = ':')
    void 계산하기(String symbol, Double expectedResult) {
        Operation operation = Operation.find(symbol);
        assertThat(operation.calculate(6, 4)).isEqualTo(expectedResult);
    }
}