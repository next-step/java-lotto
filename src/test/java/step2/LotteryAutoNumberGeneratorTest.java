package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step2.constant.Prize;
import step2.domain.LotteryMachine;
import step2.domain.StatisticsMachine;
import step2.model.Lotteries;
import step2.model.Lottery;
import step2.model.Winning;
import step2.view.InputView;

class LotteryAutoNumberGeneratorTest {

    @ParameterizedTest
    @CsvSource({"900", "1", "160", "999"})
    void 입력된_금액을_검증하는_테스트(String moneyStr) {
        assertThatThrownBy(() -> InputView.parse(moneyStr)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"14000, 14", "15000, 15", "16000, 16", "17000, 17"})
    void 금액으로_티켓_수량을_구하는_테스트(int money, int tickets) {
        assertThat(LotteryMachine.getTicketCount(money)).isEqualTo(tickets);
    }

    @Test
    void n_번채_공을_꺼내서_숫자를_맞추는_테스트() {
        List<Integer> idx = Arrays.asList(0, 10, 15, 16);
        List<Integer> balls = Arrays.asList(1, 11, 16, 17);

        LotteryMachine.run();
        assertThat(LotteryMachine.getBall(idx)).isEqualTo(balls);
    }

    @Test
    void 공이_잘_섞였는지_확인하는_테스트() {
        List<Integer> idx = Arrays.asList(0, 10, 15, 16);
        List<Integer> balls = Arrays.asList(1, 11, 16, 17);

        LotteryMachine.run();
        assertThat(LotteryMachine.getBall(idx)).isEqualTo(balls);
        LotteryMachine.shuffle();
        assertThat(LotteryMachine.getBall(idx)).isNotEqualTo(balls);
    }

    @Test
    void 추점이_잘_되는지_확인_하는_테스트() {
        List<Integer> idx = Arrays.asList(0, 10, 15, 16, 17, 18);
        List<Integer> balls = Arrays.asList(1, 11, 16, 17, 18, 19);

        LotteryMachine.run();
        Lottery lottery = Lottery.of(LotteryMachine.getBall(idx));
        assertThat(lottery.getNumbers()).isEqualTo(Lottery.of(balls).getNumbers());
    }

    @Test
    void 당첨_확인_하는_테스트() {
        // given
        Lotteries lotteries = new Lotteries();
        List<Integer> hands = Arrays.asList(0, 1, 2, 3, 4, 5);
        Winning win = Winning.from("1, 2, 3, 4, 5, 6");
        LotteryMachine.run();

        // when
        Lottery lottery = Lottery.of(LotteryMachine.getBall(hands));
        lotteries.keep(lottery);
        List<Prize> pirzeList = lotteries.getPirzeList(win);

        // then
        assertThat(pirzeList.get(0)).isEqualTo(Prize.ALL);
    }


    @ParameterizedTest
    @CsvSource({"14000, 5000, 0.35", "15000, 50000, 3.33", "16000, 1500000, 93.75", "17000, 2000000000, 117647.05"})
    void ROI_확인_하는_테스트(int money, int rewards, BigDecimal expectedRoi) {
        StatisticsMachine statisticsMachine = new StatisticsMachine();
        BigDecimal roi = statisticsMachine.getRoi(money, rewards);

        assertThat(roi).isEqualTo(expectedRoi);
    }
}