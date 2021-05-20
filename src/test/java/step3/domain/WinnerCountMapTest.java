package step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinnerCountMapTest {

    private static final int[] PRIZES = new int[] {0, 0, 0, 5000, 50000, 1500000, 2000000000};

    @DisplayName("맞은 숫자 개수에 따른 결과값 검증")
    @CsvSource(value = {"1,1", "3,4", "6,1", "4,10", "5,100"})
    @ParameterizedTest
    void resultTest(int matchCount, int winnerCount) {
        WinnerCountMap winnerCountMap = new WinnerCountMap();

        for (int i = 0; i < winnerCount; i++) {
            winnerCountMap.addCount(matchCount);
        }

        long expected = (long) PRIZES[matchCount] * winnerCount;
        assertEquals(expected, winnerCountMap.getResultOf(matchCount));
    }


    @DisplayName("맞은 숫자 개수에 따른 결과값 검증")
    @MethodSource("totalResultTestCase")
    @ParameterizedTest
    void totalResultTest(List<Integer> winnerCounts) {
        WinnerCountMap winnerCountMap = new WinnerCountMap();

        long expected = 0L;

        for (int i = 3; i <= 6; i++) {
            for (int j = 0; j < winnerCounts.get(i - 3); j++) {
                winnerCountMap.addCount(i);
            }
            expected += (long) PRIZES[i] * winnerCounts.get(i - 3);
        }

        assertEquals(expected, winnerCountMap.getTotalResult());
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> totalResultTestCase() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 5, 6, 3)),
            Arguments.of(Arrays.asList(1, 5, 6, 3)),
            Arguments.of(Arrays.asList(5, 3, 2, 1))
        );
    }
}
