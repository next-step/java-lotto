package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        assertThatThrownBy(()->lottoController.toInteger("0")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->lottoController.toInteger("46")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void stringsShouldBeIntegers() {
        assertThat(lottoController.toIntegers(new String[]{"1","2"})).isEqualTo(Arrays.asList(1,2));
    }

    @Test
    void parseAnswerNumbers() {
        assertThat(lottoController.parseAnswerNumbers("1, 2 ,  3")).isEqualTo(Arrays.asList(1,2,3));
    }
}
