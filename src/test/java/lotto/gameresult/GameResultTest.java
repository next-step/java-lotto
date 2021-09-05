package lotto.gameresult;

import lotto.game.LottoGame;
import lotto.number.BonusNumber;
import lotto.number.WinningNumbers;
import lotto.ticket.LottoTicket;
import lotto.ticket.LottoTickets;
import lotto.ticket.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 게임 결과")
class GameResultTest {

    private static final int[] WINNING_NUMBERS = {1, 2, 3, 4, 5, 6};

    @DisplayName("등수가")
    @ParameterizedTest(name = "{0}인 티켓: {1}장.")
    @MethodSource("provideTicketCountPerPrize")
    void createPlayResult(Prize prize, int ticketCounts) {
        LottoGame lottoGame = lottoGame();
        GameResult gameResult = new GameResult(lottoGame, new WinningNumbers(WINNING_NUMBERS), new BonusNumber(7));
        assertThat(gameResult.countTicketsWinning(prize)).isEqualTo(ticketCounts);
    }

    private LottoGame lottoGame() {
        List<LottoTicket> tickets = List.of(
                new LottoTicket(1, 2, 3, 4, 5, 8),
                new LottoTicket(1, 2, 3, 4, 5, 7),
                new LottoTicket(1, 2, 3, 4, 5, 6),
                new LottoTicket(1, 2, 3, 4, 9, 8),
                new LottoTicket(1, 2, 3, 10, 9, 8),
                new LottoTicket(1, 2, 11, 10, 9, 8),
                new LottoTicket(1, 12, 11, 10, 9, 8),
                new LottoTicket(13, 12, 11, 10, 9, 8)
        );
        return lottoGame(tickets);
    }

    private static Stream<Arguments> provideTicketCountPerPrize() {
        return Stream.of(
                Arguments.of(Prize.FIRST, 1),
                Arguments.of(Prize.SECOND, 1),
                Arguments.of(Prize.THIRD, 1),
                Arguments.of(Prize.FOURTH, 1),
                Arguments.of(Prize.FIFTH, 1),
                Arguments.of(Prize.LOSER, 3)
        );
    }

    @DisplayName("로또 넘버별 수익률")
    @ParameterizedTest(name = "로또 넘버{0}: 수익률은 {1}.")
    @MethodSource("provideTicketsWithProfitRate")
    void getExpectedProfitRateOfLottoGame(List<LottoTicket> tickets, double profitRate) {
        GameResult gameResult = new GameResult(lottoGame(tickets), new WinningNumbers(WINNING_NUMBERS), new BonusNumber(7));
        assertThat(gameResult.profitRate().value()).isEqualTo(profitRate);
    }

    private LottoGame lottoGame(List<LottoTicket> tickets) {
        return new LottoGame(LottoTicket.PRICE * tickets.size()) {
            @Override
            public List<LottoTicket> lottoTickets() {
                return new LottoTickets(tickets).value();
            }
        };
    }

    private static Stream<Arguments> provideTicketsWithProfitRate() {
        List<LottoTicket> tickets1 = List.of(
                new LottoTicket(1, 2, 3, 10, 11, 12),
                new LottoTicket(13, 14, 15, 16, 17, 18),
                new LottoTicket(13, 14, 15, 16, 17, 18),
                new LottoTicket(13, 14, 15, 16, 17, 18),
                new LottoTicket(13, 14, 15, 16, 17, 18),
                new LottoTicket(13, 14, 15, 16, 17, 18)

        );
        List<LottoTicket> tickets2 = List.of(
                new LottoTicket(1, 2, 3, 10, 11, 12),
                new LottoTicket(13, 14, 15, 16, 17, 18),
                new LottoTicket(13, 14, 15, 16, 17, 18),
                new LottoTicket(13, 14, 15, 16, 17, 18),
                new LottoTicket(13, 14, 15, 16, 17, 18)

        );
        List<LottoTicket> tickets3 = List.of(
                new LottoTicket(1, 2, 3, 10, 11, 12),
                new LottoTicket(13, 14, 15, 16, 17, 18),
                new LottoTicket(13, 14, 15, 16, 17, 18),
                new LottoTicket(13, 14, 15, 16, 17, 18)

        );
        return Stream.of(
                Arguments.of(tickets1, 0.8333333333333334),
                Arguments.of(tickets2, 1),
                Arguments.of(tickets3, 1.25)
        );
    }
}
