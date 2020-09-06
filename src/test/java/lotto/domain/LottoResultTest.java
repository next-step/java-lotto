package lotto.domain;

import lotto.domain.LottoResult;
import lotto.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoResultTest {

    @ParameterizedTest
    @MethodSource("provideResultAndProfitRate")
    @DisplayName("총 수익률")
    void profitRate(Map<Prize, Integer> result, double profitRate) {
        assertEquals(new LottoResult(result).profitRate(), profitRate);
    }

    private static Stream<Arguments> provideResultAndProfitRate() {
        Map<Prize, Integer> result1 = new HashMap<>();
        result1.put(Prize.FOURTH, 1);
        result1.put(Prize.ETC, 13);

        Map<Prize, Integer> result2 = new HashMap<>();
        result2.put(Prize.ETC, 13);

        Map<Prize, Integer> result3 = new HashMap<>();
        result3.put(Prize.SECOND, 1);
        result3.put(Prize.THIRD, 1);
        result3.put(Prize.FOURTH, 2);
        result3.put(Prize.ETC, 5);

        return Stream.of(
                Arguments.of(result1, 0.35),
                Arguments.of(result2, 0.00),
                Arguments.of(result3, 173.33)
        );
    }
}
