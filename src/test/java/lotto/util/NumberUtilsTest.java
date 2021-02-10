package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumberUtilsTest {

    @DisplayName("정수인지 아닌지 판단하는 테스트")
    @ParameterizedTest
    @MethodSource("provideReturnIntegerTest")
    void returnIntegerTest(String string, Integer expected) {
        assertEquals(expected, NumberUtils.returnInteger(string));
    }

    private static Stream<Arguments> provideReturnIntegerTest() {
        return Stream.of(
            Arguments.of("45", 45),
            Arguments.of("0", 0),
            Arguments.of("asd", null),
            Arguments.of("0.03", null)
        );
    }

    @DisplayName("수익률 계산 테스트")
    @ParameterizedTest
    @MethodSource("provideCalcualteYieldTest")
    void calculateYieldTest(int inputPrice, int income, double expected) {
        assertEquals(expected, NumberUtils.calculateYield(inputPrice, income));
    }

    private static Stream<Arguments> provideCalcualteYieldTest() {
        return Stream.of(
            Arguments.of(14000, 5000, 0.35),
            Arguments.of(10000, 5000, 0.5),
            Arguments.of(2000, 2000000000, 1000000.0),
            Arguments.of(2000, 0, 0.0)
        );
    }

    @DisplayName("수의 범위 테스트")
    @ParameterizedTest
    @MethodSource("provideNumberInRangeTest")
    void isNumberInRangeTest(Set<String> numbers, boolean expected) {
        assertEquals(expected, NumberUtils.isNumberInLottoRange(numbers));
    }

    private static Stream<Arguments> provideNumberInRangeTest() {
        return Stream.of(
            Arguments.of(new HashSet<>(Arrays.asList("1","45","3")), true),
            Arguments.of(new HashSet<>(Arrays.asList("1","99","48")), false)
        );
    }

    @DisplayName("수의 범위 테스트")
    @ParameterizedTest
    @MethodSource("provideCheckLottoNumberTest")
    void checkLottoNumberTest(int num, boolean expected) {
        assertEquals(expected, NumberUtils.checkLottoNumber(num));
    }

    private static Stream<Arguments> provideCheckLottoNumberTest() {
        return Stream.of(
            Arguments.of(45, true),
            Arguments.of(0, false),
            Arguments.of(99, false)
        );
    }
}