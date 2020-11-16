package humbledude.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountManagerTest {

    private LottoStore store;
    private List<LottoTicket> tickets;

    @BeforeEach
    public void setUp() {
        store = new LottoStore();
        store.setWinningNumbers(new LottoWinningNumbers(
                TestHelper.setOf(1, 2, 3, 4, 5, 6)));

        // 미리 당첨 안되는거 9개 넣어놓기
        tickets = new ArrayList<>();
        IntStream.range(0, 9)
                .forEach(i -> tickets.add(new LottoTicket(TestHelper.setOf(11, 12, 13, 14, 15, 16))));
    }

    @Test
    public void profitRate() {
        AccountManager accountManager = new AccountManager();

        // 미리 넣어놓은 당첨 안된거 9개 + 5000원 당첨 1개
        tickets.add(new LottoTicket(TestHelper.setOf(1, 2, 3, 14, 15, 16)));
        accountManager.addTickets(tickets);
        accountManager.claimPrize(store);

        assertThat(accountManager.getProfitRate()).isEqualTo(0.5);
    }
}
