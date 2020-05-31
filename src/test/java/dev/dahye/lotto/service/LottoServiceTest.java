package dev.dahye.lotto.service;

import dev.dahye.lotto.domain.LottoTicket;
import dev.dahye.lotto.domain.Winning;
import dev.dahye.lotto.util.DoubleUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("로또 발급")
class LottoServiceTest {
    @ParameterizedTest(name = "{0}원일 때, {1}개")
    @MethodSource("moneyForTicket")
    @DisplayName("로또 구입 금액을 입력하면 구입 금액 만큼 로또를 발급한다.")
    void 로또_발급(int money, int ticketCount) {
        LottoService lottoService = new LottoService(money);
        assertThat(ticketCount).isEqualTo(lottoService.getTicketsCount());
    }

    private static Stream<Arguments> moneyForTicket() {
        return Stream.of(
                arguments(1000, 1),
                arguments(2000, 2),
                arguments(10000, 10)
        );
    }

    @ParameterizedTest(name = "금액 = {0}원")
    @ValueSource(ints = {100, 101, 222, 33333, 0})
    @DisplayName("로또 금액이 1000원 단위가 아니거나 0인 경우 IllegalArguments exception throw")
    void 로또_발급_예외(int money) {
        assertThrows(IllegalArgumentException.class, () -> new LottoService(money));
    }

    @ParameterizedTest(name = "입력 값 = {0}")
    @ValueSource(strings = {"1, 2, 3, 4, 5"})
    @NullAndEmptySource
    @DisplayName("당첨 숫자가 6개가 아닌 경우 IllegalArguments exception throw")
    void winners_must_be_six_numbers(String winnerNumbers) {
        LottoService lottoService = new LottoService(1000);
        assertThrows(IllegalArgumentException.class, () -> lottoService.getWinnings(winnerNumbers));
    }

    @ParameterizedTest(name = "입력 값 = {0}, 예상 결과 = {1}")
    @MethodSource("winnings")
    @DisplayName("당첨 번호를 입력하면 당첨 여부를 알 수 있다.")
    void lotto_ticket_winnings(String winningNumbers, Winning winning) {
        LottoTicket lottoTicket = LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoService lottoServiceTest = new LottoService(1000, Arrays.asList(lottoTicket));
        assertThat(lottoServiceTest.getWinnings(winningNumbers).get(0)).isEqualTo(winning);
    }

    private static Stream<Arguments> winnings() {
        return Stream.of(
                arguments("1, 2, 3, 23, 24, 25", Winning.FOURTH),
                arguments("1, 2, 3, 4, 25, 26", Winning.THIRD)
        );
    }

    @Test
    @DisplayName("로또 수익률을 구할 수 있다.")
    void lotto_winning_rate() {
        int money = 2000;
        LottoTicket lottoTicketByWinningFirst = LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicketByWinningSecond = LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 7));

        LottoService lottoService = new LottoService(2000, Arrays.asList(
                lottoTicketByWinningFirst,
                lottoTicketByWinningSecond
        ));

        String winningNumbers = "1, 2, 3, 4, 5, 6";
        List<Winning> winnings = lottoService.getWinnings(winningNumbers);

        assertThat(lottoService.getWinningRate(winnings))
                .isEqualTo(DoubleUtils.parseDoubleSecondDigit(
                        (Winning.FIRST.getPrize() + Winning.SECOND.getPrize()) / money)
                );
    }

}