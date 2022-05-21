package lotto;

import lotto.model.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.Const.LOTTERY_PRICE;
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
        actual = inventory.buyLottery(actual);
        Money expected = new Money(14000 - LOTTERY_PRICE);
        assertThat(actual.hasEqualValue(expected)).isTrue();
    }

    @Test
    void lessThan1000CannotBuyLottery() {
        Money money = new Money(999);
        assertThatThrownBy(() -> new Inventory().buyLottery(money)).isInstanceOf(IllegalCallerException.class);
    }

    @Test
    void findWins() {
        List<Lottery> lotteries = Arrays.asList(new Lottery(Lottery.toLotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))));
        Inventory inventory = new Inventory(lotteries);
        List<Reward> rewards = inventory.findWins(new Winning(new Lottery(Lottery.toLotteryNumbers(Arrays.asList(1, 2, 3, 14, 15, 16))), 7));
        assertThat(rewards).isEqualTo(Arrays.asList(Reward.of(3, false)));
    }
}
