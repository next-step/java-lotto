package lotto;

import lotto.ticket.PaperTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("구매 한 용지 = 티켓")
class PaperTicketTest {
    PaperTicket paperTicket = new PaperTicket();

    @Test
    @DisplayName("구매 금액만큼의 티켓을 생성")
    void pay() {
        assertThat(paperTicket.generateTickets(4).size()).isEqualTo(4);
    }

    @Test
    @DisplayName("티켓들에 숫자가 입력되었는가")
    void name() {
        assertThat(paperTicket.generateTickets(4).get(0).getLottoNumbers()).isNotEmpty();
    }

    @BeforeEach
    void init() {
        paperTicket = new PaperTicket();
    }
}
