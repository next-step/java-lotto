package com.nextstep.lotto.lottoGame.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @Test
    void buyTicketsWithManual() {
        LottoTickets tickets = LottoStore.buyTicketsWithManual(123450, List.of(
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6)),
                new LottoTicket(List.of(3, 4, 5, 6, 7, 8))
        ));
        assertThat(tickets.getSize()).isEqualTo(123);
        assertThat(tickets.getUsedBudget()).isEqualTo(LottoTicket.LOTTO_TICKET_PRICE * 123);
    }
}
