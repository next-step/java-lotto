package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoSellerTest {

    private LottoSeller createLottoSeller(int price) {
        return new LottoSeller(price);
    }

    private LottoNumberGenerator createAutoLottoNumberGenerator() {
        return new AutoLottoNumberGenerator();
    }

    @ParameterizedTest
    @MethodSource("provideNotValidPrice")
    @DisplayName("로또 구입 가격이 1000원 보다 낮은 경우 Exception")
    void validatePrice(int price) {
        assertThatThrownBy(() -> this.createLottoSeller(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideNotValidPrice() {
        return Stream.of(
                Arguments.of(999),
                Arguments.of(0),
                Arguments.of(-1999)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNotValidWinner")
    @DisplayName("지난 주 당첨 번호가 6개가 아닌경우 Exception")
    void validateNotValidWinner(List<Integer> winners) {
        LottoSeller lottoSeller = this.createLottoSeller(1000);
        List<LottoNumberResult> lottoNumberResults = lottoSeller.buyLotto(this.createAutoLottoNumberGenerator(), LottoNumbers.LOTTO_NUMBERS, LottoNumbers.LOTTO_SIZE);
        assertThatThrownBy(() -> lottoSeller.matchLottoRanking(winners, lottoNumberResults))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideNotValidWinner() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4)),
                Arguments.of(Arrays.asList(1, 2, 3)),
                Arguments.of(Arrays.asList(1, 2)),
                Arguments.of(Arrays.asList(1))
        );
    }

    @ParameterizedTest
    @MethodSource("providePurchaseAmountAndLottoCount")
    @DisplayName("로또 발급 테스트")
    void buyLottoTest(int price, int lottoCount) {
        LottoSeller lottoSeller = this.createLottoSeller(price);
        List<LottoNumberResult> lottoNumberResults = lottoSeller.buyLotto(this.createAutoLottoNumberGenerator(), LottoNumbers.LOTTO_NUMBERS, LottoNumbers.LOTTO_SIZE);
        assertThat(lottoNumberResults).hasSize(lottoCount);
    }

    private static Stream<Arguments> providePurchaseAmountAndLottoCount() {
        return Stream.of(
                Arguments.of(1000, 1),
                Arguments.of(4600, 4),
                Arguments.of(7800, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("providePriceAndLottoMatchers")
    @DisplayName("수익률 테스트")
    void calculateEarningsRateTest(int price, List<LottoMatcher> lottoMatchers, double earningRate) {
        LottoSeller lottoSeller = this.createLottoSeller(price);
        BigDecimal result = lottoSeller.calculateEarningsRate(lottoMatchers);
        assertThat(result.doubleValue()).isEqualTo(earningRate);
    }

    private static Stream<Arguments> providePriceAndLottoMatchers() {
        return Stream.of(
                Arguments.of(1000, Arrays.asList(LottoMatcher.FIRST_PLACE), 2000000.00),
                Arguments.of(1000, Arrays.asList(LottoMatcher.SECOND_PLACE), 1500.00),
                Arguments.of(1000, Arrays.asList(LottoMatcher.THIRD_PLACE), 50.00),
                Arguments.of(1000, Arrays.asList(LottoMatcher.FOURTH_PLACE), 5.00),
                Arguments.of(10000, Arrays.asList(LottoMatcher.THIRD_PLACE), 5.00),
                Arguments.of(10000, Arrays.asList(LottoMatcher.FOURTH_PLACE), 0.50)
        );
    }
}