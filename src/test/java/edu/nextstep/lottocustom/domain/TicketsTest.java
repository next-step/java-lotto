package edu.nextstep.lottocustom.domain;

import edu.nextstep.lottocustom.domain.numbersmaker.AutoNumbersMaker;
import edu.nextstep.lottocustom.domain.numbersmaker.CustomNumbersMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class TicketsTest {

    @Test
    @DisplayName("Tickets 크기 비교")
    void isSameSize() {
        // given
        Payment payment = new Payment(10_000);

        // when
        Tickets tickets = Tickets.of(payment, new ArrayList<>(), new AutoNumbersMaker());

        // then
        assertThat(tickets.isSameSize(payment.countOfTickets())).isTrue();
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
        Tickets tickets = Tickets.of(payment, customTicketsString, new AutoNumbersMaker());

        // then
        assertThat(tickets.isSameSize(payment.countOfTickets())).isTrue();
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
        Map<Prize, Integer> winningResult = tickets.checkWinningResult(winningTicket);

        // then
        assertThat(winningResult.getOrDefault(Prize.FIRST, 0)).isEqualTo(1);
    }
}
