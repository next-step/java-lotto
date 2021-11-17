package edu.nextstep.camp.calc.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.*;

public class AdderTest {
    static Stream<Arguments> addAndExpectedArguments() {
        return Stream.of(
                Arguments.of(List.of(PositiveNumber.of(1)), PositiveNumber.of(1)),
                Arguments.of(List.of(PositiveNumber.of(1), PositiveNumber.of(2)), PositiveNumber.of(3)),
                Arguments.of(List.of(PositiveNumber.of(1), PositiveNumber.of(2), PositiveNumber.of(3)), PositiveNumber.of(6)),
                Arguments.of(Collections.emptyList(), PositiveNumber.ofZero())
        );
    }

    @ParameterizedTest(name = "add: sum of {0} = {1}")
    @MethodSource("addAndExpectedArguments")
    public void add(Collection<PositiveNumber> numbers, PositiveNumber expected) {
        assertThat(Adder.add(numbers)).isEqualTo(expected);
    }


    @ParameterizedTest(name = "add but failed")
    @NullSource
    public void addFailed(List<PositiveNumber> numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Adder.add(numbers))
                .withMessageContaining("invalid input");
    }
}
