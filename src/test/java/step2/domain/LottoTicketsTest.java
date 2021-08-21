package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Test
    @DisplayName("구매한 로또 티켓 전부를 저장한다.")
    void lottoTickets_save_test() {
        LottoTickets lottoTickets = new LottoTickets();

        AutoLottoNumbersGenerator lottoNumbersGenerator = new AutoLottoNumbersGenerator();
        lottoTickets.addLottoTicket(lottoNumbersGenerator);
        lottoTickets.addLottoTicket(lottoNumbersGenerator);
        lottoTickets.addLottoTicket(lottoNumbersGenerator);

        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(3);
    }
}
