package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketsTest {
    @Test
    void LottoTickets는_numbers없이_생성시_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new LottoTickets(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void LottoTickets는_빈_numbers로_생성시_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new LottoTickets(Collections.emptyList());
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
