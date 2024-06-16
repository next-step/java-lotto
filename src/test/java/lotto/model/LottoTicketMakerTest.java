package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoTicketMakerTest {
    @Test
    @DisplayName("구입금액을 입력하면 구입할 수 있을 만큼 자동 로또 티켓이 구매된다.")
    void test1() {
        List<LottoTicket> lottoTickets = LottoTicketMaker.purchase(14000);
        assertThat(lottoTickets).hasSize(14);
    }

    @Test
    @DisplayName("구입금액과 수동으로 구매할 티켓 수를 입력하면 남은 금액만큼 자동 구매 티켓 수가 결정된다.")
    void test2() {
//        List<LottoTicket> lottoTickets = LottoTicketMaker.purchase(14000);
//        assertThat(lottoTickets).hasSize(14);
    }

}