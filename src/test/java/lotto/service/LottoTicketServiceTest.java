package lotto.service;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketServiceTest {

    @Test
    public void 로또_서비스를_통해서_실행_시_그만큼의_로또가_생성된다(){
        //given
        LottoService service = new LottoService();
        //when
        LottoTickets lottoTickets = service.execute(4, new LottoGenerator());
        //then
        assertThat(lottoTickets.size()).isEqualTo(4);
    }
}
