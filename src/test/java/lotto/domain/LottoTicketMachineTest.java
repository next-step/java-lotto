package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTicketMachineTest {

    LottoTicketMachine machine = LottoTicketMachine.getInstance();

    @ParameterizedTest
    @MethodSource("provideManualOrder")
    @DisplayName("입력한 개수만큼 수동로또티켓을 발행할수 있다.")
    void manual_ticket_creation(int[][] manualNumbers, int expectedCount) {
        ManualLottoTickets manualTickets = machine.issueTicketsByManualWay(manualNumbers);
        assertThat(manualTickets.getCount()).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @MethodSource("provideAutoOrder")
    @DisplayName("입력한 개수만큼 자동로또티켓을 발행할수 있다.")
    void auto_ticket_creation(TicketCount autoCount, int expectedCount) {
        AutoLottoTickets autoTickets = machine.issueTicketsByAutoWay(autoCount);
        assertThat(autoTickets.getCount()).isEqualTo(expectedCount);
    }

    private static Stream<Arguments> provideAutoOrder() {
        return Stream.of(
            Arguments.of(new TicketCount(0), 0),
            Arguments.of(new TicketCount(1), 1),
            Arguments.of(new TicketCount(2), 2)
        );
    }

    private static Stream<Arguments> provideManualOrder() {
        return Stream.of(
            Arguments.of(getZeroManualNumbers(), 0),
            Arguments.of(getOneManualNumbers(), 1),
            Arguments.of(getTwoManualNumbers(), 2)
        );
    }

    private static int[][] getZeroManualNumbers() {
        return new int[][]{};
    }

    private static int[][] getOneManualNumbers() {
        return new int[][]{{1, 2, 3, 4, 5, 6}};
    }

    private static int[][] getTwoManualNumbers() {
        return new int[][]{{1, 2, 3, 4, 5, 6}, {1, 2, 3, 4, 5, 6}};
    }

}