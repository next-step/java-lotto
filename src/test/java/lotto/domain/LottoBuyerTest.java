package lotto.domain;

import lotto.matcher.LottoMatcher;
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

class LottoBuyerTest {

    private LottoShop createLottoShop() {
        return new LottoShop();
    }

    private LottoTicket createLottoTicket(List<Integer> lottoNumbers) {
        List<Lotto> lottos = lottoNumbers.stream()
                .map(lottoNumber -> new Lotto(lottoNumber))
                .collect(Collectors.toList());
        return new LottoTicket(lottos);
    }

    @Test
    @DisplayName("LottoShop 객체가 null일경우 Exception")
    void validateNullLottoShop() {
        LottoBuyer lottoBuyer = new LottoBuyer(1000, new LottoTickets(Arrays.asList(this.createLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)))));
        assertThatThrownBy(() -> lottoBuyer.buyLotto(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private LottoBuyer createLottoBuyer(int price, LottoTickets lottoTickets) {
        return new LottoBuyer(price, lottoTickets);
    }

    @ParameterizedTest
    @MethodSource("provideLottos")
    @DisplayName("로또 구매 테스트")
    void buyLottos(int price, int count, List<Integer> numbers) {
        LottoShop lottoShop = this.createLottoShop();
        LottoBuyer lottoBuyer = this.createLottoBuyer(price, new LottoTickets(Arrays.asList(this.createLottoTicket(numbers))));
        LottoTickets lottoTickets = lottoBuyer.buyLotto(lottoShop);
        assertThat(lottoTickets.getPurchaseTicketCount()).isEqualTo(count);
    }

    private static Stream<Arguments> provideLottos() {
        return Stream.of(
                Arguments.of(1000, 1, Arrays.asList(1,2,3,4,5,6)),
                Arguments.of(2000, 2, Arrays.asList(45,44,43,42,41,40)),
                Arguments.of(5000, 5, Arrays.asList(10,11,12,13,14,15))
        );
    }

    @ParameterizedTest
    @MethodSource("provideLottosForEarningsRate")
    @DisplayName("수익률 계산")
    void calculateEarningsRate(int price, List<Integer> numbers, List<Integer> winnerNumbers, int bonusBall, BigDecimal earningRate) {
        LottoShop lottoShop = this.createLottoShop();
        LottoBuyer lottoBuyer = this.createLottoBuyer(price, new LottoTickets(Arrays.asList(this.createLottoTicket(numbers))));
        LottoTickets lottoTickets = lottoBuyer.buyLotto(lottoShop);
        LottoWinnerNumber lottoWinnerNumber = new LottoWinnerNumber(convertLotto(winnerNumbers), new Lotto(bonusBall));
        List<LottoMatcher> lottoMatchers = lottoTickets.findLottoMatchResults(lottoWinnerNumber);
        BigDecimal calculateEarningRate = lottoBuyer.calculateEarningsRate(lottoMatchers, lottoShop);
        assertThat(calculateEarningRate.doubleValue()).isEqualTo(earningRate.doubleValue());
    }

    private static Stream<Arguments> provideLottosForEarningsRate() {
        return Stream.of(
                Arguments.of(1000, Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), 7, BigDecimal.valueOf(2000000)),
                Arguments.of(1000, Arrays.asList(45, 44, 43, 42, 41, 40), Arrays.asList(45, 2, 3, 4, 5, 6), 1, BigDecimal.valueOf(0)),
                Arguments.of(1000, Arrays.asList(10, 11, 12, 13, 14, 15), Arrays.asList(10, 11, 12, 13, 5, 6), 7, BigDecimal.valueOf(50))
        );
    }

    private List<Lotto> convertLotto(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(lottoNumber -> new Lotto(lottoNumber))
                .collect(Collectors.toList());
    }
}