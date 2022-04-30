package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoControllerTest {
    LotteryController lottoController = new LotteryController(14000);

    @Test
    void shouldCreateMoney() {
        assertThat(lottoController.money).isInstanceOf(Money.class);
    }

    @Test
    void numberOfLotteriesShouldBeMoneyDivide1000() {
        assertThat(lottoController.getNumberOfLotteries()).isEqualTo(lottoController.money.price / 1000);
    }

    @Test
    void shouldCreate14Lotteries() {
        lottoController.createLotteries();
        assertThat(lottoController.lotteries).hasSize(14);
    }

    @Test
    void stringShouldBeInteger() {
        assertThat(lottoController.toInteger("1")).isEqualTo(1);
    }

    @Test
    void stringOverRange1to45GetError() {
        assertThatThrownBy(() -> lottoController.toInteger("0")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lottoController.toInteger("46")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void stringsShouldBeIntegers() {
        assertThat(lottoController.toIntegers(new String[]{"1", "2"})).isEqualTo(Arrays.asList(1, 2));
    }

    @Test
    void inputNumberSeparatedByCommaShouldReturnListOfInteger() {
        assertThat(lottoController.parseAnswerNumbers("1, 2 ,  3")).isEqualTo(Arrays.asList(1, 2, 3));
        assertThat(lottoController.parseAnswerNumbers("6, 11, 18, 22, 24, 38")).isEqualTo(Arrays.asList(6, 11, 18, 22, 24, 38));
    }

    @Test
    void findWin() {
        List<Integer> lottery = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> answerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        lottoController.findWin(lottery, answerNumber);
        assertThat(lottoController.winStatistics).isEqualTo(new WinStatistics(0, 0, 0, 1));
    }
}
