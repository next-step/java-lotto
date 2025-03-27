package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    private static final LottoMachine lottoMachine = new LottoMachine();
    private static final int TICKET_AMOUNT = 1000;

    @Test
    @DisplayName("로또 발행 머신은 1장의 가격을 넣으면 1장이 발급된다.")
    void buyOneLottoTicket() {
        List<LottoTicket> tickets = lottoMachine.issue(TICKET_AMOUNT);
        assertThat(tickets).hasSize(1);
    }

    @Test
    @DisplayName("로또 발행 머신은 구입 금액에 해당하는 로또 티켓 N장을 발급해야 한다.")
    void buyLottoTickets() {
        int ticketCount = 5;
        List<LottoTicket> tickets = lottoMachine.issue(TICKET_AMOUNT * ticketCount);
        assertThat(tickets).hasSize(ticketCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {TICKET_AMOUNT-1, TICKET_AMOUNT+1})
    @DisplayName("로또 발행 머신은 구입 금액을 장당 가격으로 나누었을 때, 정수가 아니면 에러를 반환한다.")
    void validateAmount(int amount) {
        assertThatThrownBy(() -> lottoMachine.issue(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

}