package kr.heesu.calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgumentsTest {

    @Test
    void argumentsTest() {
        List<Number> numbers = Arrays.asList(1, 2)
                .stream()
                .map(Number::new)
                .collect(Collectors.toList());

        Arguments args = Arguments.of(numbers);

        assertThat(args.hasNext()).isTrue();
        assertThat(args.nextArgument()).isEqualTo(1);
        assertThat(args.hasNext()).isTrue();
        assertThat(args.nextArgument()).isEqualTo(2);
        assertThat(args.hasNext()).isFalse();
    }
}
