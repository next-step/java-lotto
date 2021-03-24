package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 티켓")
class LottoTicketTest {

    @Test
    @DisplayName("로또 발급 확인")
    void createTicketTest() throws Exception {
        //given
        LottoTicket ticket = new LottoTicket(Arrays.asList(1,2,3,4,5,6));

        //when

        //then
        assertThat(ticket).isNotNull();
    }
}
