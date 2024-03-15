package lotto;

import lotto.domain.Expression;
import lotto.domain.ExpressionSplitter;
import lotto.exception.IllegalExpressionElementSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ExpressionSplitterTest {

    @Test
    @DisplayName("[성공] 문자열 수식을 분리한다.")
    void 수식_분리() throws IllegalExpressionElementSizeException {
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

    @Test
    @DisplayName("[성공] 숫자와 연산자 개수의 조합이 맞지 않는 경우 IllegalExpressionElementSizeException 예외가 발생한다.")
    void 수식_분리_실패_항개수_불일치() {
        // Given
        String stringExpression = "2 + 3 * 4 / 2 /";

        // When
        ExpressionSplitter splitter = new ExpressionSplitter();

        // Then
        int actual = 8;
        assertThatExceptionOfType(IllegalExpressionElementSizeException.class)
                .isThrownBy(() -> {
                    splitter.split(stringExpression);
                }).withMessage(MessageFormat.format("수식 항의 개수가 홀수가 아닙니다. (입력된 항 개수: {0})", actual));
    }
}
