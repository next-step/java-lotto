package step2.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.NotEnoughMoneyException;
import step2.model.LottoTicketPrice;
import step2.model.LottoTickets;
import step2.model.Money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMachineTest {

    private static final LottoMachine LOTTO_MACHINE = LottoMachine.newInstance(LottoTicketPrice.PRICE_1000);

    @DisplayName("티켓 가격을 입력 할 수 있다")
    @Test
    void newInstance_TicketPrice_MachineInstance() {
        assertThat(LOTTO_MACHINE).isInstanceOf(LottoMachine.class);
    }

    @DisplayName("입력한 금액으로 살 수 있는 최대 장수를 LottoTickets으로 반환한다")
    @Test
    void buyTicket_Money_LottoTickets() {
        Money money = Money.valueOf(10000);
        LottoTickets lottoTickets = LOTTO_MACHINE.buyTicket(money);

        assertThat(lottoTickets.getCount()).isEqualTo(10000 / LottoTicketPrice.PRICE_1000.getPrice());
    }

    @DisplayName("입력한 금액이 부족하면 예외가 발생한다")
    @Test
    void buyTicket_LackMoney_ExceptionThrown() {
        assertThatThrownBy(() -> LOTTO_MACHINE.buyTicket(Money.valueOf(10)))
                .isInstanceOf(NotEnoughMoneyException.class);
    }
}
