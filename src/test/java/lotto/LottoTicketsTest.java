package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {

    @Test
    @DisplayName("create")
    void create() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        LottoTickets lottoTickets = new LottoTickets(List.of(lottoTicket));
        assertThat(lottoTickets).isNotNull();
    }


}
