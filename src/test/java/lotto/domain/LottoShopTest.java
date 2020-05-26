package lotto.domain;

import lotto.generator.ManualLottoNumberGenerator;
import lotto.matcher.LottoMatcher;
import lotto.generator.FakeAutoLottoNumberGenerator;
import lotto.generator.AutoLottoNumberGenerator;
import lotto.generator.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoShopTest {

    private LottoShop createLottoSeller() {
        return new LottoShop();
    }

    private LottoNumberGenerator createAutoLottoNumberGenerator() {
        return new AutoLottoNumberGenerator();
    }

    private LottoNumberGenerator createManualLottoNumberGenerator() {
        return new ManualLottoNumberGenerator();
    }

    @ParameterizedTest
    @MethodSource("provideNotValidPrice")
    @DisplayName("로또 구입 가격이 1000원 보다 낮은 경우 Exception")
    void validatePrice(int price) {
        LottoShop lottoShop = this.createLottoSeller();
        assertThatThrownBy(() -> lottoShop.availablePurchase(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideNotValidPrice() {
        return Stream.of(
                Arguments.of(999),
                Arguments.of(0),
                Arguments.of(-1999)
        );
    }

    @Test
    @DisplayName("자동 로또 발급 테스트")
    void buyLottoTest() {
        LottoShop lottoShop = this.createLottoSeller();
        LottoTicket lottoTickets = lottoShop.buyLotto(this.createAutoLottoNumberGenerator(), LottoNumbers.LOTTO_NUMBERS, LottoNumbers.LOTTO_SIZE);
        assertThat(lottoTickets.getLotto()).hasSize(LottoNumbers.LOTTO_SIZE);
    }

    @ParameterizedTest
    @MethodSource("provideManualLotto")
    @DisplayName("수동 로또 구입 테스트")
    void buyManualLotto(List<Integer> lottoNumbers) {
        LottoShop lottoShop = this.createLottoSeller();
        List<Lotto> allLotto = lottoNumbers.stream()
                .map(lottoNumber -> new Lotto(lottoNumber))
                .collect(Collectors.toList());
        LottoTicket lottoTickets = lottoShop.buyLotto(this.createManualLottoNumberGenerator(), allLotto, LottoNumbers.LOTTO_SIZE);
        assertThat(lottoTickets.getLotto()).containsAll(allLotto);
    }

    private static Stream<Arguments> provideManualLotto() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of(Arrays.asList(5, 6, 7, 4, 3, 1)),
                Arguments.of(Arrays.asList(45, 3, 22, 5, 7, 11))
        );
    }

    @ParameterizedTest
    @MethodSource("providePriceAndLottoMatchers")
    @DisplayName("수익률 테스트")
    void calculateEarningsRateTest(int price, List<LottoMatcher> lottoMatchers, double earningRate) {
        LottoShop lottoShop = this.createLottoSeller();
        BigDecimal result = lottoShop.calculateEarningsRate(lottoMatchers, price);
        assertThat(result.doubleValue()).isEqualTo(earningRate);
    }

    private static Stream<Arguments> providePriceAndLottoMatchers() {
        return Stream.of(
                Arguments.of(1000, Arrays.asList(LottoMatcher.FIRST_PLACE), 2000000.00),
                Arguments.of(1000, Arrays.asList(LottoMatcher.SECOND_PLACE), 30000.00),
                Arguments.of(1000, Arrays.asList(LottoMatcher.THIRD_PLACE), 1500.00),
                Arguments.of(1000, Arrays.asList(LottoMatcher.FOURTH_PLACE), 50.00),
                Arguments.of(10000, Arrays.asList(LottoMatcher.THIRD_PLACE), 150.00),
                Arguments.of(10000, Arrays.asList(LottoMatcher.FOURTH_PLACE), 5.00)
        );
    }

    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    @DisplayName("생성된 로또 번호 테스트")
    void verifyLottoNumbers(List<Lotto> lottoNumber) {
        LottoShop lottoShop = this.createLottoSeller();
        LottoTicket result = lottoShop.buyLotto(new FakeAutoLottoNumberGenerator(lottoNumber), LottoNumbers.LOTTO_NUMBERS, LottoNumbers.LOTTO_SIZE);
        assertThat(result.toString()).isEqualTo(lottoNumber.toString());
    }

    private static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of(Arrays.asList(45, 44, 43, 2, 4, 5)),
                Arguments.of(Arrays.asList(23, 22, 43, 31, 18, 1, 9))
        );
    }

    private static LottoWinnerNumber createLottoWinnerNumber(List<Integer> winnerNumbers, int bonusBall) {
        List<Lotto> lottos = winnerNumbers.stream()
                .map(winnerNumber -> new Lotto(winnerNumber))
                .collect(Collectors.toList());
        return new LottoWinnerNumber(lottos, new Lotto(bonusBall));
    }

    private static Lotto createLotto(int number) {
        return new Lotto(number);
    }
}