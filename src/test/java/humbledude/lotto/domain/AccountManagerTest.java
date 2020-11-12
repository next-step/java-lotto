package humbledude.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountManagerTest {

    @Test
    public void profitRate() {
        AccountManager accountManager = new AccountManager();

        accountManager.addSpent(10_000);
        accountManager.addPrize(LottoPrize.FOURTH.getPrize());

        assertThat(accountManager.getProfitRate()).isEqualTo(0.5);
    }

    @Test
    public void addPrize_multipleTicketResult() {
        AccountManager accountManager = new AccountManager();

        accountManager.addSpent(20_000);
        LottoTicket fakeTicket = new LottoTicket(LottoNumbers.of(1, 2, 3, 4, 5, 6));
        Map<LottoPrize, List<LottoTicket>> result = new HashMap() {{
            // 5000 + 50000 = 55000
            put(LottoPrize.FOURTH, Arrays.asList(fakeTicket));
            put(LottoPrize. THIRD, Arrays.asList(fakeTicket));
        }};
        accountManager.addPrize(result);

        // 55000 / 20000 = 2.75
        assertThat(accountManager.getProfitRate()).isEqualTo(2.75);
    }
}
