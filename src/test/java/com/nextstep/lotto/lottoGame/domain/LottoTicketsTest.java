package com.nextstep.lotto.lottoGame.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @Test
    void create() {
        LottoTickets tickets = new LottoTickets(List.of(
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6)),
                new LottoTicket(List.of(3, 4, 5, 6, 7, 8))
        ));

        assertThat(tickets.getTickets()).isUnmodifiable();
        assertThat(tickets.getSize()).isEqualTo(2);
    }

    @Test
    void ofBudget() {
        LottoTickets tickets = LottoTickets.ofBudget(123450);
        assertThat(tickets.getSize()).isEqualTo(123);
        assertThat(tickets.getUsedBudget()).isEqualTo(LottoTicket.LOTTO_TICKET_PRICE * 123);
    }
}