package com.seok2.adder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringAdderTest {


    static Stream<String> invalid() {
        return Stream.of("-1", "a,b,c", "1,2,a");
    }

    static Stream<Arguments> valid() {
        return Stream.of(
            Arguments.of("1", 1),
            Arguments.of("1,2,3", 6),
            Arguments.of("3:5:7", 15),
            Arguments.of("//;\n4;5;6", 15)
        );
    }

    @ParameterizedTest
    @MethodSource("invalid")
    void sum(String expression) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringAdder.sum(expression));
    }

    @ParameterizedTest
    @MethodSource("valid")
    void sum(String expression, int expected) {
        assertThat(StringAdder.sum(expression)).isEqualTo(expected);
    }
}