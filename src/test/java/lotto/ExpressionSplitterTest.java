package lotto;

import lotto.domain.Expression;
import lotto.util.ExpressionSplitter;
import lotto.exception.IllegalExpressionElementSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionSplitterTest {

    @Test
    @DisplayName("[성공] 문자열 수식을 분리한다.")
    void 수식_분리() throws IllegalExpressionElementSizeException {
        // Given
        String expressionString = "2 + 3 * 4 / 2";

        // When
        List<String> expressionStrings = ExpressionSplitter.split(expressionString);
        Expression expression = new Expression(expressionStrings);

        // Then
        Queue<Integer> numbers = expression.getNumbers();
        Queue<String> operations = expression.getOperators();

        assertThat(numbers).containsExactly(2, 3, 4, 2);
        assertThat(operations).containsExactly("+", "*", "/");
    }

}
