package step3;

import org.junit.jupiter.api.Test;
import step3.controller.LottoService;
import step3.domain.LottoTicket;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest2 {
    @Test
    void 자동_로또_6자리 () throws IllegalAccessException {
        LottoService lottoService = new LottoService();
        LottoTicket lottoTicket = lottoService.createLottoNumber();
        assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    void 여러개_자동_로또() {
        LottoService lottoService = new LottoService();
//        List<LottoTicket>
    }
}
