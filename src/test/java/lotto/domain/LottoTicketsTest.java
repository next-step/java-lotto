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
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(LottoTicket.from(LottoTicketFactory
            .autoLotto()
            .createLottoNumber()));

        assertThat(new LottoTickets(lottoTickets)).isInstanceOf(LottoTickets.class);
    }

}
