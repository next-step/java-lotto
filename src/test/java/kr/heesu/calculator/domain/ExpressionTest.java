package kr.heesu.calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {

    private Expression expression;

    @BeforeEach
    void setUp() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2));
        Arguments args = Arguments.of(nums);

        this.expression = Expression.of(args);
    }

    @Test
    void expressionTest() {
        int a = this.expression.nextArgument();

        assertThat(this.expression.hasNextArgument()).isTrue();
        assertThat(a).isEqualTo(1);

        assertThat(this.expression.nextOperation(a)).isEqualTo(3);

        assertThat(this.expression.hasNextArgument()).isFalse();
    }
}
