package humbledude.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @Test
    public void buyAutoTickets() {
        long budget = 14_023;
        List<LottoNumberSet> lottoTicketList = LottoStore.buyAutoTickets(budget);

        assertThat(lottoTicketList).hasSize(14);
    }

    @Test
    public void howManyCanIBuy() {
        long budget = 14_023;

        assertThat(LottoStore.howManyCanIBuy(budget)).isEqualTo(14);
    }
}
