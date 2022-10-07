package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {

    @Test
    @DisplayName("로또 개수만큼 발급할 수 있다.")
    void create() {
        LottoTickets lottoTickets = new LottoTickets(14000);
        Assertions.assertThat(lottoTickets.createTickets()).isEqualTo(14);
    }
}
