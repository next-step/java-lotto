package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.Const.LOTTERY_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InventoryTest {
    @Test
    void shouldCreate14Lotteries() {
        Money money = new Money(14000);
        Inventory inventory = new Inventory();
        inventory.createLotteries(money);
        assertThat(inventory.getLotteriesSize()).isEqualTo(14);
    }

    @Test
    void buyLotteryShouldTake1000() {
        Money actual = new Money(14000);
        Inventory inventory = new Inventory();
        inventory.buyLottery(actual);
        Money expected = new Money(14000 - LOTTERY_PRICE);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void lessThan1000CannotBuyLottery() {
        Money money = new Money(999);
        assertThatThrownBy(() -> new Inventory().buyLottery(money)).isInstanceOf(IllegalCallerException.class);
    }

    @Test
    void findWins() {
        List<Lottery> lotteries = Arrays.asList(new Lottery(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Inventory inventory = new Inventory(lotteries);
        List<Reward> rewards = inventory.findWins(new Winning(new Lottery(Arrays.asList(1, 2, 3, 14, 15, 16)), 0));
        assertThat(rewards).isEqualTo(Arrays.asList(Reward.of(3,false)));
    }
}
