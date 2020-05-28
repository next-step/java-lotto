package step2.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.controller.LottoTicketMachine;
import step2.exception.NotEnoughMoneyException;
import step2.model.LottoTicketGenerator;
import step2.model.LottoTicketPrice;
import step2.model.LottoTickets;
import step2.model.Money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketMachineTest {

    private static final LottoTicketMachine lottoTicketMachine = LottoTicketMachine.newInstance(LottoTicketPrice.PRICE_1000);

    @DisplayName("티켓 가격을 입력 할 수 있다")
    @Test
    void newInstance_TicketPrice_MachineInstance() {
        assertThat(lottoTicketMachine).isInstanceOf(LottoTicketMachine.class);
    }

    @DisplayName("입력한 금액으로 살 수 있는 최대 장수를 LottoTickets으로 반환한다")
    @Test
    void buy_Money_LottoTickets() {
        Money money = Money.valueOf(10000);
        LottoTickets lottoTickets = lottoTicketMachine.buy(money);

        assertThat(lottoTickets.getCount()).isEqualTo(10000 / LottoTicketPrice.PRICE_1000.getPrice());
    }

    @DisplayName("입력한 금액이 부족하면 예외가 발생한다")
    @Test
    void buy_LackMoney_ExceptionThrown() {
        assertThatThrownBy(() -> lottoTicketMachine.buy(Money.valueOf(10)))
                .isInstanceOf(NotEnoughMoneyException.class);
    }
}
