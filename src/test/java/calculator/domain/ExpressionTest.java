package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ExpressionTest {

    @Nested
    @DisplayName("입력 테스트")
    class input {
        @Test
        @DisplayName("공백 테스트")
        void blank() {
            String input = "";

            assertThatThrownBy(() -> {
                new Expression(input);
            }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("입력값이 빈칸입니다.");
        }

        @Test
        @DisplayName("숫자가 없을 경우")
        void checkNum() {
            String input = "+ - *";

            assertThatThrownBy(() -> {
                new Expression(input);
            }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("입력 형식에 맞지 않습니다.");
        }

        @Test
        @DisplayName("기호가 없을 경우")
        void checkOperation() {
            String input = "3 4 12";

            assertThatThrownBy(() -> {
                new Expression(input);
            }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("입력 형식에 맞지 않습니다.");
        }
    }

    @Nested
    @DisplayName("split 테스트")
    class split {
        @Test
        @DisplayName("숫자 테스트")
        void splitNumbers() {
            String input = "2 + 3 * 4 / 2";
            List<Integer> expected = Arrays.asList(2, 3, 4, 2);

            Expression expression = new Expression(input);
            assertThat(expression.getNumbers()).containsExactlyElementsOf(expected);
        }

        @Test
        @DisplayName("기호 테스트")
        void splitOperations() {
            String input = "2 + 3 * 4 / 2";
            List<OperationStrategy> expected = Arrays.asList(new OperationStrategyAdd(),
                    new OperationStrategyMultiply(), new OperationStrategySubtract());

            Expression expression = new Expression(input);
            assertThat(expression.getOperations()).containsExactlyElementsOf(expected);
        }
    }
}
