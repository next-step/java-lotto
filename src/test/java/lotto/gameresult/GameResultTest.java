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

    @DisplayName("등수가")
    @ParameterizedTest(name = "{0}인 티켓: {1}장.")
    @MethodSource("provideTicketCountPerPrize")
    void createPlayResult(Prize prize, int ticketCounts) {
        int[][] numbers = {
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 7},
                {1, 2, 3, 4, 5, 8},
                {1, 2, 3, 4, 9, 8},
                {1, 2, 3, 10, 9, 8},
                {1, 2, 11, 10, 9, 8},
                {1, 12, 11, 10, 9, 8},
                {13, 12, 11, 10, 9, 8}};
        LottoGame lottoGame = lottoGame(numbers);
        GameResult gameResult = new GameResult(lottoGame, new WinningNumbers(1, 2, 3, 4, 5, 6), new BonusNumber(7));
        assertThat(gameResult.countTicketsWinning(prize)).isEqualTo(ticketCounts);
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
    @MethodSource("provideTicketNumbersWithProfitRate")
    void getExpectedProfitRateOfLottoGame(int[][] numbers, double profitRate) {
        GameResult gameResult = new GameResult(lottoGame(numbers), new WinningNumbers(1, 2, 3, 4, 5, 6), new BonusNumber(7));
        assertThat(gameResult.profitRate()).isEqualTo(profitRate);
    }

    private LottoGame lottoGame(int[][] numbers) {
        return new LottoGame(LottoTicket.PRICE * numbers.length) {
            @Override
            public List<LottoTicket> getLottoTickets() {
                return new LottoTickets(numbers).value();
            }
        };
    }

    private static Stream<Arguments> provideTicketNumbersWithProfitRate() {
        int[][] numbers1 = {{1, 2, 3, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {13, 14, 15, 16, 17, 18}, {13, 14, 15, 16, 17, 18}, {13, 14, 15, 16, 17, 18}, {13, 14, 15, 16, 17, 18}};
        int[][] numbers2 = {{1, 2, 3, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {13, 14, 15, 16, 17, 18}, {13, 14, 15, 16, 17, 18}, {13, 14, 15, 16, 17, 18}};
        int[][] numbers3 = {{1, 2, 3, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {13, 14, 15, 16, 17, 18}, {13, 14, 15, 16, 17, 18}};
        return Stream.of(
                Arguments.of(numbers1, 0.8333333333333334),
                Arguments.of(numbers2, 1),
                Arguments.of(numbers3, 1.25)
        );
    }
}
