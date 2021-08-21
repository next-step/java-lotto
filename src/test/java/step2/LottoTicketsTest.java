package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Test
    @DisplayName("구매한 로또 티켓 전부를 저장한다.")
    void lottoTickets_save_test() {
        LottoTickets lottoTickets = new LottoTickets();

        // 로또 번호 생성
        Ticket lottoNumbers1 = new Ticket();
        lottoNumbers1.saveLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        Ticket lottoNumbers2 = new Ticket();
        lottoNumbers2.saveLottoNumbers(Arrays.asList(11, 12, 13, 14, 15, 16));

        Ticket lottoNumbers3 = new Ticket();
        lottoNumbers3.saveLottoNumbers(Arrays.asList(21, 22, 23, 24, 25, 26));

        lottoTickets.addLottoTicket(lottoNumbers1);
        lottoTickets.addLottoTicket(lottoNumbers2);
        lottoTickets.addLottoTicket(lottoNumbers3);

        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(3);
        assertThat(lottoTickets.getLottoTickets().get(0)).isEqualTo(lottoNumbers1);
        assertThat(lottoTickets.getLottoTickets().get(1)).isEqualTo(lottoNumbers2);
        assertThat(lottoTickets.getLottoTickets().get(2)).isEqualTo(lottoNumbers3);
    }
}
