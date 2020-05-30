package step2.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.catchThrowable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.util.ReflectionTestUtils;

class LottoGameTest {

    @Test
    public void convertStringToIntegerListTest() {
        //given
        List<String> integerStringList = Arrays.asList("1", "2", "3");

        //when
        List<Integer> integerList = ReflectionTestUtils
            .invokeMethod(new LottoGame(1000),
                "convertStringToIntegerList",
                integerStringList);

        //then
        assertThat(integerList).hasSize(3);
        assertThat(integerList).containsExactly(1, 2, 3);
    }

    private static Stream<Arguments> parseWinningNumbersTestCase() {
        return Stream.of(
            Arguments.of("1,2,3,4,5,6", Arrays.asList("1", "2", "3", "4", "5", "6")),
            Arguments.of("1, 2, 3, 4, 5, 6", Arrays.asList("1", "2", "3", "4", "5", "6")),
            Arguments.of("1,2, 3, 4,5, 6", Arrays.asList("1", "2", "3", "4", "5", "6"))
        );
    }

    @ParameterizedTest
    @MethodSource("parseWinningNumbersTestCase")
    public void parseWinningNumbersTest(String input, List<String> expected) {
        //when
        List<String> parsedWinningNumbers = ReflectionTestUtils
            .invokeMethod(new LottoGame(1000),
                "parseWinningNumbers",
                input);
        //then
        assertThat(parsedWinningNumbers).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0, false", "2000, true", "100000, true", "200000, false"})
    public void validateUserPriceTest(String input, String expected) {
        //when
        Throwable thrown = catchThrowable(() ->
            ReflectionTestUtils
                .invokeMethod(new LottoGame(1000),
                    "validateUserPrice",
                    Integer.valueOf(input)));

        //then
        if (false == Boolean.valueOf(expected)) {
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"a,b,c,d,e,f/false", "a,1,2,3,4,5/false", "1,2,3,4,5,/false", "1,2,3,4,5,6/true"}, delimiter = '/')
    public void validateWinningNumbersTest(String input, String expected) {
        //when
        Throwable thrown = catchThrowable(() ->
            ReflectionTestUtils
                .invokeMethod(new LottoGame(1000),
                    "validateWinningNumbers",
                    Integer.valueOf(input)));

        //then
        if (false == Boolean.valueOf(expected)) {
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        }
    }
}