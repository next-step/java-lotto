package step2.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.LottoIssuer;
import step2.domain.LottoTicket;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoIssuerTest {

    @Test
    void issueTickets() {
        List<LottoTicket> lottoTickets = new LottoIssuer().issueTickets(3);
        assertThat(lottoTickets.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"3000:3", "10000:10"}, delimiter = ':')
    void issueTicketsByMoney(int money, int tickets) {
        List<LottoTicket> lottoTickets = new LottoIssuer().issueTicketsByMoney(money);
        assertThat(lottoTickets.size()).isEqualTo(tickets);
    }

    @ParameterizedTest
    @ValueSource(ints = {3500, -1000})
    void issueTicketsByMoneyExceptoin(int money) {
        assertThatThrownBy(() -> new LottoIssuer().issueTicketsByMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액은 0원 이상의 1000원 단위여야 합니다.");
    }

}