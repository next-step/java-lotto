package com.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomSeparatorTest {

    @DisplayName("커스텀 구분자로 문자열 분리하는 테스트")
    @ParameterizedTest
    @MethodSource("provideString")
    void getSeparatedInputsTest(final String inputText, final List<String> expectedElements) {
        SeparatorStrategy separatorStrategy = new CustomSeparator(inputText);

        List<String> separatedElements = separatorStrategy.getSeparatedInputs();
        assertEquals(separatedElements.size(), expectedElements.size());
        assertTrue(separatedElements.containsAll(expectedElements));
    }

    private static Stream<Arguments> provideString() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", Arrays.asList("1", "2", "3")),
                Arguments.of("//&\n4&5", Arrays.asList("4", "5")),
                Arguments.of("//#\n2#7", Arrays.asList("2", "7"))
        );
    }
}
