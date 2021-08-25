package Lotto.Ticket;

import Lotto.Helper.Helper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    @DisplayName("로또 티켓 리스트는 n장의 로또 티켓으로 초기화 된다. ")
    @Test
    void createLottoTickets() {
        LottoTickets lottoTickets = new LottoTickets(Helper.lottoTickets());
        assertThat(lottoTickets.getValue().size()).isEqualTo(Helper.lottoTickets().size());
    }
}
