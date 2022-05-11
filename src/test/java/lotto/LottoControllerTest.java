package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoControllerTest {
    LotteryController lotteryController = new LotteryController();

    @Test
    void shouldAttachWallet() {
        lotteryController.attachWallet(new Wallet(new Money(14000)));
        assertThat(lotteryController.wallet).isInstanceOf(Wallet.class);
    }


    @Test
    void stringShouldBeInteger() {
        assertThat(lotteryController.toInteger("1")).isEqualTo(1);
    }

    @Test
    void stringOverRange1to45GetError() {
        assertThatThrownBy(() -> lotteryController.toInteger("0")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lotteryController.toInteger("46")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void stringsShouldBeIntegers() {
        assertThat(lotteryController.toIntegers(new String[]{"1", "2"})).isEqualTo(Arrays.asList(1, 2));
    }

    @Test
    void inputNumberSeparatedByCommaShouldReturnListOfInteger() {
        assertThat(lotteryController.parseAnswerNumbers("1, 2 ,  3")).isEqualTo(Arrays.asList(1, 2, 3));
        assertThat(lotteryController.parseAnswerNumbers("6, 11, 18, 22, 24, 38")).isEqualTo(Arrays.asList(6, 11, 18, 22, 24, 38));
    }


    @Test
    void moreThan3WinShouldBeSaved() {
        lotteryController.saveWin(Reward.of(2, false));
        assertThat(lotteryController.winStatistics).isEqualTo(new WinStatistics(0, 0, 0, 0, 0));
        lotteryController.saveWin(Reward.of(3, false));
        assertThat(lotteryController.winStatistics).isEqualTo(new WinStatistics(1, 0, 0, 0, 0));
    }

    @Test
    void findWins() {
        List<Lottery> lotteries = Arrays.asList(new Lottery(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Wallet wallet = new Wallet(lotteries);
        lotteryController.attachWallet(wallet);
        List<Reward> rewards = lotteryController.findWins(new Lottery(Arrays.asList(1, 2, 3, 14, 15, 16)), 0);
        lotteryController.saveWins(rewards);
        assertThat(lotteryController.winStatistics).isEqualTo(new WinStatistics(1, 0, 0, 0, 0));
    }
}
