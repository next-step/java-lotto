package lotto;

import org.junit.jupiter.api.Test;

import static lotto.Const.LOTTERY_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WalletTest {
    Wallet wallet = new Wallet(14000);
    @Test
    void priceShouldBePositive() {
        assertThat(wallet.money).isPositive();
    }

    @Test
    void priceLessThan1000GetsError() {
        assertThatThrownBy(() -> new Wallet(999)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Wallet(-1000)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldCreate14Lotteries() {
        wallet.createLotteries();
        assertThat(wallet.lotteries).hasSize(14);
    }

    @Test
    void buyLotteryShouldTake1000() {
        int expected = wallet.money - LOTTERY_PRICE;
        wallet.buyLottery();
        int actual = wallet.money;
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void lessThan1000CannotBuyLottery() {
        wallet.money = 999;
        assertThatThrownBy(()->wallet.buyLottery()).isInstanceOf(IllegalCallerException.class);
    }
}
