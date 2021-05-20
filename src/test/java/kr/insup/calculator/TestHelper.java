package kr.insup.calculator;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestHelper {

    public static Stream<Arguments> provideDelimiterExample() {
        return Stream.of(
                Arguments.of("3", "[:,]"),
                Arguments.of("3:4", "[:,]"),
                Arguments.of("3:2:4", "[:,]"),
                Arguments.of("3,2,4", "[:,]"),
                Arguments.of("3,2:4", "[:,]"),
                Arguments.of("//$\n1$2$4", "\\$"),
                Arguments.of("//@\n0@4@2", "@"),
                Arguments.of("//(\n1(2(3", "\\(")
        );
    }

    public static Stream<Arguments> provideNumbersExample() {
        return Stream.of(
                Arguments.of("3", "3"),
                Arguments.of("3:4", "3:4"),
                Arguments.of("3:2:4", "3:2:4"),
                Arguments.of("3,2:4", "3,2:4"),
                Arguments.of("//$\n1$2$4", "1$2$4"),
                Arguments.of("//@\n0@4@2", "0@4@2"),
                Arguments.of("//(\n1(2(3", "1(2(3")
        );
    }

    public static Stream<Arguments> provideCalculateExample() {
        return Stream.of(
                Arguments.of("//(\n1(2(3", 6),
                Arguments.of("//$\n1$2$4", 7),
                Arguments.of("//@\n3@4@2", 9)
        );
    }
}
