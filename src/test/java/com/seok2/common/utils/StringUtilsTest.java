package com.seok2.common.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringUtilsTest {


    static Stream<Arguments> strings() {
        return Stream.of(
            Arguments.of("", true),
            Arguments.of(" ", true),
            Arguments.of(null, true),
            Arguments.of("1", false)
        );
    }
    static Stream<String> split() {
        return Stream.of(
            "1,2,3",
            "1:2:3",
            "//;\n1;2;3"
        );
    }

    @ParameterizedTest
    @MethodSource("strings")
    void isBlank(String string, boolean expected) {
        assertThat(StringUtils.isBlank(string)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("split")
    void split(String string) {
        assertThat(StringUtils.split(string)).containsOnly("1","2","3");
    }
}