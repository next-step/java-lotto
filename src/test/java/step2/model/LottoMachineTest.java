package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.NotEnoughMoneyException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMachineTest {

    private static final LottoMachine LOTTO_MACHINE = LottoMachine.create(LottoTicketPrice.PRICE_1000);

    @DisplayName("스태틱 메소드 생성자는 LottoMachine 인스턴스를 반환한다")
    @Test
    void create_TicketPrice_MachineInstance() {
        assertThat(LOTTO_MACHINE).isInstanceOf(LottoMachine.class);
    }

    @DisplayName("스태틱 메소드 생성자에 Null을 입력하면 예외가 발생한다")
    @Test
    void create_Null_ExceptionThrown() {
        assertThatThrownBy(() -> LottoMachine.create(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 금액으로 살 수 있는 최대 장수를 LottoTickets으로 반환한다")
    @Test
    void buyTicket_Money_LottoTickets() {
        Money money = Money.valueOf(10000);
        LottoTickets lottoTickets = LOTTO_MACHINE.buyTicket(money);

        assertThat(lottoTickets.getTicketCount()).isEqualTo(10000 / LottoTicketPrice.PRICE_1000.getPrice());
    }

    @DisplayName("입력한 금액이 부족하면 예외가 발생한다")
    @Test
    void buyTicket_LackMoney_ExceptionThrown() {
        assertThatThrownBy(() -> LOTTO_MACHINE.buyTicket(Money.valueOf(10)))
                .isInstanceOf(NotEnoughMoneyException.class);
    }
}
