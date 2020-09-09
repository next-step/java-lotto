package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
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
        List<Prize> result1 = new ArrayList<>();
        result1.addAll(getPrizeList(Prize.FOURTH, 1));
        result1.addAll(getPrizeList(Prize.ETC, 13));

        List<Prize> result2 = new ArrayList<>();
        result2.addAll(getPrizeList(Prize.ETC, 13));

        List<Prize> result3 = new ArrayList<>();
        result3.addAll(getPrizeList(Prize.SECOND, 1));
        result3.addAll(getPrizeList(Prize.THIRD, 1));
        result3.addAll(getPrizeList(Prize.FOURTH, 2));
        result3.addAll(getPrizeList(Prize.ETC, 5));

        return Stream.of(
                Arguments.of(result1, 0.35),
                Arguments.of(result2, 0.00),
                Arguments.of(result3, 173.33)
        );
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
