package lotto.domain.reward;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {

    @ParameterizedTest
    @MethodSource("lottoResultAndExpectedProfitRate")
    @DisplayName("구매자가 지불한 총 가격과 총 당첨 금액을 비교하여 수익률을 계산한다.")
    void CalculateProfitRate(final Map<LottoRank, Long> result, final double expectedProfitRate) {
        final LottoResult lottoResult = LottoResult.from(result);

        assertThat(lottoResult.profitRate())
                .isEqualTo(expectedProfitRate);
    }

    private static Stream<Arguments> lottoResultAndExpectedProfitRate() {
        return Stream.of(
                Arguments.of(toLottoResult(0, 0, 0, 0, 1), 0.0),
                Arguments.of(toLottoResult(0, 0, 0, 1, 0), 5.0),
                Arguments.of(toLottoResult(0, 0, 1, 0, 0), 50.0),
                Arguments.of(toLottoResult(0, 1, 0, 0, 0), 1500.0),
                Arguments.of(toLottoResult(1, 0, 0, 0, 0), 2000000.0),
                Arguments.of(toLottoResult(0, 0, 0, 1, 1), 2.5),
                Arguments.of(toLottoResult(0, 0, 0, 1, 13), 0.35)
        );
    }

    private static Map<LottoRank, Long> toLottoResult(final long... rankCounts) {
        final LottoRank[] ranks = LottoRank.values();

        return IntStream.range(0, rankCounts.length)
                .boxed()
                .collect(Collectors.toMap(i -> ranks[i], i -> rankCounts[i]));
    }
}
