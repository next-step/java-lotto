package com.seok2.common.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.seok2.adder.PositiveInteger;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
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

    @ParameterizedTest
    @MethodSource("strings")
    void isBlank(String string, boolean expected) {
        assertThat(StringUtils.isBlank(string)).isEqualTo(expected);
    }
}