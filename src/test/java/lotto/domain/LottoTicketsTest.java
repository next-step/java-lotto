package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static lotto.domain.LottoTicketFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {
    @DisplayName("LottoTicket 컬렉션을 인자로 받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        List<LottoTicket> lottoTickets = Arrays.asList(LOTTO_TICKET_123456, LOTTO_TICKET_234567);

        assertThat(new LottoTickets(lottoTickets)).isNotNull();
    }

    @DisplayName("당첨 LottoTicket을 인자로 전달해서 당첨 결과를 확인할 수 있다.")
    @Test
    void checkResultTest() {
        List<LottoTicket> boughtTickets = Arrays.asList(LOTTO_TICKET_123456, LOTTO_TICKET_101112131415);
        LottoTickets lottoTickets = new LottoTickets(boughtTickets);

        List<Rank> ranks = Collections.singletonList(Rank.FIRST);

        assertThat(lottoTickets.checkResult(LOTTO_TICKET_123456)).isEqualTo(new LottoPrize(ranks));
    }
}
