package lotto.domain.reward;

import static lotto.config.LottoExceptionMessage.LOTTO_RESULT_DOES_NOT_MATCH_TOTAL_PRICE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProfitRateCalculatorTest {

    @ParameterizedTest
    @MethodSource("lottoResults")
    @DisplayName("당첨 번호와 로또 번호를 비교하여 동일한 갯수에 따라 순위를 부여한다.")
    void Calculate_LottoProfit(final Map<LottoRank, Long> lottoResult, final int totalPrice, final double profitRate) {
        Assertions.assertThat(new ProfitRateCalculator().calculate(lottoResult, totalPrice))
                .isEqualTo(profitRate);
    }

    @Test
    @DisplayName("구매자가 지불한 총 가격에 따른 로또 개수와, 당첨 결과에 따른 로또 개수가 일치하지 않는 경우 예외를 던진다.")
    void Calculate_InvalidTotalPrice() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new ProfitRateCalculator().calculate(toLottoResult(0, 0, 0, 0, 1), 2000))
                .withMessage(LOTTO_RESULT_DOES_NOT_MATCH_TOTAL_PRICE.message());
    }

    private static Stream<Arguments> lottoResults() {
        return Stream.of(
                // 테스트 데이터 : (로또 결과, 구입금액, 예상 수익률)
                Arguments.of(toLottoResult(0, 0, 0, 0, 1), 1000, 0.0),
                Arguments.of(toLottoResult(0, 0, 0, 1, 0), 1000, 5.0),
                Arguments.of(toLottoResult(0, 0, 1, 0, 0), 1000, 50.0),
                Arguments.of(toLottoResult(0, 1, 0, 0, 0), 1000, 1500.0),
                Arguments.of(toLottoResult(1, 0, 0, 0, 0), 1000, 2000000.0),
                Arguments.of(toLottoResult(0, 0, 0, 1, 1), 2000, 2.5),
                Arguments.of(toLottoResult(0, 0, 0, 1, 13), 14000, 0.35)
        );
    }

    private static Map<LottoRank, Long> toLottoResult(final long... rankCounts) {
        final LottoRank[] ranks = LottoRank.values();

        return IntStream.range(0, rankCounts.length)
                .boxed()
                .collect(Collectors.toMap(i -> ranks[i], i -> rankCounts[i]));
    }
}
