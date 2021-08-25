package edu.nextstep.lottobonusnumber.domain;

import edu.nextstep.lottobonusnumber.domain.numbersmaker.CustomNumbersMaker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class TicketsTest {

    @Test
    @DisplayName("Tickets 생성")
    void create() {
        // given
        Payment payment = new Payment(10_000);

        // when
        Tickets tickets = Tickets.of(payment, new CustomNumbersMaker("1, 2, 3, 4, 5, 6"));

        // then
        Assertions.assertThat(tickets.stream().count())
                .isEqualTo(payment.countOfTickets());
    }

    @Test
    @DisplayName("당첨 결과 계산")
    void checkWinningResult() {
        // given
        Payment payment = new Payment(1_000);
        Tickets tickets = Tickets.of(payment, new CustomNumbersMaker("1, 2, 3, 4, 5, 6"));

        Ticket firstPrizeTicket = Ticket.madeBy(new CustomNumbersMaker("1, 2, 3, 4, 5, 6"));
        LottoNumber bonusNumber = LottoNumber.of(7);
        WinningTicket winningTicket = new WinningTicket(firstPrizeTicket, bonusNumber);

        // when
        Map<Prize, Integer> winningResult = tickets.checkWinningResult(winningTicket);

        // then
        Assertions.assertThat(winningResult.getOrDefault(Prize.FIRST, 0)).isEqualTo(1);
    }
}
