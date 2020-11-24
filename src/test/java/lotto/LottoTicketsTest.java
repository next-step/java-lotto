package lotto;

import lotto.model.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Test
    @DisplayName("티켓 생성 개수 테스트")
    public void countTicketTest(){
        LottoTickets lottoTickets = LottoTickets.of(3);
        assertThat(lottoTickets.getTicketCount()).isEqualTo(3);
    }
}
