package lotto.ticketingway;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.LottoTicket;
import lotto.domain.IssueInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ManualWayTest {

    @ParameterizedTest
    @MethodSource("provideManualOrder")
    @DisplayName("원하는 수만큼의 수동로또티켓을 사용자가 주문시 입력한 번호들만큼 발행할수있다.")
    void name(IssueInput input, int expectedCount) {
        ManualWay way = new ManualWay();
        List<LottoTicket> tickets = way.issueLottoTickets(input);
        assertThat(tickets.size()).isEqualTo(expectedCount);
    }

    private static Stream<Arguments> provideManualOrder() {
        return Stream.of(
            Arguments.of(new IssueInput(getZeroManualNumber()), 0),
            Arguments.of(new IssueInput(getOneManualNumbers()), 1),
            Arguments.of(new IssueInput(getTwoManualNumbers()), 2)
        );
    }

    private static int[][] getZeroManualNumber() {
        return new int[][]{};
    }

    private static int[][] getOneManualNumbers() {
        return new int[][]{{1, 2, 3, 4, 5, 6}};
    }

    private static int[][] getTwoManualNumbers() {
        return new int[][]{{1, 2, 3, 4, 5, 6}, {1, 2, 3, 4, 5, 6}};
    }
}