package step2.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.controller.LottoTicketMachine;
import step2.model.LottoTicketPrice;
import step2.model.LottoTickets;
import step2.model.Money;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketMachineTest {

    @DisplayName("티켓 가격을 입력 할 수 있다")
    @Test
    void newInstance_TicketPrice_MachineInstance() {
        LottoTicketMachine lottoTicketMachine = LottoTicketMachine.newInstance(LottoTicketPrice.PRICE_1000);

        assertThat(lottoTicketMachine).isInstanceOf(LottoTicketMachine.class);
    }

    @DisplayName("입력한 금액으로 살 수 있는 최대 장수를 LottoTickets으로 반환한다")
    @Test
    void buy_Money_LottoTickets() {
        LottoTicketMachine lottoTicketMachine = LottoTicketMachine.newInstance(LottoTicketPrice.PRICE_1000);

        Money money = Money.valueOf(10000);
        LottoTickets lottoTickets = lottoTicketMachine.buy(money);

        assertThat(lottoTickets.getCount()).isEqualTo(10000 / LottoTicketPrice.PRICE_1000.getPrice());
    }
}
