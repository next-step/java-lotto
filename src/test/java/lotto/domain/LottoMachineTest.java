package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    private static final int TICKET_AMOUNT = 1000;

    @Test
    @DisplayName("로또 발행 머신은 1장의 가격을 넣으면 1장이 발급된다.")
    void buyOneLottoTicket() {
        LottoMachine lottoMachine = new LottoMachine(TICKET_AMOUNT);
        assertThat(lottoMachine.issue()).hasSize(1);
    }

    @Test
    @DisplayName("로또 발행 머신은 구입 금액에 해당하는 로또 티켓 N장을 발급해야 한다.")
    void buyLottoTickets() {
        int ticketCount = 5;
        LottoMachine lottoMachine = new LottoMachine(TICKET_AMOUNT * ticketCount);
        assertThat(lottoMachine.issue()).hasSize(ticketCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {TICKET_AMOUNT-1, TICKET_AMOUNT+1})
    @DisplayName("로또 발행 머신은 구입 금액을 장당 가격으로 나누었을 때, 정수가 아니면 에러를 반환한다.")
    void validateAmount(int amount) {
        assertThatThrownBy(() -> new LottoMachine(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 발행 머신은 당첨번호를 입력하면 N개의 번호가 일치하는 티켓 개수와 상금을 각각 반환한다.")
    void getWinningStatistics() {
        List<LottoTicket> tickets = Arrays.asList(
                new LottoTicket(List.of(1,7,8,9,10,11)),
                new LottoTicket(List.of(1,2,8,9,10,11)),
                new LottoTicket(List.of(1,2,3,9,10,11)),
                new LottoTicket(List.of(1,2,3,4,5,6))
        );
        LottoMachine lottoMachine = new LottoMachine(TICKET_AMOUNT, tickets);

        LottoTicket winningTicket = new LottoTicket(List.of(1,2,3,4,5,6));

        assertThat(lottoMachine.compare(winningTicket))
                .containsEntry(LottoRank.FOURTH, 1)
                .containsEntry(LottoRank.THIRD, 0)
                .containsEntry(LottoRank.SECOND, 0)
                .containsEntry(LottoRank.FIRST, 1);
    }

}