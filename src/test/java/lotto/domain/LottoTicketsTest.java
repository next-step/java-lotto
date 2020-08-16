package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Test
    void create() {
        int purchaseNumber = 5;
        LottoTickets lottoTickets = LottoTickets.of(5);

        assertThat(lottoTickets.number()).isEqualTo(purchaseNumber);
    }
}
