package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTicketBundleTest {

    @ParameterizedTest
    @MethodSource("provideAutoManualTickets")
    @DisplayName("생성된 자동 및 수동 티켓들의 정보를 티켓뭉치에 넣을수있다.")
    void name(AutoLottoTickets autoTickets, ManualLottoTickets manualTickets,
        int expectAutoCount, int expectManualCount, int expectAllCount) {
        LottoTicketBundle bundle = new LottoTicketBundle(autoTickets, manualTickets);
        assertThat(bundle.getAutoTicketCount()).isEqualTo(expectAutoCount);
        assertThat(bundle.getManualTicketCount()).isEqualTo(expectManualCount);
        assertThat(bundle.getAllLottoTickets().size()).isEqualTo(expectAllCount);
    }


    private static Stream<Arguments> provideAutoManualTickets() {

        return Stream.of(
            Arguments.of(oneAutoTicket(), twoManualTicket(), 1, 2, 3),
            Arguments.of(twoAutoTicket(), oneManualTicket(), 2, 1, 3)
        );
    }


    private static AutoLottoTickets oneAutoTicket() {
        LottoTicketMachine machine = LottoTicketMachine.getInstance();
        return machine.issueTicketsByAutoWay(new TicketCount(1));
    }

    private static AutoLottoTickets twoAutoTicket() {
        LottoTicketMachine machine = LottoTicketMachine.getInstance();
        return machine.issueTicketsByAutoWay(new TicketCount(2));
    }

    private static ManualLottoTickets oneManualTicket() {
        LottoTicketMachine machine = LottoTicketMachine.getInstance();
        return machine.issueTicketsByManualWay(new TicketCount(1), getOneManualOrder());
    }

    private static ManualLottoTickets twoManualTicket() {
        LottoTicketMachine machine = LottoTicketMachine.getInstance();
        return machine.issueTicketsByManualWay(new TicketCount(2), getTwoManualOrder());
    }

    private static LottoPurchaseOrder getOneManualOrder() {
        return new LottoPurchaseOrder(new Money(3000),
            new int[][]{{1, 2, 3, 4, 5, 6}});
    }

    private static LottoPurchaseOrder getTwoManualOrder() {
        return new LottoPurchaseOrder(new Money(3000),
            new int[][]{{1, 2, 3, 4, 5, 6}, {1, 2, 3, 4, 5, 6}});
    }


}