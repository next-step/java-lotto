package lottery;

import lottery.domain.LotteryGame;
import lottery.domain.LotteryRank;
import lottery.domain.LotteryTicket;
import lottery.domain.LotteryTicketsGroup;
import lottery.view.ViewMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryGameTest {

    private static Stream<Arguments> mockLotteryTicketBuilder() {
        return Stream.of(
                Arguments.of(LotteryTicket.from("11, 22, 33, 44, 1, 2".split(ViewMessages.COMMA)),
                        LotteryRank.FIRST_PRIZE, 1),
                Arguments.of(LotteryTicket.from("1, 2, 3, 44, 9, 8".split(ViewMessages.COMMA)),
                        LotteryRank.FOURTH_PRIZE, 2)
        );
    }

    @DisplayName("LotteryGame에서 당첨 번호를 비교해 당첨된 로또 티켓들의 개수를 저장한 Map 반환")
    @ParameterizedTest
    @MethodSource("mockLotteryTicketBuilder")
    public void findLotteryWinnerTicketsGroup(LotteryTicket winnerTicket, LotteryRank lotteryRank,
                                              int winnerCounts) {
        LotteryTicket loser = LotteryTicket.from("1,2,3,4,5,6".split(","));
        LotteryTicket winner = LotteryTicket.from("11,22,33,44,1,2".split(","));
        LotteryTicketsGroup lotteryTicketsGroup = LotteryTicketsGroup.from(Arrays.asList(loser, winner));

        LotteryGame lotteryGame = LotteryGame.getInstance();
        Map<LotteryRank, Integer> winnerTicketsGroup = lotteryGame
                .drawLottery(lotteryTicketsGroup, winnerTicket);

        assertThat(winnerTicketsGroup.get(lotteryRank)).isEqualTo(winnerCounts);
    }
}
