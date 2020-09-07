package AutoLotto.domain.money;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMoneyTest {

    @Test
    void canMakeBudget() {
        UserMoney userMoney1 = new UserMoney(0);
        UserMoney userMoney2 = new UserMoney(100);
        assertThat(userMoney1.makeBudget()).isEqualTo(0);
        assertThat(userMoney2.makeBudget()).isEqualTo(100);
    }

    @Test
    void checkPlusProfitBy() {
        UserMoney userMoney1 = new UserMoney(14000);
        UserMoney userMoney2 = new UserMoney(1400);
        assertThat(userMoney1.isPlusProfitBy(5000)).isEqualTo(false);
        assertThat(userMoney1.isPlusProfitBy(0)).isEqualTo(false);
        assertThat(userMoney2.isPlusProfitBy(5000)).isEqualTo(true);
    }
}
