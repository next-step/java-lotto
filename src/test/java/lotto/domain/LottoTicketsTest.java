package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketsTest {

    @ParameterizedTest
    @NullAndEmptySource
    void LottoTickets는_lottoTickets없이_생성시_예외를_발생시킨다(List<LottoTicket> lottoTickets) {
        assertThatThrownBy(() -> {
            new LottoTickets(lottoTickets);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
