package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTicketTest {

    @DisplayName(value = "티켓 번호가 6개가 생성되었는지 체크")
    @Test
    void 로또_티켓_1개_생성() {
        // given
        LottoTicket lottoTicket = new LottoTicket();

        // when
        LottoTicket autoTicket = lottoTicket.newTicket(new LottoTicketCreation());

        // then
        assertThat(autoTicket.size()).isEqualTo(LottoTicket.LOTTO_TICKET_SIZE);
    }
    
    @DisplayName(value = "티켓 번호가 데이터 정확성 체크")
    @Test
    void 티켓_데이터_정확성() {
        // given
        List<Integer> testTicket = Arrays.asList(31, 45, 30, 22, 21, 1);
        
        // when
        LottoTicket ticket = new LottoTicket().newTicket(
                () -> testTicket
        );
        
        // then
        assertThat(ticket.getTicket()).isEqualTo(testTicket);
    }
}