package calculator.domain;

import calculator.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionTest {

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2", "1   + 3", "2   +   5  "})
    @DisplayName("문자열 공백 기준 분리 - 공백 개수는 무시")
    void stringSplitTest(String input) {
        String[] splitString = input.split(InputView.DELIMITER);

        Expression expression = Expression.createExpression(splitString);

        assertThat(expression.getSize()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "1 +", "2 3", "1 + 2 + "})
    @DisplayName("분리된 공백 개수가 짝수인 경우 에러 리턴")
    void splitResultSizeErrorTest(String input) {
        String[] splitString = input.split(InputView.DELIMITER);

        assertThatThrownBy(() -> Expression.createExpression(splitString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("계산식을 정확히 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1+2"})
    @DisplayName("문자열이 1개일 경우 에러 리턴")
    void splitResultOnlyOneSizeError(String input) {
        String[] splitString = input.split(InputView.DELIMITER);

        assertThatThrownBy(() -> Expression.createExpression(splitString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("계산식을 정확히 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"+ 2 +", "a + b"})
    @DisplayName("홀수 원자가 숫자가 아닌 경우 에러 리턴")
    void oddElementError(String input) {
        String[] splitString = input.split(InputView.DELIMITER);

        assertThatThrownBy(() -> Expression.createExpression(splitString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해야 하는 위치입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ^ 2", "1 $ 3"})
    @DisplayName("올바른 계산식이 아닌 경우 에러 리턴")
    void operatorError(String input) {
        String[] splitString = input.split(InputView.DELIMITER);

        assertThatThrownBy(() -> Expression.createExpression(splitString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 계산식을 입력해주세요.");
    }

    @Test
    @DisplayName("숫자 리스트만 분리")
    void operandsTest() {
        String[] splitString = "1 + 2 + 3".split(InputView.DELIMITER);

        Expression expression = Expression.createExpression(splitString);

        assertThat(expression.getOperands()).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    @DisplayName("계산식 리스트만 분리")
    void operatorsTest() {
        String[] splitString = "1 + 2 * 3 / 4".split(InputView.DELIMITER);

        Expression expression = Expression.createExpression(splitString);

        assertThat(expression.getOperators())
                .isEqualTo(new LinkedList<>(List.of(Operator.PLUS, Operator.MULTIPLE, Operator.DIVIDE)));
    }

}