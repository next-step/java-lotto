package step2.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.LottoIssuer;
import step2.domain.LottoTicket;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoIssuerTest {

    @Test
    void issueTickets() {
        List<LottoTicket> lottoTickets = new LottoIssuer().issueTickets(3);
        assertThat(lottoTickets.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"3000:3", "3500:3"}, delimiter = ':')
    void issueTicketsByMoney(int money, int tickets) {
        List<LottoTicket> lottoTickets = new LottoIssuer().issueTicketsByMoney(money);
        assertThat(lottoTickets.size()).isEqualTo(tickets);
    }

}