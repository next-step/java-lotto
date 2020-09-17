package step3;

import org.junit.jupiter.api.Test;
import step3.controller.FindMatchNumber;
import step3.controller.LottoService;
import step3.controller.Rank;
import step3.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<LottoTicket> lottoTicketList = lottoService.createLottoTicket(7);
        assertThat(lottoTicketList.size()).isEqualTo(7);
    }
}
