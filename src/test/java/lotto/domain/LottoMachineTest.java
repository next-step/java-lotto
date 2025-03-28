package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    private static final int TICKET_AMOUNT = 1000;

    @Test
    @DisplayName("로또 발행 머신은 1장의 가격을 넣으면 1장이 발급된다.")
    void buyOneLottoTicket() {
        LottoMachine lottoMachine = new LottoMachine(new PurchaseAmount(TICKET_AMOUNT));
        assertThat(lottoMachine.getTickets()).hasSize(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {TICKET_AMOUNT - 1, TICKET_AMOUNT + 1})
    @DisplayName("로또 발행 머신은 구입 금액을 장당 가격으로 나누었을 때, 정수가 아니면 에러를 반환한다.")
    void validateAmount(int amount) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);

        assertThatThrownBy(() -> new LottoMachine(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 머신은 총수익률을 반환한다")
    void getReturnRate() {
        LottoTickets tickets = new LottoTickets(List.of(
                new LottoTicket(List.of(1, 7, 8, 9, 10, 11)),
                new LottoTicket(List.of(1, 2, 3, 9, 10, 11))
        ));
        LottoMachine lottoMachine = new LottoMachine(tickets);
        LottoTicket winningTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        int amount = TICKET_AMOUNT * tickets.getCount();

        double expected = (double) LottoRank.FOURTH.getPrize() / amount;
        assertThat(lottoMachine.getReturnRate(winningTicket)).isEqualTo(expected);
    }
}