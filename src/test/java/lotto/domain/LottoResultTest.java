package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoResultTest {

    @ParameterizedTest
    @MethodSource("provideResultAndProfitRate")
    @DisplayName("총 수익률")
    void profitRate(List<Prize> prizes, double profitRate) {
        assertEquals(new LottoResult(prizes).profitRate(), profitRate);
    }

    private static Stream<Arguments> provideResultAndProfitRate() {
        return Stream.of(
                Arguments.of(collectList(
                        getPrizeList(Prize.FIFTH, 1),
                        getPrizeList(Prize.ETC, 13)),
                        0.35
                ),
                Arguments.of(getPrizeList(Prize.ETC, 13), 0.00),
                Arguments.of(collectList(
                        getPrizeList(Prize.THIRD, 1),
                        getPrizeList(Prize.FOURTH, 1),
                        getPrizeList(Prize.FIFTH, 2),
                        getPrizeList(Prize.ETC, 5)),
                        173.33
                ),
                Arguments.of(collectList(
                        getPrizeList(Prize.SECOND, 1),
                        getPrizeList(Prize.ETC, 20)),
                        1428.57
                )
        );
    }

    private static List<Prize> collectList(List<Prize> ... values) {
        return Stream.of(values)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private static List<Prize> getPrizeList(Prize type, int count) {
        return IntStream.range(0, count).
                mapToObj(n -> type)
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("등수에 따른 집계 테스트")
    void getCountOfPrize() {
        LottoResult result = new LottoResult(Arrays.asList(
                Prize.ETC, Prize.ETC, Prize.ETC,
                Prize.FOURTH,
                Prize.THIRD
        ));

        assertEquals(result.getCountOfPrize(Prize.ETC), 3);
        assertEquals(result.getCountOfPrize(Prize.FOURTH), 1);
        assertEquals(result.getCountOfPrize(Prize.THIRD), 1);
        assertEquals(result.getCountOfPrize(Prize.SECOND), 0);
        assertEquals(result.getCountOfPrize(Prize.FIRST), 0);
    }
}
