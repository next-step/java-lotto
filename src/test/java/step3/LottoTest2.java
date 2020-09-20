package step3;

import org.junit.jupiter.api.Test;
import step3.controller.LottoService;
import step3.domain.LottoTicket;
import step3.domain.LottoTickets;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest2 {
    @Test
    void 자동_로또_6자리 () throws IllegalAccessException {
        LottoService lottoService = new LottoService();
        LottoTicket lottoTicket = lottoService.createLottoNumber();
        assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    void 여러개_자동_로또() throws IllegalAccessException {
        LottoService lottoService = new LottoService();
        LottoTickets lottoTicketList = lottoService.createLottoTicket(7);
//        assertThat(lottoTicketList).isEqualTo(7);
    }
}
