package lotto.domain.reward;

import static lotto.config.LottoExceptionMessage.LOTTO_RESULT_DOES_NOT_MATCH_TOTAL_PRICE;
import static lotto.config.LottoExceptionMessage.LOTTO_TOTAL_PRICE_MUST_BE_BIGGER_THAN_UNIT_PRICE;
import static lotto.config.LottoExceptionMessage.LOTTO_TOTAL_PRICE_MUST_BE_MULTIPLE_OF_UNIT_PRICE;
import static lotto.domain.reward.LottoCalculator.LOTTO_PRICE_PER_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoCalculatorTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 5000, 10000, 50000, 100000})
    @DisplayName("총 로또 구매 가격에 따라 로또 구매 개수를 반환한다.")
    void CalculateQuantity(final int totalPrice) {
        assertThat(new LottoCalculator().calculateQuantity(totalPrice))
                .isEqualTo(totalPrice / LOTTO_PRICE_PER_UNIT);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, LOTTO_PRICE_PER_UNIT - 1})
    @DisplayName("총 로또 구매 가격이 로또 1개 당 가격보다 적은 경우 예외를 던진다.")
    void CalculateQuantity_TotalPriceLessThanUnitPrice_Exception(final int priceLessThanUnitPrice) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoCalculator().calculateQuantity(priceLessThanUnitPrice))
                .withMessage(LOTTO_TOTAL_PRICE_MUST_BE_BIGGER_THAN_UNIT_PRICE.message(priceLessThanUnitPrice));
    }

    @Test
    @DisplayName("총 로또 구매 가격이 로또 1개 당 가격의 배수가 아닌 경우 예외를 던진다.")
    void CalculateQuantity_TotalPriceNotMultipleOfUnitPrice_Exception() {
        final int priceNotMultipleOfUnitPrice = LOTTO_PRICE_PER_UNIT * 2 + 1;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoCalculator().calculateQuantity(priceNotMultipleOfUnitPrice))
                .withMessage(LOTTO_TOTAL_PRICE_MUST_BE_MULTIPLE_OF_UNIT_PRICE.message(priceNotMultipleOfUnitPrice));
    }

    @ParameterizedTest
    @MethodSource("lottoResults")
    @DisplayName("당첨 번호와 로또 번호를 비교하여 동일한 갯수에 따라 순위를 부여한다.")
    void CalculateProfitRate(final Map<LottoRank, Long> lottoResult, final int totalPrice, final double profitRate) {
        assertThat(new LottoCalculator().calculateProfitRate(lottoResult, totalPrice))
                .isEqualTo(profitRate);
    }

    @Test
    @DisplayName("구매자가 지불한 총 가격에 따른 로또 개수와, 당첨 결과에 따른 로또 개수가 일치하지 않는 경우 예외를 던진다.")
    void CalculateProfitRate_InvalidQuantity_Exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoCalculator().calculateProfitRate(toLottoResult(0, 0, 0, 0, 1), 2000))
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
