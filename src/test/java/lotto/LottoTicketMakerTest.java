package lotto;

import lotto.domain.LottoTicketMaker;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketMakerTest {
    @DisplayName("수동 로또 티켓 생성 테스트")
    @Test
    void createManualLottoTickets() {
        int price = 12000;
        List<String> manualNumbers = List.of("1,2,3,4,5,6", "7,8,9,10,11,12");
        LottoTicketMaker lottoTicketMaker = new LottoTicketMaker(price, manualNumbers);

        LottoTickets manualTickets = lottoTicketMaker.createManualLottoTickets();

        assertThat(manualTickets.size()).isEqualTo(2);
    }

    @DisplayName("자동 로또 티켓 생성 테스트")
    @Test
    void createAutoLottoTickets() {
        int price = 12000;
        List<String> manualNumbers = List.of("1,2,3,4,5,6");
        LottoTicketMaker lottoTicketMaker = new LottoTicketMaker(price, manualNumbers);

        LottoTickets autoTickets = lottoTicketMaker.createAutoLottoTickets();

        assertThat(autoTickets.size()).isEqualTo(11);
    }
}
