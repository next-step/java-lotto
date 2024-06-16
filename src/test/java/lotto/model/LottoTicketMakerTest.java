package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoTicketMakerTest {
    @Test
    @DisplayName("티켓 수를 입력하면 입력한 수만큼 자동 로또 티켓이 구매된다.")
    void test1() {
        List<LottoTicket> lottoTickets = LottoTicketMaker.purchase(100);
        assertThat(lottoTickets).hasSize(100);
    }

}