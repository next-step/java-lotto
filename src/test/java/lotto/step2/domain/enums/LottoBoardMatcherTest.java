package lotto.step2.domain.enums;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottoBoardMatcherTest {

    @DisplayName("매치카운트에 맞춰서 상금 잘 가져오는지 체크")
    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void getWinningBonusTest(long input, int expected) {
        assertThat(LottoBoardMatcher.getWinningBonus(input)).isEqualTo(expected);
    }

    @DisplayName("로또 수익률 테스트")
    @ParameterizedTest
    @MethodSource("proviceListForWinningRatio")
    void winningRatioTest(long[] input, double expected) {

        Map<Long, Long> map = new TreeMap<>();
        for (int i = 0; i < input.length; i+=2) {
            map.put(input[i], input[i + 1]);
        }

        assertThat(LottoBoardMatcher.winningRatio(map)).isEqualTo(expected);
    }

    private static Stream<Arguments> proviceListForWinningRatio() {
        return Stream.of(
            Arguments.of(new long[] {3L, 6L, 4L, 5L, 5L, 1L, 6L, 0L}, 148.33333333333334),
            Arguments.of(new long[] {0L, 100L, 1L, 10L, 2L, 10L, 3L, 0L, 4L, 1L, 5L, 0L, 6L, 0L}, 0.4132231404958678),
            Arguments.of(new long[] {0L, 300L, 1L, 10L, 2L, 10L, 3L, 0L, 4L, 0L}, 0.0),
            Arguments.of(new long[] {0L, 0L, 1L, 3L, 2L, 5L, 3L, 2L}, 1.0)
        );
    }
}
