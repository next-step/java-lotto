package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketsTest {

    private LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        lottoTickets = new LottoTickets();
    }

    @Test
    @DisplayName("구매한 로또 복권 개수 확인")
    void purchasedLottoTicket() {
        lottoTickets.purchasedLottoTicket(5);
        assertThat(lottoTickets.count()).isEqualTo(5);
    }

}
