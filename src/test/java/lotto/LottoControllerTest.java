package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
