package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {

    @Test
    @DisplayName("생성성공")
    void createSuccess() {
        List<LottoTicket> lottoTicketss = new ArrayList<>();
        lottoTicketss.add(LottoTicket.from(LottoTicketFactory
            .LottoTicketFactory()
            .createLottoNumber()));

        assertThat(new LottoTickets(lottoTicketss)).isInstanceOf(LottoTickets.class);
    }

}
