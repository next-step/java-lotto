package com.seok2.adder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PositiveIntegerTest {


    static Stream<String> invalid() {
        return Stream.of("-1", "", " ", null);
    }

    static Stream<Arguments> valid() {
        Random random = new Random();
        int randomInt = random.nextInt(10);

        return Stream.of(
            Arguments.of("0", new PositiveInteger()),
            Arguments.of("1", new PositiveInteger(1)),
            Arguments.of(String.valueOf(randomInt), new PositiveInteger(randomInt))
        );
    }

    static Stream<Arguments> add() {
        return Stream.of(
            Arguments.of(new PositiveInteger(0), new PositiveInteger(1), new PositiveInteger(1)),
            Arguments.of(new PositiveInteger(2), new PositiveInteger(3), new PositiveInteger(5));
        );
    }

    @ParameterizedTest
    @MethodSource("invalid")
    void parse(String s) {
        assertThatIllegalArgumentException().isThrownBy(() -> PositiveInteger.parse(s));
    }

    @ParameterizedTest
    @MethodSource("valid")
    void parse(String s, PositiveInteger expected) {
        assertThat(PositiveInteger.parse(s)).isEqualTo(expected);
    }


    @ParameterizedTest
    @MethodSource("add")
    void add(PositiveInteger integer1, PositiveInteger integer2, PositiveInteger expected) {
        assertThat(integer1.add(integer2)).isEqualTo(expected);
    }
}