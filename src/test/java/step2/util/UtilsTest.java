package step2.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UtilsTest {

    @Test
    public void convertStringToIntegerListTest() {
        //given
        List<String> integerStringList = Arrays.asList("1", "2", "3");

        //when
        List<Integer> integerList = Utils.convertStringToIntegerList(integerStringList);

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
        List<String> parsedWinningNumbers = Utils.convertCsvStringToList(input);

        //then
        assertThat(parsedWinningNumbers).isEqualTo(expected);
    }
}