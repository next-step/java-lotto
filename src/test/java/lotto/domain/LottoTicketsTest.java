package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


class LottoTicketsTest {

    @Test
    void generateLottoTickets() {
        LottoTickets lottoTickets = new LottoTickets(new ArrayList<>());

        // 수동 로또 3개
        LottoTicket manualLotto1 = new LottoTicket(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket manualLotto2 = new LottoTicket(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket manualLotto3 = new LottoTicket(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoTickets.add(manualLotto1);
        lottoTickets.add(manualLotto2);
        lottoTickets.add(manualLotto3);

        // 자동 로또 3개
        lottoTickets.generateLottoTickets(3);

        // 수동 로또 3개 + 자동 로또 3개 = 6개
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(6);
    }

}
