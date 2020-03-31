package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @DisplayName("금액에 따른 로또 티켓 계산")
    @Test
    void machinePurchaseTest() {
        LottoMachine machine = new LottoMachine();
        assertThat(machine.purchaseTicket("14000")).isEqualTo(14);
    }

    @DisplayName("로또티켓 만들기 테스트")
    @Test
    void createLottoTicketsTest() {
        LottoMachine lottoMachine = new LottoMachine();
        LottoTickets tickets = lottoMachine.purchaseTicket("3000");
        assertThat(tickets.ticketList().size()).isEqualTo(3);
    }

    @Test
    void exceptionTest() {
        LottoMachine machine = new LottoMachine();
        assertThatThrownBy(() ->
                machine.purchaseTicket("3"))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() ->
                machine.purchaseTicket("aaa"))
                .isInstanceOf(RuntimeException.class);
    }
}
