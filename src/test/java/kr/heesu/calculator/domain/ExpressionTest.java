package kr.heesu.calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {

    private Expression expression;

    @BeforeEach
    void setUp() {
        List<Number> numbers = Arrays.asList(1, 2)
                .stream()
                .map(Number::new)
                .collect(Collectors.toList());

        Arguments args = Arguments.of(numbers);

        this.expression = Expression.of(args);
    }

    @Test
    void expressionTest() {
        assertThat(this.expression.hasNextArgument()).isTrue();
        assertThat(this.expression.nextArgument()).isEqualTo(1);
        assertThat(this.expression.nextArgument()).isEqualTo(2);
        assertThat(this.expression.hasNextArgument()).isFalse();
    }
}
