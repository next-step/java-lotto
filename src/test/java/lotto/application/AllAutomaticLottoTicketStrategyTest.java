package lotto.application;

import lotto.domain.LottoTicket;
import lotto.domain.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AllAutomaticLottoTicketStrategyTest {

    private GenerateLottoTicketStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new AllAutomaticLottoTicketStrategy();
    }

    @DisplayName("로또 티켓의 숫자개수만큼 티켓을 발행한다.")
    @Test
    void generateLottoTicketsFromTicketCount() {
        Price price = Price.of("22000");

        List<LottoTicket> lottoTickets = strategy.publishTickets(price);

        assertThat(lottoTickets.size()).isEqualTo(price.getNumberOfTickets());
    }


}