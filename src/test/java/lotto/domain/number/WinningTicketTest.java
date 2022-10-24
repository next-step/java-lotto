package lotto.domain.number;

import static lotto.domain.LottoBallsHelper.numbersToBalls;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningTicketTest {

    @ParameterizedTest
    @MethodSource("getMatchTestArguments")
    @DisplayName("주어진 티켓에서 당첨 번호 일치 개수 확인.")
    void count_matching_number(WinningTicket winningNumbers, Ticket ticket, MatchResult expected) {
        assertAll(
                () -> assertThat(winningNumbers.getMatchResult(ticket).getMatchCount()).isEqualTo(expected.getMatchCount()),
                () -> assertThat(winningNumbers.getMatchResult(ticket).getBonusMatch()).isEqualTo(expected.getBonusMatch())
        );
    }

    private static Stream<Arguments> getMatchTestArguments() {
        return Stream.of(
                Arguments.arguments(
                        new WinningTicket(numbersToBalls(List.of(3, 8, 12, 14, 15, 17)), LottoBall.of(40)),
                        new Ticket(numbersToBalls(List.of(1, 2, 3, 4, 5, 6))),
                        new MatchResult(1, false)
                ),
                Arguments.arguments(
                        new WinningTicket(numbersToBalls(List.of(3, 8, 12, 14, 15, 17)), LottoBall.of(40)),
                        new Ticket(numbersToBalls(List.of(3, 8, 12, 14, 15, 17))),
                        new MatchResult(6, false)
                ),
                Arguments.arguments(
                        new WinningTicket(numbersToBalls(List.of(3, 8, 12, 14, 15, 17)), LottoBall.of(5)),
                        new Ticket(numbersToBalls(List.of(3, 5, 12, 14, 15, 17))),
                        new MatchResult(5, true)
                )
        );
    }

}
