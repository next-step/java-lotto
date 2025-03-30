package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    private static final int TICKET_AMOUNT = 1000;

    @Test
    @DisplayName("로또 발행 머신은 1장의 가격을 넣으면 1장이 발급된다.")
    void buyOneLottoTicket() {
        LottoMachine lottoMachine = new LottoMachine(new PurchaseAmount(TICKET_AMOUNT));
        assertThat(lottoMachine.getTickets()).hasSize(1);
    }

}