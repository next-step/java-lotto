package Lotto.Game;

import Lotto.Helper.Helper;
import Lotto.Ticket.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 게임 결과")
public class ExpectedGameResultTest {

    private static Stream<Arguments> provideTicketCountPerPrize() {
        return Stream.of(
                Arguments.of(1, Prize.FIRST),
                Arguments.of(1, Prize.SECOND),
                Arguments.of(1, Prize.THIRD),
                Arguments.of(1, Prize.FOURTH),
                Arguments.of(1, Prize.LOSER)
        );
    }

    @DisplayName("등수가")
    @ParameterizedTest(name = "{1}인 티켓: {0}장.")
    @MethodSource("provideTicketCountPerPrize")
    void createPlayResult(int ticketCounts, Prize prize) {
        ExpectedGameResult expectedGameResult = new ExpectedGameResult(Helper.lottoTickets(), Helper.winningNumbers());
        assertThat(expectedGameResult.countTicketsWinningPrize(prize)).isEqualTo(ticketCounts);
    }
}
