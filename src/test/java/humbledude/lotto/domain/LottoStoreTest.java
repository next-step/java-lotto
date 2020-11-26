package humbledude.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @Test
    public void buyAutoTickets() {
        Budget budget = new Budget(14_023);
        List<LottoNumbers> lottoTicketList = LottoStore.buyAutoTickets(budget);

        assertThat(lottoTicketList).hasSize(14);
    }
}
