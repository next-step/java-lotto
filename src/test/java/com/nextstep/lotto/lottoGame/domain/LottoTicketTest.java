package com.nextstep.lotto.lottoGame.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    public void create() {
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(new LottoTicket(numbers)).isEqualTo(new LottoTicket(numbers));
    }

    @Test
    public void contains() {
        LottoTicket lotto = new LottoTicket(List.of(1,2,3,4,5,6));
        assertThat(lotto.contains(2)).isTrue();
        assertThat(lotto.contains(7)).isFalse();
    }

    @Test
    public void rank_1위() {
        LottoTicket lotto = new LottoTicket(List.of(1,2,3,4,5,6));
        assertThat(lotto.rank(List.of(1,2,3,4,5,6))).isEqualTo(Rank.FIRST);
    }
}
