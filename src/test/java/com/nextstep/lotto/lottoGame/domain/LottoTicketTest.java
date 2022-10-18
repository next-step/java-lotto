package com.nextstep.lotto.lottoGame.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {

    @Test
    public void create() {
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(new LottoTicket(numbers)).isEqualTo(new LottoTicket(numbers));
    }

    @Test
    public void create_null_or_empty() {
        assertThatThrownBy(() -> new LottoTicket(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoTicket(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void create_invalid() {
        assertThatThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void contains() {
        LottoTicket lotto = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(2)).isTrue();
        assertThat(lotto.contains(7)).isFalse();
    }

    @Test
    public void rank() {
        LottoTicket lotto = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.rank(List.of(1, 2, 3, 4, 5, 6))).isEqualTo(Rank.FIRST);
        assertThat(lotto.rank(List.of(2, 3, 4, 5, 6, 7))).isEqualTo(Rank.SECOND);
        assertThat(lotto.rank(List.of(3, 4, 5, 6, 8, 9))).isEqualTo(Rank.THIRD);
        assertThat(lotto.rank(List.of(7, 8, 9, 10, 11, 12))).isEqualTo(Rank.NONE);
    }
}
