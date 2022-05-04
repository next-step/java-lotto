package lotto;

import org.junit.jupiter.api.Test;

import static lotto.Const.LOTTERY_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WalletTest {

    @Test
    void priceShouldBePositive() {
        // given
        Wallet wallet = new Wallet(14000);
        // when
        int actual = wallet.money;
        // - then
        assertThat(actual).isPositive();
    }

    @Test
    void priceLessThan1000GetsError() {
        // given - when - then
        assertThatThrownBy(() -> new Wallet(999)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Wallet(-1000)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldCreate14Lotteries() {
        // given
        Wallet wallet = new Wallet(14000);
        // when
        wallet.createLotteries();
        // then
        assertThat(wallet.lotteries).hasSize(14);
    }

    @Test
    void buyLotteryShouldTake1000() {
        // given
        Wallet wallet = new Wallet(14000);
        // when
        int expected = wallet.money - LOTTERY_PRICE;
        wallet.buyLottery();
        int actual = wallet.money;
        // then
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void lessThan1000CannotBuyLottery() {
        // given
        Wallet wallet = new Wallet(14000);
        // when
        wallet.money = 999;
        // then
        assertThatThrownBy(() -> wallet.buyLottery()).isInstanceOf(IllegalCallerException.class);
    }
}
