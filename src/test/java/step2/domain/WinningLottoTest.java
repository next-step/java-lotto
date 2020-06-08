package step2.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    private static Stream<Arguments> validateWinningNumbersTestCase() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7), false),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5), false),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), true)
        );
    }

    @ParameterizedTest
    @MethodSource("validateWinningNumbersTestCase")
    public void validateWinningNumbersTest(List<Integer> input, Boolean expected) {
        //when&then
        if (false == Boolean.valueOf(expected)) {
            assertThatThrownBy(
                () -> new Lotto(input).validateWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
        }
    }
}