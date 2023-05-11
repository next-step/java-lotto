package calculator.parser;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ExpressionTest {

    @Nested
    class 연산자와_피연산자_개수가_같을_때 {
        private final Deque<Integer> twoOperands = makeDequeOf(Arrays.asList(1, 2));
        private final Deque<String> twoOperators = makeDequeOf(Arrays.asList("+", "-"));
        private Expression expression;

        @BeforeEach
        void setUp() {
            expression = new Expression(twoOperands, twoOperators);
        }

        @Test
        void _nextOperator_호출_시_성공한다() {
            String expectedOperator = "+";

            Assertions.assertThat(expression.nextOperator()).isEqualTo(expectedOperator);
        }

        @Test
        void 연산자와_피연산자_개수가_같을_때_nextOperand_호출_시_예외가_발생한다() {
            Assertions.assertThatExceptionOfType(UnsupportedOperationException.class)
                    .isThrownBy(() -> expression.nextOperand());
        }

        private <T> Deque<T> makeDequeOf(List<T> elements) {
            return new LinkedList<>(elements);
        }
    }

}
