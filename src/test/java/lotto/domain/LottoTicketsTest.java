package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Test
    @DisplayName("다수의 로또 티켓 저장")
    public void add() throws Exception {
        LottoTickets lottoTickets = new LottoTickets(new ArrayList<>());
        lottoTickets.add(new LottoTicket(new LottoNumbers()));
        lottoTickets.add(new LottoTicket(new LottoNumbers()));
        assertThat(lottoTickets.lottoTickets()).hasSize(2);
    }
}
