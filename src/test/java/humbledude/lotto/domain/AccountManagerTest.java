package humbledude.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountManagerTest {

    @Test
    public void profitRate() {
        AccountManager accountManager = new AccountManager();

        accountManager.addSpent(10_000);
        accountManager.addPrize(LottoPrize.FOURTH.getPrize());

        assertThat(accountManager.getProfitRate()).isEqualTo(0.5);
    }
}
