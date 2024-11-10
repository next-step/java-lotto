package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketMaker;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketMakerTest {
    @Test
    @DisplayName("수동으로 구매할 로또 수가 총 로또 수보다 많은 경우 예외 발생")
    void buyLottoTicketsException() {
        int price = 1000;
        List<LottoTicket> manualNumbers = List.of(new LottoTicket(1, 2, 3, 4, 5, 6),
                                                  new LottoTicket(7, 8, 9, 10, 11, 12),
                                                  new LottoTicket(13, 14, 15, 16, 17, 18));
        assertThatThrownBy(() -> LottoTicketMaker.buy(price, manualNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("수동으로 구매할 로또 수가 총 로또 수보다 많습니다.");
    }

    @DisplayName("전체 로또 티켓 생성 확인")
    @Test
    void buyLottoTickets() {
        int price = 12000;
        List<LottoTicket> manualNumbers = List.of(new LottoTicket(1, 2, 3, 4, 5, 6),
                                                  new LottoTicket(7, 8, 9, 10, 11, 12));
        LottoTickets allTickets = LottoTicketMaker.buy(price, manualNumbers);
        assertThat(allTickets.size()).isEqualTo(12);
    }
}
