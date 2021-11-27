package lotto.application;

import lotto.domain.LottoTickets;
import lotto.domain.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketGeneratorTest {


    @DisplayName("로또 티켓의 숫자개수만큼 티켓을 발행한다.")
    @Test
    void generateTicketTest() {
        Price price = Price.of("22000");
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();

        LottoTickets lottoTickets = lottoTicketGenerator.generateTickets(
                price, new AllAutomaticLottoTicketStrategy());

        assertThat(lottoTickets.size()).isEqualTo(price.getNumberOfTickets());
    }

}
