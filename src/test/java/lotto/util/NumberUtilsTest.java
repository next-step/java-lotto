package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
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
    void isNumberInRangeTest(List<String> numbers, boolean expected) {
        assertEquals(expected, NumberUtils.isNumberInLottoRange(numbers));
    }

    private static Stream<Arguments> provideNumberInRangeTest() {
        return Stream.of(
            Arguments.of(Arrays.asList("1","45","3"), true),
            Arguments.of(Arrays.asList("1","99","48"), false)
        );
    }

    @DisplayName("같은 수가 없는지 테스트")
    @ParameterizedTest
    @MethodSource("provideisNumberUniqueTest")
    void isNumberUniqueTest(List<String> numbers, boolean expected) {
        assertEquals(expected, NumberUtils.isNumberUnique(numbers));
    }

    private static Stream<Arguments> provideisNumberUniqueTest() {
        return Stream.of(
            Arguments.of(Arrays.asList("1", "1", "2"), false),
            Arguments.of(Arrays.asList("1", "3", "2"), true),
            Arguments.of(Arrays.asList("1"), true)
        );
    }

    @DisplayName("수의 범위 테스트")
    @ParameterizedTest
    @MethodSource("providecheckLottoNumberTest")
    void checkLottoNumberTest(int num, boolean expected) {
        assertEquals(expected, NumberUtils.checkLottoNumber(num));
    }

    private static Stream<Arguments> providecheckLottoNumberTest() {
        return Stream.of(
            Arguments.of(45, true),
            Arguments.of(0, false),
            Arguments.of(99, false)
        );
    }
}