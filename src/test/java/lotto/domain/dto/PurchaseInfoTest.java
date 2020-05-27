package lotto.domain.dto;

import lotto.domain.price.Price;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.exception.AvailableCountExceedException;
import lotto.util.LottoTicketGenerator;
import lotto.util.LottoTicketsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PurchaseInfoTest {

    @DisplayName("Price 가 null 이면 예외 발생")
    @Test
    void createFailure() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseInfo.valueOf(null, LottoTicketsGenerator.newInstance()));
    }

    @DisplayName("Price 와 수동 로또 번호를 인자로 입력받아 객체를 생성")
    @Test
    void create() {
        assertThatCode(() -> PurchaseInfo.valueOf(Price.of(Price.ONE_TICKET_PRICE), LottoTicketsGenerator.newInstance()))
                .doesNotThrowAnyException();
    }

    @DisplayName("수동으로 입력한 로또 티켓이 구매할 수 있는 티켓의 수보다 많으면 예외 반환")
    @Test
    void exceedOfAvailableCount() {
        Price price = Price.of(Price.ONE_TICKET_PRICE);

        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(LottoTicketGenerator.valueOf(1, 2, 3, 4, 5, 6));
        lottoTickets.add(LottoTicketGenerator.valueOf(1, 2, 3, 7, 8, 9));
        LottoTickets manualTickets = LottoTickets.of(lottoTickets);

        assertThatExceptionOfType(AvailableCountExceedException.class)
                .isThrownBy(() -> PurchaseInfo.valueOf(price, manualTickets));
    }
}
