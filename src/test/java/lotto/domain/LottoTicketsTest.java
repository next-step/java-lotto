package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    private static final LottoTicketMaker LOTTO_TICKET_RANDOM_MAKER = new LottoTicketRandomMaker();

    @DisplayName("로또 랜덤 생성 테스트")
    @Test
    void create() {
        int purchaseNumber = 5;
        LottoTickets lottoTickets = LottoTickets.of(BuyCount.of(String.valueOf(purchaseNumber)), LOTTO_TICKET_RANDOM_MAKER);

        assertThat(lottoTickets.number()).isEqualTo(purchaseNumber);
    }
}
