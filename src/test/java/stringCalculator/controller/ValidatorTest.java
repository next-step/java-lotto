package stringCalculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ValidatorTest {

    @DisplayName("식이 비었는지 확인하는 테스트")
    @ParameterizedTest
    @MethodSource("provideIsEquationEmptyTest")
    public void isEquationEmptyTest(boolean actual, boolean expected) {
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideIsEquationEmptyTest() {
        return Stream.of(
                Arguments.of(Validator.isEquationEmpty(""), true),
                Arguments.of(Validator.isEquationEmpty("asdfasdf"), false)
        );
    }

    @DisplayName("숫자가 음수가 있는지 확인하는 테스트")
    @Test
    public void validatePositiveNumTest() {
        assertThrows(NumberFormatException.class, () -> Validator.validatePositiveNum(new String[]{"1", "-1"}));
    }
}
