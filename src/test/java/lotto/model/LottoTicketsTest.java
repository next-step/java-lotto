package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @DisplayName("로또티켓 N개 자동번호 생성")
    @ParameterizedTest
    @ValueSource(ints = {0,1,10})
    void 로또티켓_N개_생성(int input) {
        LottoTickets lottoTickets = new LottoTickets(input);
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();
        assertThat(lottoTicketList.size()).isEqualTo(input);

    }

}
