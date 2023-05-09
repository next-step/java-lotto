package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoGameTest {
    private static final int PRICE_PER_TICKET = 1000;

    @DisplayName("로또 게임 생성")
    @Test
    void createTest() {
        assertThatCode(() -> new LottoGame(
                Money.of("1000")
        )).doesNotThrowAnyException();
    }

    @DisplayName("1000 원에 1장의 로또티켓을 구매한다.")
    @Test
    void ticketCountTest() {
        int buyCount = 3;
        int moneyAmount = buyCount * PRICE_PER_TICKET;

        final int ticketCount = new LottoGame(Money.of(moneyAmount))
                .getTicketCount();
        assertThat(ticketCount).isEqualTo(buyCount);

        final List<LottoTicket> lottoTickets = new LottoGame(Money.of(moneyAmount))
                .getLottoTickets();
        assertThat(lottoTickets.size()).isEqualTo(buyCount);
    }
}
