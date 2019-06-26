package com.java.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsGeneratorTest {

    @Test
    void 자동으로_로또_티켓_입력한_값만큼_생성() {
        int amount = 5;
        LottoTickets tickets = LottoTicketsGenerator.automaticTicketsGenerator(amount);
        assertThat(tickets.amount()).isEqualTo(amount);
    }
}
