package step1;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import step1.domain.InputParser;
import step1.domain.Number;
import step1.domain.Operator;
import step1.domain.ParserResult;

class InputParserTest {

    @Test
    @DisplayName("파싱된 값 결과 확인")
    void parseExpression() {
        ParserResult result = InputParser.parseExpression("6 + 1 + 2 - 0 * 3 / 6");

        assertThat(result.getNumbers()).isEqualTo(List.of(new Number(6), new Number(1), new Number(2), new Number(0), new Number(3), new Number(6)));
        assertThat(result.getOperators()).isEqualTo(List.of(Operator.ADD, Operator.ADD, Operator.SUBTRACT, Operator.MULTIPLY, Operator.DIVIDE));
    }

    @ParameterizedTest(name = "조건에 맞지 않는 식이 들어올 때: {0}")
    @ValueSource(strings = {"sfsdfsdfasdf", "- 1 + 2", "2 -"})
    void parseInvalidExpression(String expression) {
        assertThatThrownBy(() -> InputParser.parseExpression(expression)).isInstanceOf(RuntimeException.class);
    }
}
