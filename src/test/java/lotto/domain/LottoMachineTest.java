package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    @Test
    @DisplayName("로또 발행 머신은 1장의 가격을 넣으면 1장이 발급된다.")
    void buyOneLottoTicket() {
        LottoMachine lottoMachine = new LottoMachine(LottoConstant.TICKET_PRICE);
        assertThat(lottoMachine.getTickets()).hasSize(1);
    }

    @Test
    @DisplayName("로또 머신은 수동으로 구매할 로또 수에 해당하는 금액보다 적으면 에러가 발생한다.")
    void createLottoTicketsWithNotEnoughMoney() {
        List<LottoTicket> manualTickets = List.of(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));
        assertThatThrownBy(() -> new LottoMachine(0, manualTickets)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 머신은 수동으로 구매할 로또 수를 제외하고 나머지를 자동으로 발행한다.")
    void createLottoTickets() {
        LottoTicket manualTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        LottoMachine lottoMachine = new LottoMachine(LottoConstant.TICKET_PRICE*3, List.of(manualTicket));
        assertThat(lottoMachine.getTickets())
                .hasSize(3)
                .contains(manualTicket);
    }

}