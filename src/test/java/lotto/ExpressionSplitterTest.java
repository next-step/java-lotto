package lotto;

import org.assertj.core.internal.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.*;

public class ExpressionSplitterTest {

    @Test
    @DisplayName("[성공] 문자열 수식을 분리한다.")
    void 수식_분리() {
        // Given
        String stringExpression = "2 + 3 * 4 / 2";

        // When
        ExpressionSplitter splitter = new ExpressionSplitter();
        Expression expression = splitter.split(stringExpression);

        // Then
        Queue<Integer> numbers = expression.getNumbers();
        Queue<String> operations = expression.getOperators();

        assertThat(numbers).containsExactly(2, 3, 4, 2);
        assertThat(operations).containsExactly("+", "*", "/");
    }
}
