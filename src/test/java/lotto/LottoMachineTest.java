package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTickets;
import lotto.domain.TicketMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @DisplayName("로또 수동 구매 테스트")
    @Test
    void lottoManualPurchaseTest() {
        LottoMachine machine = new LottoMachine();
        machine.purchaseTotalTicket(10000);
        machine.purchaseManualTicket(5);

        assertThat(machine.purchaseManualTicket(5)).isEqualTo(5);
    }

    @DisplayName("금액에 따른 로또 티켓 계산")
    @Test
    void machinePurchaseTest() {
        LottoMachine machine = new LottoMachine();
//        assertThat(machine.purchaseTotalTicket(14000))
    }

    @DisplayName("로또티켓 만들기 테스트")
    @Test
    void createLottoTicketsTest() {
        LottoMachine lottoMachine = new LottoMachine();
//        LottoTickets tickets = lottoMachine.purchaseTotalTicket(3000);
//        assertThat(tickets.ticketList().size()).isEqualTo(3);
    }

    @Test
    void exceptionTest() {
        LottoMachine machine = new LottoMachine();
//        assertThatThrownBy(() ->
//                machine.purchaseTotalTicket(3))
//                .isInstanceOf(RuntimeException.class);
    }
}
