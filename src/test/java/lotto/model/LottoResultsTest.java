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
        assertThat(new LottoResults(Map.of(3, 1, 4, 1, 5, 1, 6, 1)).getPrizeValue())
                .isEqualTo(2001555000L);
        assertThat(new LottoResults(Map.of(3, 0, 4, 1, 5, 1, 6, 4)).getPrizeValue())
                .isEqualTo(8001550000L);
    }

    @ParameterizedTest
    @DisplayName("당첨금과 구매 금액을 통해 수익률을 계산한다.")
    @MethodSource("returnRateProvider")
    void getReturnRate(LottoResults results, double expectedRate) {
        assertThat(results.getReturnRate(new PurchaseAmount(14000))).isEqualTo(expectedRate);
    }

    static Stream<Arguments> returnRateProvider() {
        return Stream.of(
                Arguments.of(new LottoResults(Map.of(3, 0, 4, 0, 5, 0, 6, 0)), 0.0),
                Arguments.of(new LottoResults(Map.of(3, 1, 4, 0, 5, 0, 6, 0)), 0.35),
                Arguments.of(new LottoResults(Map.of(3, 0, 4, 0, 5, 0, 6, 1)), 142857.14)
        );
    }
}