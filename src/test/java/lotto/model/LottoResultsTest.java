package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultsTest {

    @Test
    @DisplayName("당첨금 합계를 계산한다.")
    void getPrizeValue() {
        assertThat(new LottoResults(Map.of(Prize.FIFTH, 1, Prize.FOURTH, 1, Prize.THIRD, 1, Prize.FIRST, 1)).getPrizeValue())
                .isEqualTo(2_001_555_000L);
        assertThat(new LottoResults(Map.of(Prize.FIFTH, 0, Prize.FOURTH, 1, Prize.THIRD, 1, Prize.FIRST, 4)).getPrizeValue())
                .isEqualTo(8_001_550_000L);
        assertThat(new LottoResults(Map.of(Prize.SECOND, 3, Prize.FIRST, 2)).getPrizeValue())
                .isEqualTo(4_090_000_000L);
    }

    @ParameterizedTest
    @DisplayName("당첨금과 구매 금액을 통해 수익률을 계산한다.")
    @MethodSource("returnRateProvider")
    void getReturnRate(LottoResults results, double expectedRate) {
        assertThat(results.getReturnRate(new PurchaseAmount(14000))).isEqualTo(expectedRate);
    }

    static Stream<Arguments> returnRateProvider() {
        return Stream.of(
                Arguments.of(new LottoResults(Map.of(Prize.FIFTH, 0, Prize.FOURTH, 0, Prize.THIRD, 0, Prize.FIRST, 0)), 0.0),
                Arguments.of(new LottoResults(Map.of(Prize.FIFTH, 1, Prize.FOURTH, 0, Prize.THIRD, 0, Prize.FIRST, 0)), 0.35),
                Arguments.of(new LottoResults(Map.of(Prize.FIFTH, 0, Prize.FOURTH, 0, Prize.SECOND, 1, Prize.FIRST, 1)), 145000.0)
        );
    }
}