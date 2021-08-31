package edu.nextstep.lottocustom.domain;

import edu.nextstep.lottocustom.domain.numbersmaker.AutoNumbersMaker;
import edu.nextstep.lottocustom.domain.numbersmaker.CustomNumbersMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TicketsTest {

    @Test
    @DisplayName("Tickets 생성")
    void isSameSize() {
        // given
        Payment payment = new Payment(10_000);

        // when
        Tickets tickets = Tickets.of(payment, new ArrayList<>(), new CustomNumbersMaker("1,2,3,4,5,6"));

        // then
        assertThat(tickets).isEqualTo(Tickets.of(payment, new ArrayList<>(), new CustomNumbersMaker("1,2,3,4,5,6")));
    }

    @Test
    @DisplayName("Tickets 생성(custom ticket 포함)")
    void create_with_custom() {
        // given
        Payment payment = new Payment(10_000);
        String customNumbers1 = "1, 2, 3, 4, 5, 6";
        String customNumbers2 = "2, 3, 4, 5, 6, 7";
        String customNumbers3 = "1, 2, 3, 4, 5, 6";
        List<String> customTicketsString = new ArrayList<>(Arrays.asList(customNumbers1, customNumbers2, customNumbers3));

        // when
        Tickets tickets = Tickets.of(payment, customTicketsString, new CustomNumbersMaker("4,5,6,7,8,9"));

        // then
        assertThat(tickets).isEqualTo(Tickets.of(payment, customTicketsString, new CustomNumbersMaker("4,5,6,7,8,9")));
        assertThat(tickets.getTickets())
                .contains(Ticket.madeBy(new CustomNumbersMaker(customNumbers1)),
                        Ticket.madeBy(new CustomNumbersMaker(customNumbers2)),
                        Ticket.madeBy(new CustomNumbersMaker(customNumbers3)));
    }

    @Test
    @DisplayName("당첨 결과 계산")
    void checkWinningResult() {
        // given
        Payment payment = new Payment(1_000);
        Tickets tickets = Tickets.of(payment, new ArrayList<>(), new CustomNumbersMaker("1, 2, 3, 4, 5, 6"));

        Ticket firstPrizeTicket = Ticket.madeBy(new CustomNumbersMaker("1, 2, 3, 4, 5, 6"));
        LottoNumber bonusNumber = LottoNumber.of(7);
        WinningTicket winningTicket = new WinningTicket(firstPrizeTicket, bonusNumber);

        // when
        WinningResult winningResult = tickets.checkWinningResult(winningTicket);

        // then
        assertThat(winningResult.get(Prize.FIRST)).isEqualTo(1);
    }
}
