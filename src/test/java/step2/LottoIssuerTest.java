package step2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoIssuerTest {

    @Test
    void issueTickets() {
        List<LottoTicket> lottoTickets = new LottoIssuer().issueTickets(3);
        assertThat(lottoTickets.size()).isEqualTo(3);
    }

    @Test
    void issueTicketsByMoney() {
        List<LottoTicket> lottoTickets = new LottoIssuer().issueTicketsByMoney(3000);
        assertThat(lottoTickets.size()).isEqualTo(3);
    }
}