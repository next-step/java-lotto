package calculator;

import calculator.domain.Expression;
import calculator.domain.ExpressionElement;
import calculator.domain.ExpressionElementBuilder;
import calculator.domain.Number;
import calculator.domain.Operator;
import calculator.util.ExpressionSplitter;
import calculator.exception.IllegalExpressionElementSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.text.MessageFormat;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.*;

public class ExpressionSplitterTest {

    @Test
    @DisplayName("[성공] 문자열 수식을 분리한다.")
    void 수식_분리() throws IllegalExpressionElementSizeException {
        // Given
        String expressionString = "2 + 3 * 4 / 2";

        // When
        List<String> expressionStrings = ExpressionSplitter.split(expressionString);
        List<ExpressionElement> elements = ExpressionElementBuilder.build(expressionStrings);
        Expression expression = new Expression(elements);

        // Then
        Queue<Number> numbers = expression.getNumbers();
        Queue<Operator> operations = expression.getOperators();

        assertThat(numbers).containsExactly(new Number(2), new Number(3), new Number(4), new Number(2));
        assertThat(operations).containsExactly(new Operator("+"), new Operator("*"), new Operator("/"));
    }

    @DisplayName("[실패] 입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest(name = "{index} ==> input {0} throw IllegalArgumentException")
    @NullAndEmptySource
    void null_공백문자(String inputString) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExpressionSplitter.split(inputString);
        });
    }

    @Test
    @DisplayName("[실패] 입력 값이 화이트스페이스인 경우 IllegalArgumentException 이 발생한다.")
    void 화이트스페이스_문자() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExpressionSplitter.split("   ");
        });
    }

    @Test
    @DisplayName("[실패] 분리된 문자열 개수가 짝수개인 경우 IllegalExpressionElementSizeException 이 발생한다.")
    void 항_개수() {
        assertThatThrownBy(() -> {
            ExpressionSplitter.split("1 + 2 * 3 /");
        }).isInstanceOf(IllegalExpressionElementSizeException.class)
                .hasMessage(MessageFormat.format("수식 항의 개수가 홀수가 아닙니다. (입력된 항 개수: {0})", 6));
    }

}
