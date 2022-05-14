package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoControllerTest {
    LotteryController lotteryController = new LotteryController();

    @Test
    void stringShouldBeInteger() {
        assertThat(lotteryController.toLotteryNumber("1")).isEqualTo(new LotteryNumber(1));
    }

    @Test
    void stringOverRange1to45GetError() {
        assertThatThrownBy(() -> lotteryController.toLotteryNumber("0")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lotteryController.toLotteryNumber("46")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void stringsShouldBeIntegers() {
        assertThat(lotteryController.toLotteryNumbers(new String[]{"1", "2"})).isEqualTo(Lottery.toLotteryNumbers(Arrays.asList(1, 2)));
    }

    @Test
    void inputNumberSeparatedByCommaShouldReturnListOfInteger() {
        assertThat(lotteryController.parseAnswerNumbers("1, 2 ,  3")).isEqualTo(Lottery.toLotteryNumbers(Arrays.asList(1, 2, 3)));
        assertThat(lotteryController.parseAnswerNumbers("6, 11, 18, 22, 24, 38")).isEqualTo(Lottery.toLotteryNumbers(Arrays.asList(6, 11, 18, 22, 24, 38)));
    }


    @Test
    void moreThan3WinShouldBeSaved() {
        lotteryController.saveWin(Reward.of(2, false));
        assertThat(lotteryController.winStatistics).isEqualTo(new WinStatistics(0, 0, 0, 0, 0));
        lotteryController.saveWin(Reward.of(3, false));
        assertThat(lotteryController.winStatistics).isEqualTo(new WinStatistics(1, 0, 0, 0, 0));
    }
}
