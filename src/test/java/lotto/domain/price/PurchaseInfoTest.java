package lotto.domain.price;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.util.LottoTicketGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PurchaseInfoTest {

    private LottoTickets manualTickets;
    private LottoTickets autoTickets;

    @BeforeEach
    void setUp() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(LottoTicketGenerator.valueOf(1, 2, 3, 4, 5, 6));
        lottoTickets.add(LottoTicketGenerator.valueOf(1, 2, 3, 7, 8, 9));

        manualTickets = LottoTickets.of(lottoTickets);

        lottoTickets.add(LottoTicketGenerator.valueOf(11, 12, 22, 23, 33, 34));
        autoTickets = LottoTickets.of(lottoTickets);
    }

    @DisplayName("사용자가 구매한 수동, 자동 티켓이 null 이면 예외 발생")
    @Test
    void createFailure() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseInfo.valueOf(null, autoTickets));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseInfo.valueOf(manualTickets, null));
    }

    @DisplayName("사용자가 구매한 수동, 자동 티켓의 정보를 가진 PurchaseInfo 객체 생성")
    @Test
    void create() {
        assertThatCode(() -> PurchaseInfo.valueOf(manualTickets, autoTickets))
                .doesNotThrowAnyException();
    }

    @DisplayName("구매한 manualTickets 개수 반환")
    @Test
    void getManualTicketsCount() {

    }

    @DisplayName("구매한 autoTickets 개수 반환")
    @Test
    void getAutoTicketsCount() {

    }

    @DisplayName("구매한 모든 로또 티켓을 반환")
    @Test
    void getAllTickets() {

    }
}
