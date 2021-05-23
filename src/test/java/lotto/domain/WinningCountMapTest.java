package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningCountMapTest {

    private static final WinningType[] TYPES = new WinningType[] {
        WinningType.FIRST, WinningType.SECOND, WinningType.THIRD, WinningType.FOURTH, WinningType.FIFTH
    };

    @DisplayName("총 상금 검증")
    @MethodSource("totalPrizeTestCase")
    @ParameterizedTest
    void totalPrizeTest(List<Integer> winningCounts) {

        WinningCountMap winningCountMap = new WinningCountMap();

        long expected = 0L;

        for (int i = 0; i < TYPES.length; i++) {

            int size = winningCounts.get(i);
            for (int j = 0; j < winningCounts.get(i); j++) {
                winningCountMap.addCount(TYPES[i]);
            }

            expected += (long) TYPES[i].getPrize() * (long) size;
        }

        assertEquals(expected, winningCountMap.getTotalPrize());
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> totalPrizeTestCase() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
            Arguments.of(Arrays.asList(2, 3, 4, 5, 1)),
            Arguments.of(Arrays.asList(3, 4, 5, 1, 2)),
            Arguments.of(Arrays.asList(4, 5, 1, 2, 3)),
            Arguments.of(Arrays.asList(5, 1, 2, 3, 4))
        );
    }

    @DisplayName("데이터가 순서대로 뽑히는지 검증")
    @Test
    void dataSetsTest() {
        WinningCountMap winningCountMap = new WinningCountMap();
        List<WinningLottoDto> dataSets = winningCountMap.getDataSets();

        List<WinningType> types = Arrays.stream(WinningType.values())
                                        .sorted((t1, t2) -> t2.getPrize() - t1.getPrize())
                                        .filter(type -> type != WinningType.NONE)
                                        .collect(toList());

        for (int i = 0; i < dataSets.size(); i++) {
            assertEquals(types.get(i).getPrize(), dataSets.get(i).getPrize());
        }
    }
}
