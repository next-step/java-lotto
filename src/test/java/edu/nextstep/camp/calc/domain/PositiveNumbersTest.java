package edu.nextstep.camp.calc.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.*;

public class PositiveNumbersTest {
    @Test
    public void create() {
        Collection<PositiveNumber> numbers = List.of(PositiveNumber.of(1), PositiveNumber.of(2));
        assertThat(PositiveNumbers.of(numbers).collect()).containsExactly(PositiveNumber.of(1), PositiveNumber.of(2));
    }

    @ParameterizedTest
    @NullSource
    public void createFailed(Collection<PositiveNumber> input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PositiveNumbers.of(input))
                .withMessageContaining("invalid input");
    }

    static Stream<Arguments> addAndExpectedArguments() {
        return Stream.of(
                Arguments.of(List.of(PositiveNumber.of(1)), PositiveNumber.of(1)),
                Arguments.of(List.of(PositiveNumber.of(1), PositiveNumber.of(2)), PositiveNumber.of(3)),
                Arguments.of(List.of(PositiveNumber.of(1), PositiveNumber.of(2), PositiveNumber.of(3)), PositiveNumber.of(6)),
                Arguments.of(Collections.emptyList(), PositiveNumber.ZERO)
        );
    }

    @ParameterizedTest(name = "add: sum of {0} = {1}")
    @MethodSource("addAndExpectedArguments")
    public void sum(Collection<PositiveNumber> numbers, PositiveNumber expected) {
        assertThat(PositiveNumbers.of(numbers).sum()).isEqualTo(expected);
    }
}
