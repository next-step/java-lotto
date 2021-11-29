package com.kkambi.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ElementTest {

    @DisplayName("동등성 비교")
    @MethodSource("getForEquals")
    @ParameterizedTest
    void equals(Element element1, Element element2, boolean expected) {
        // when
        // then
        assertThat(element1.equals(element2)).isEqualTo(expected);
    }

    static Stream<Arguments> getForEquals() {
        return Stream.of(
                Arguments.of(new Element("a"), new Element("a"), true),
                Arguments.of(new Element("3"), new Element("3"), true),
                Arguments.of(new Element("a"), new Element("%"), false),
                Arguments.of(new Element("1"), new Element("2"), false)
        );
    }
}
