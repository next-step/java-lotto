package lotto.gameresult;

import lotto.helper.Helper;
import lotto.ticket.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 게임 결과")
class GameResultTest {

    private static Stream<Arguments> provideTicketNumbersWithProfitRate() {
        int[][] numbers1 = {{1, 2, 3, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {13, 14, 15, 16, 17, 18}, {13, 14, 15, 16, 17, 18}, {13, 14, 15, 16, 17, 18}, {13, 14, 15, 16, 17, 18}};
        int[][] numbers2 = {{1, 2, 3, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {13, 14, 15, 16, 17, 18}, {13, 14, 15, 16, 17, 18}, {13, 14, 15, 16, 17, 18}};
        int[][] numbers3 = {{1, 2, 3, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {13, 14, 15, 16, 17, 18}, {13, 14, 15, 16, 17, 18}};
        return Stream.of(
                Arguments.of(numbers1, 0.83),
                Arguments.of(numbers2, 1),
                Arguments.of(numbers3, 1.25)
        );
    }

    private static Stream<Arguments> provideTicketCountPerPrize() {
        return Stream.of(
                Arguments.of(1, Prize.FIRST),
                Arguments.of(1, Prize.SECOND),
                Arguments.of(1, Prize.THIRD),
                Arguments.of(1, Prize.FOURTH),
                Arguments.of(1, Prize.LOSER)
        );
    }

    @DisplayName("1~4등 1장씩 가질 경우 상금은 2001555000원")
    @Test
    void getExpectedPrizeMoneyOfTheGame() {
        GameResult gameResult = new GameResult(Helper.lottoGame(), Helper.winningNumbers());
        assertThat(gameResult.getTotalPrizeMoney()).isEqualTo(Helper.totalPrizeMoney());
    }

    @DisplayName("등수가")
    @ParameterizedTest(name = "{1}인 티켓: {0}장.")
    @MethodSource("provideTicketCountPerPrize")
    void createPlayResult(int ticketCounts, Prize prize) {
        GameResult gameResult = new GameResult(Helper.lottoGame(), Helper.winningNumbers());
        assertThat(gameResult.countTicketsWinning(prize)).isEqualTo(ticketCounts);
    }

    @DisplayName("로또 넘버별 수익률")
    @ParameterizedTest(name = "로또 넘버{0}: 수익률은 {1}.")
    @MethodSource("provideTicketNumbersWithProfitRate")
    void getExpectedProfitRateOfLottoGame(int[][] lottoNumbers, double profitRate) {
        GameResult gameResult = new GameResult(Helper.lottoGame(lottoNumbers), Helper.winningNumbers());
        assertThat(gameResult.getProfitRate()).isEqualTo(profitRate);
    }
}
