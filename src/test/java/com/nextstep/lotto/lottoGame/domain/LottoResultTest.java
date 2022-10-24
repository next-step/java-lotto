package com.nextstep.lotto.lottoGame.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    void create_getCount() {
        List<LottoTicket> tickets = List.of(
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6)),
                new LottoTicket(List.of(3, 4, 5, 6, 7, 8))
        );
        LottoResult result = new LottoResult(List.of(1, 2, 3, 4, 5, 6), 7, new LottoTickets(tickets));

        assertThat(result.getCount(Rank.FIRST)).isEqualTo(1);
        assertThat(result.getCount(Rank.SECOND)).isEqualTo(0);
        assertThat(result.getCount(Rank.FOURTH)).isEqualTo(1);
    }

    @Test
    void contains() {
        List<LottoTicket> tickets = List.of(
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6)),
                new LottoTicket(List.of(3, 4, 5, 6, 7, 8))
        );
        LottoResult result = new LottoResult(List.of(1, 2, 3, 4, 5, 6), 7, new LottoTickets(tickets));

        assertThat(result.contains(Rank.FIRST)).isTrue();
        assertThat(result.contains(Rank.SECOND)).isFalse();
        assertThat(result.contains(Rank.FOURTH)).isTrue();
    }

    @Test
    void getPrizeSum() {
        List<LottoTicket> tickets = List.of(
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6)),
                new LottoTicket(List.of(3, 4, 5, 6, 7, 8))
        );
        LottoResult result = new LottoResult(List.of(1, 2, 3, 4, 5, 6), 7, new LottoTickets(tickets));

        assertThat(result.getPrizeSum()).isEqualTo(Rank.FIRST.getPrize() + Rank.FOURTH.getPrize());
    }
}