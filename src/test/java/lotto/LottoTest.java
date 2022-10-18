package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.Ticket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void convertAmountToTicketCount() {
        int amount = 14000;

        assertThat(Lotto.convertAmountToTicketCount(amount)).isEqualTo(14);
    }

    @Test
    void getTicketCount() {
        int amount = 14000;
        Lotto lotto = new Lotto(amount);

        assertThat(lotto.getTicketCount()).isEqualTo(14);
    }

    @Test
    void generateLottoNumbers() {
        int rangeNumberMin = 1;
        int rangeNumberMax = 45;
        List<Integer> lottoNumbers = LottoNumberGenerator.generate();
        System.out.printf("lottoNumbers : %s\r\n", lottoNumbers);
        assertThat(lottoNumbers).hasSize(6);
        assertThat(lottoNumbers.get(0) >= rangeNumberMin).isTrue();
        assertThat(lottoNumbers.get(5) <= rangeNumberMax).isTrue();
    }

    @Test
    void makeTicketList() {
        List<Ticket> lottoTickets = Lotto.makeTicketList(5);

        assertThat(lottoTickets).hasSize(5);
    }

    @Test
    void getTicketList() {
        int amount = 14000;
        Lotto lotto = new Lotto(amount);

        assertThat(lotto.getTicketList()).hasSize(14);
    }
}
