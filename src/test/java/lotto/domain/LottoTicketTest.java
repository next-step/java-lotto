package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓의 번호는 6개이다.")
    void createTicket() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1,2,3,4,5,6));
        assertThat(lottoTicket.getLottoNumbers()).hasSize(6);
    }

}
